package org.example.hobbycatalog.service;

import lombok.extern.slf4j.Slf4j;
import org.example.hobbycatalog.DTO.*;
import org.example.hobbycatalog.entity.*;
import org.example.hobbycatalog.exceptions.ItemNotFoundException;
import org.example.hobbycatalog.mapper.HobbiesMapper;
import org.example.hobbycatalog.repository.CartRepository;
import org.example.hobbycatalog.repository.HobbiesRepository;
import org.example.hobbycatalog.repository.UsersInfoRepository;
import org.example.hobbycatalog.repository.WalletRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CartService {

    private final CartRepository cartRepository;
    private final HobbiesRepository hobbiesRepository;
    private final UsersInfoRepository usersInfoRepository;
    private final WalletRepository walletRepository;
    private final HobbiesMapper hobbiesMapper;

    public CartService(CartRepository cartRepository,
                       HobbiesRepository hobbiesRepository,
                       UsersInfoRepository usersInfoRepository,
                       WalletRepository walletRepository,
                       HobbiesMapper hobbiesMapper) {
        this.cartRepository = cartRepository;
        this.hobbiesRepository = hobbiesRepository;
        this.usersInfoRepository = usersInfoRepository;
        this.walletRepository = walletRepository;
        this.hobbiesMapper = hobbiesMapper;
    }

    private UsersInfo getCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String email = userDetails.getUsername();
        return usersInfoRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    private Cart getCurrentUserCart() {
        UsersInfo user = getCurrentUser();

        // Ищем корзину пользователя
        Cart cart = cartRepository.findByUsersInfo_IdUser(user.getIdUser())
                .orElse(null);

        if (cart == null) {
            cart = new Cart();
            cart.setUsersInfo(Set.of(user));
            cart.setHobbies(new HashSet<>());
            cart.setAmount(0);
            cart = cartRepository.save(cart);
            log.info("Created new cart for user: {}", user.getEmail());
        }
        return cart;
    }

    // Просмотр всех товаров в корзине
    @Transactional(readOnly = true)
    public CartDTO getCart() {
        Cart cart = getCurrentUserCart();
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId_cart(cart.getId_cart());
        cartDTO.setAmount(cart.getAmount());

        Set<HobbyDTO> hobbyDTOs = cart.getHobbies().stream()
                .map(hobbiesMapper::toDTO)
                .collect(Collectors.toSet());
        cartDTO.setHobbies(hobbyDTOs);

        return cartDTO;
    }

    // Добавление товара в корзину
    @Transactional
    public CartDTO addItemToCart(Long hobbyId, int quantity) {
        Cart cart = getCurrentUserCart();

        Hobbies hobby = hobbiesRepository.findById(hobbyId)
                .orElseThrow(() -> new ItemNotFoundException("Hobby not found with id: " + hobbyId));

        // Проверяем, есть ли уже товар в корзине
        boolean alreadyExists = cart.getHobbies().stream()
                .anyMatch(h -> h.getIdHobby().equals(hobbyId));

        if (!alreadyExists) {
            cart.getHobbies().add(hobby);
            cart.setAmount(cart.getAmount() + (int) (hobby.getPrice() * quantity));
            cartRepository.save(cart);
            log.info("Added hobby {} to cart for user {}", hobby.getName(), getCurrentUser().getEmail());
        } else {
            log.info("Hobby {} already in cart for user {}", hobby.getName(), getCurrentUser().getEmail());
        }

        return getCart();
    }

    // Изменение количества товара (если нужно)
    @Transactional
    public CartDTO updateItemQuantity(Long hobbyId, int quantity) {
        Cart cart = getCurrentUserCart();

        Hobbies hobby = cart.getHobbies().stream()
                .filter(h -> h.getIdHobby().equals(hobbyId))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Hobby not found in cart"));

        // Пересчитываем общую сумму
        int oldTotal = cart.getAmount();
        int newTotal = oldTotal - (int) hobby.getPrice() + (int) (hobby.getPrice() * quantity);
        cart.setAmount(newTotal);

        cartRepository.save(cart);
        log.info("Updated quantity of hobby {} in cart for user {}", hobby.getName(), getCurrentUser().getEmail());

        return getCart();
    }

    // Удаление товара из корзины
    @Transactional
    public CartDTO deleteItemFromCart(Long hobbyId) {
        Cart cart = getCurrentUserCart();

        Hobbies hobby = cart.getHobbies().stream()
                .filter(h -> h.getIdHobby().equals(hobbyId))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Hobby not found in cart"));

        cart.getHobbies().remove(hobby);
        cart.setAmount(cart.getAmount() - (int) hobby.getPrice());
        cartRepository.save(cart);

        log.info("Removed hobby {} from cart for user {}", hobby.getName(), getCurrentUser().getEmail());
        return getCart();
    }

    // Очистка корзины
    @Transactional
    public CartDTO clearCart() {
        Cart cart = getCurrentUserCart();
        cart.getHobbies().clear();
        cart.setAmount(0);
        cartRepository.save(cart);

        log.info("Cleared cart for user {}", getCurrentUser().getEmail());
        return getCart();
    }

    // Покупка товаров (расширенная версия)
    @Transactional
    public PurchaseResponseDTO purchaseItems(PurchaseDTO purchaseDTO) {
        UsersInfo user = getCurrentUser();
        Cart cart = getCurrentUserCart();

        if (cart.getHobbies().isEmpty()) {
            throw new RuntimeException("Cart is empty. Nothing to purchase.");
        }

        List<Hobbies> itemsToPurchase = new ArrayList<>();
        int totalAmount = 0;

        // Определяем, какие товары покупаем
        if (purchaseDTO.isPurchaseAll() || purchaseDTO.getHobbyIds() == null || purchaseDTO.getHobbyIds().isEmpty()) {
            // Покупаем все товары в корзине
            itemsToPurchase.addAll(cart.getHobbies());
            totalAmount = cart.getAmount();
            log.info("User {} is purchasing all items in cart", user.getEmail());
        } else {
            // Покупаем только выбранные товары
            for (Long hobbyId : purchaseDTO.getHobbyIds()) {
                Hobbies hobby = cart.getHobbies().stream()
                        .filter(h -> h.getIdHobby().equals(hobbyId))
                        .findFirst()
                        .orElseThrow(() -> new ItemNotFoundException("Hobby with id " + hobbyId + " not found in cart"));
                itemsToPurchase.add(hobby);
                totalAmount += hobby.getPrice();
            }
            log.info("User {} is purchasing selected items: {}", user.getEmail(), purchaseDTO.getHobbyIds());
        }


        // Проверяем достаточно ли средств
        if (user.getBalance_amount() < totalAmount) {
            throw new RuntimeException("Insufficient balance. Need: " + totalAmount +
                    ", Available: " + user.getBalance_amount());
        }

        // Списываем средства
        user.setBalance_amount(user.getBalance_amount() - totalAmount);

        // Удаляем купленные товары из корзины
        cart.getHobbies().removeAll(itemsToPurchase);
        cart.setAmount(cart.getAmount() - totalAmount);

        usersInfoRepository.save(user);
        cartRepository.save(cart);

        // Формируем ответ
        List<HobbyDTO> purchasedItems = itemsToPurchase.stream()
                .map(hobbiesMapper::toDTO)
                .collect(Collectors.toList());

        log.info("User {} purchased items for {}. Remaining balance: {}",
                user.getEmail(), totalAmount, user.getBalance_amount());

        return new PurchaseResponseDTO(
                "Purchase successful!",
                totalAmount,
                user.getBalance_amount(),
                purchasedItems
        );
    }
}