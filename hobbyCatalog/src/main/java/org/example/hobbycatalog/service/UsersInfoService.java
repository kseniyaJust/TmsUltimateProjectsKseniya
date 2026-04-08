package org.example.hobbycatalog.service;

import org.example.hobbycatalog.DTO.AuthRequestDTO;
import org.example.hobbycatalog.DTO.AuthResponseDTO;
import org.example.hobbycatalog.DTO.RegistUserDTO;
import org.example.hobbycatalog.entity.UsersInfo;
import org.example.hobbycatalog.enumpackage.Role;
import org.example.hobbycatalog.exceptions.ConflictException;
import org.example.hobbycatalog.exceptions.ItemNotFoundException;
import org.example.hobbycatalog.mapper.UsersInfoMapper;
import org.example.hobbycatalog.repository.UsersInfoRepository;
import org.springframework.stereotype.Service;


@Service
public class UsersInfoService {
    private final UsersInfoRepository userRepository;
    private final UsersInfoMapper userMapper;

    public UsersInfoService(UsersInfoRepository userRepository, UsersInfoMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public AuthResponseDTO register(RegistUserDTO registerRequest) {

        // Добавляем проверку на существующий email
        checkEmailExists(registerRequest.getEmail());

        UsersInfo userInfo = userMapper.toEntityRegist(registerRequest);
        userInfo.setPassword(registerRequest.getPassword());
        userInfo.setRole(Role.USER); // Устанавливаем роль по умолчанию

        userRepository.save(userInfo);

        return new AuthResponseDTO("Its working","Hooray");
    }

    public UsersInfo getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ItemNotFoundException("User not found with email: " + email));
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws ItemNotFoundException {
//        UserInfo user = getUserByEmail(email);
//        return new CustomUserDetails(user);
//    }

    private void checkEmailExists(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new ConflictException("User with email " + email + " already exists");
        }
    }
}
