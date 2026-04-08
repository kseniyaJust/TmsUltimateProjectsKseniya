package org.example.hobbycatalog.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.example.hobbycatalog.DTO.AuthRequestDTO;
import org.example.hobbycatalog.DTO.AuthResponseDTO;
import org.example.hobbycatalog.DTO.RegistUserDTO;
import org.example.hobbycatalog.service.SecurityTokenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/info")
public class UsersInfoController {

    SecurityTokenService securityTokenService;

    public UsersInfoController(SecurityTokenService securityTokenService) {
        this.securityTokenService = securityTokenService;
    }

    @PostMapping
    public AuthResponseDTO registUser( @Valid @RequestBody RegistUserDTO usersInfoDTO) {
        return securityTokenService.registerUser(usersInfoDTO);
    }

    @GetMapping
    public AuthResponseDTO loginUser(@Valid @RequestBody AuthRequestDTO authRequestDTO) {

        return securityTokenService.loginUser(authRequestDTO);
    }

    @PutMapping
    public AuthResponseDTO refreshToken(@NotEmpty @RequestBody String refreshToken) {
        return securityTokenService.refreshUser(refreshToken);
    }
}
