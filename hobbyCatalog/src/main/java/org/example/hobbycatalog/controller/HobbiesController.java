package org.example.hobbycatalog.controller;

import jakarta.validation.Valid;
import org.example.hobbycatalog.DTO.HobbyDTO;
import org.example.hobbycatalog.DTO.PagedHobbiesResponseDTO;
import org.example.hobbycatalog.DTO.UpdateHobbyDTO;
import org.example.hobbycatalog.entity.Hobbies;
import org.example.hobbycatalog.service.HobbiesService;
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
@RequestMapping("/hobbies/catalog")
public class HobbiesController {

    HobbiesService hobbiesService;

    public HobbiesController(HobbiesService hobbiesService) {
        this.hobbiesService = hobbiesService;
    }

    @GetMapping
    public List<HobbyDTO> getAllCatalog(){

        return hobbiesService.getHobbyPagedResponse();
    }

    @GetMapping("/{id}")
    public Hobbies getOneHobby(@PathVariable Long id){
        return hobbiesService.getHobbyById(id);
    }

    @PostMapping
    public HobbyDTO createHobby(@Valid @RequestBody HobbyDTO hobbies){

        return hobbiesService.createNewHobby(hobbies);
    }

    @PutMapping("/{id}")
    public HobbyDTO changeHobby(@PathVariable Long id, @RequestBody @Valid UpdateHobbyDTO updateHobbyDTO){
        return hobbiesService.updateNewHobby(id, updateHobbyDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteHobby(@PathVariable Long id){

        return hobbiesService.deleteHobbyById(id);
    }
}
