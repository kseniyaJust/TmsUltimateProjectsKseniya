package org.example.hobbycatalog.controller;

import jakarta.validation.Valid;
import org.example.hobbycatalog.DTO.TypeHobbiesDTO;
import org.example.hobbycatalog.DTO.UpdateHobbyDTO;
import org.example.hobbycatalog.DTO.UpdateTypeHobbyDTO;
import org.example.hobbycatalog.service.TypeHobbyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hobbies/types")
public class TypeHobbyController {

    TypeHobbyService typeHobbyService;

    public TypeHobbyController(TypeHobbyService typeHobbyService) {
        this.typeHobbyService = typeHobbyService;
    }

    @GetMapping
    public List<TypeHobbiesDTO> getAllTypes(){

        return typeHobbyService.getTypeHobbyPagedResponse();
    }

    @PostMapping
    public TypeHobbiesDTO createNewType(@Valid @RequestBody TypeHobbiesDTO typeHobbiesDTO){

        return typeHobbyService.createNewTypeHobby(typeHobbiesDTO);
    }

    @PutMapping("/{id}")
    public UpdateTypeHobbyDTO updateType(@PathVariable Long id, @Valid @RequestBody UpdateTypeHobbyDTO updateTypeHobbyDTO){

        return typeHobbyService.updateNewTypeHobby(id,updateTypeHobbyDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteType(@PathVariable Long id){

        return typeHobbyService.deleteTypeHobbyById(id);
    }
}
