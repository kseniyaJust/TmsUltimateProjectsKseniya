package org.example.hobbycatalog.controller;

import jakarta.validation.Valid;
import org.example.hobbycatalog.DTO.UpdateHobbyDTO;
import org.example.hobbycatalog.entity.Hobbies;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hobbies/catalog")
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
    public String createHobby(@Valid Hobbies hobbies){
        return "create";
    }

    @PutMapping("/{id}")
    public String changeHobby(@PathVariable Long id, @RequestBody @Valid UpdateHobbyDTO updateHobbyDTO){
        return "change";
    }

    @DeleteMapping("/{id}")
    public String deleteHobby(@PathVariable Long id){
        return "delete";
    }
}
