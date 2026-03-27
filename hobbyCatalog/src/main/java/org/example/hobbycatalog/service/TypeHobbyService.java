package org.example.hobbycatalog.service;

import org.example.hobbycatalog.DTO.TypeHobbiesDTO;
import org.example.hobbycatalog.DTO.UpdateTypeHobbyDTO;
import org.example.hobbycatalog.exceptions.HobbyNotFoundException;
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
    }

    public UpdateTypeHobbyDTO updateNewTypeHobby(Long id, UpdateTypeHobbyDTO updateTypeHobbyDTO) {

    }

    public TypeHobbiesDTO getTypeHobbyById(Long id){
        if(typeHobbyRepository.findById(id).isPresent())
            return typeHobbyRepository.findById(id).get();
        throw new HobbyNotFoundException("Type of Hobby with id: " + id +" not found");
    }

    public List<TypeHobbiesDTO> getTypeHobbyPagedResponse(){
        return typeHobbyRepository.findAll();

    }

    public String deleteTypeHobbyById(Long id){
        if(typeHobbyRepository.findById(id).isPresent()){
            typeHobbyRepository.deleteById(id);
            return "Type of hobby with id: " + id + " deleted";
        }
        throw new HobbyNotFoundException("Type of hobby with id: " + id + " not found");
    }
}
