package org.example.hobbycatalog.service;

import org.example.hobbycatalog.DTO.AuthRequestDTO;
import org.example.hobbycatalog.DTO.AuthResponseDTO;
import org.example.hobbycatalog.DTO.RegistUserDTO;
import org.springframework.stereotype.Service;

@Service
public class SecurityTokenService {

    private UsersInfoService  usersInfoService;

    public SecurityTokenService(UsersInfoService usersInfoService) {
        this.usersInfoService = usersInfoService;
    }

    public AuthResponseDTO loginUser(AuthRequestDTO authRequestDTO)
    {
        return new AuthResponseDTO();
    }

    public AuthResponseDTO registerUser(RegistUserDTO requestDTO)
    {
        return usersInfoService.register(requestDTO);

    }
    public AuthResponseDTO refreshUser(String refreshToken)
    {
        return new AuthResponseDTO();

    }
}
