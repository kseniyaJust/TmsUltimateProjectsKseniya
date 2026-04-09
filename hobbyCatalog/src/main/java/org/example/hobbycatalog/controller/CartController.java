package org.example.hobbycatalog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/cart")
public class CartController {

    @GetMapping
    public String getCart(){
        return "cart";
    }

    @PostMapping
    public String addItemToCart(){
        return "addItemToCart";
    }

    @PutMapping
    public String buyItemFromCart(){
        return "buyItemFromCart";
    }

    @DeleteMapping
    public String deleteItemFromCart(){
        return "deleteItemFromCart";
    }
}
