package org.example.hobbycatalog.repository;

import org.example.hobbycatalog.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet,Long> {
    List<Wallet> findByUsersInfo_wallet_IdUser(Long userId);

    // Найти кошелек по ID и ID пользователя (для проверки владельца)
    Optional<Wallet> findByIdWalletAndUsersInfo_wallet_IdUser(Long walletId, Long userId);

    // Проверить существование кошелька у пользователя
    boolean existsByIdWalletAndUsersInfo_wallet_IdUser(Long walletId, Long userId);
}
