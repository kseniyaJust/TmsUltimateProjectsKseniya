package org.example.hobbycatalog.service;

import org.example.hobbycatalog.DTO.HobbyDTO;
import org.example.hobbycatalog.DTO.TypeHobbiesDTO;
import org.example.hobbycatalog.DTO.UpdateTypeHobbyDTO;
import org.example.hobbycatalog.entity.TypeHobbies;
import org.example.hobbycatalog.exceptions.ItemNotFoundException;
import org.example.hobbycatalog.repository.TypeHobbyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeHobbyService {
    TypeHobbyRepository typeHobbyRepository;

    public TypeHobbyService(TypeHobbyRepository typeHobbyRepository) {
        this.typeHobbyRepository = typeHobbyRepository;
    }

    public TypeHobbiesDTO createNewTypeHobby(TypeHobbiesDTO typeHobbyDTO) {
        return new TypeHobbiesDTO();

    }

    public TypeHobbiesDTO updateNewTypeHobby(Long id, UpdateTypeHobbyDTO updateTypeHobbyDTO) {
        return new TypeHobbiesDTO();
    }

    public TypeHobbies getTypeHobbyById(Long id){
        if(typeHobbyRepository.findById(id).isPresent())
            return typeHobbyRepository.findById(id).get();
        throw new ItemNotFoundException("Type of Hobby with id: " + id +" not found");
    }

    public List<TypeHobbies> getTypeHobbyPagedResponse(){
        return typeHobbyRepository.findAll();

    }

    public String deleteTypeHobbyById(Long id){
        if(typeHobbyRepository.findById(id).isPresent()){
            typeHobbyRepository.deleteById(id);
            return "Type of hobby with id: " + id + " deleted";
        }
        throw new ItemNotFoundException("Type of hobby with id: " + id + " not found");
    }
}
