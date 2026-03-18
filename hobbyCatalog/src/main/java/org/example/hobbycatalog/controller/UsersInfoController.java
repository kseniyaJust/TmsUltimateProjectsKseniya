package org.example.hobbycatalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/info")
public class UsersInfoController {

    @PostMapping
    public String registUser(){
        return "regist";
    }

    @GetMapping
    public String loginUser(){
        return "login";
    }

    @PutMapping
    public String refreshToken(){
        return "refresh";
    }
}
