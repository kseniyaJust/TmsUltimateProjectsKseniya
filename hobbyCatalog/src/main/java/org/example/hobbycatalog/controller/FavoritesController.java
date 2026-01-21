package org.example.hobbycatalog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/favorites")
public class FavoritesController {
    @GetMapping
    public String getAllFavorites(){
        return "getAllFavorites";
    }

    @PutMapping
    public String addToCart(){
        return  "addToCart";
    }

    @DeleteMapping
    public String deleteFavorite(){
        return "deleteFavorite";
    }
}
