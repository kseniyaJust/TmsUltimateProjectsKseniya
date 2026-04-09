package org.example.hobbycatalog.service;

import lombok.extern.slf4j.Slf4j;
import org.example.hobbycatalog.DTO.AuthRequestDTO;
import org.example.hobbycatalog.DTO.AuthResponseDTO;
import org.example.hobbycatalog.DTO.RegistUserDTO;
import org.example.hobbycatalog.DTO.UserDTO;
import org.example.hobbycatalog.entity.UsersInfo;
import org.example.hobbycatalog.enumpackage.Role;
import org.example.hobbycatalog.exceptions.ConflictException;
import org.example.hobbycatalog.exceptions.ItemNotFoundException;
import org.example.hobbycatalog.mapper.UsersInfoMapper;
import org.example.hobbycatalog.repository.UsersInfoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Slf4j
@Service
public class UsersInfoService implements UserDetailsService {
    private final UsersInfoRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsersInfoMapper userMapper;

    public UsersInfoService(UsersInfoRepository userRepository, UsersInfoMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegistUserDTO registerRequest) {

        // Добавляем проверку на существующий email
        checkEmailExists(registerRequest.getEmail());

        UsersInfo userInfo = userMapper.toEntityRegist(registerRequest);
        userInfo.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userInfo.setRole(Role.USER); // Устанавливаем роль по умолчанию

        userRepository.save(userInfo);

        return "You were registered. Log in your account";
    }

    public UsersInfo getUserByEmail(String email) {
        log.info("Find by email in users info");
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ItemNotFoundException("User not found with email: " + email));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsersInfo user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(Collections.emptyList()) // или ваши роли
                .build();
    }

    private void checkEmailExists(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new ConflictException("User with email " + email + " already exists");
        }
    }
}
