package org.example.hobbycatalog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/catalog")
public class HobbiesController {
    @GetMapping
    public String getAllCatalog(){
        return "Hobbies";
    }

    @GetMapping("/{id}")
    public String getOneHobby(@PathVariable Long id){
        return "id";
    }

    @PostMapping
    public String createHobby(){
        return "create";
    }

    @PutMapping("/{id}")
    public String changeHobby(@PathVariable Long id){
        return "change";
    }

    @DeleteMapping("/{id}")
    public String deleteHobby(@PathVariable Long id){
        return "delete";
    }
}
