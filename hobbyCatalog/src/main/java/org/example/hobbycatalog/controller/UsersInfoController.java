package org.example.hobbycatalog.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.example.hobbycatalog.DTO.AuthRequestDTO;
import org.example.hobbycatalog.DTO.AuthResponseDTO;
import org.example.hobbycatalog.DTO.UsersInfoDTO;
import org.example.hobbycatalog.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/info")
public class UsersInfoController {

    AuthService authService;

    public UsersInfoController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public AuthResponseDTO registUser( @Valid @RequestBody UsersInfoDTO usersInfoDTO) {
        return authService.registerUser(usersInfoDTO);
    }

    @GetMapping
    public AuthResponseDTO loginUser(@Valid @RequestBody AuthRequestDTO authRequestDTO) {

        return authService.loginUser(authRequestDTO);
    }

    @PutMapping
    public AuthResponseDTO refreshToken(@NotEmpty @RequestBody String refreshToken) {
        return authService.refreshUser(refreshToken);
    }
}
