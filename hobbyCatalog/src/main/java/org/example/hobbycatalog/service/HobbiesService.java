package org.example.hobbycatalog.service;

import org.example.hobbycatalog.DTO.HobbyDTO;
import org.example.hobbycatalog.DTO.UpdateHobbyDTO;
import org.example.hobbycatalog.entity.Hobbies;
import org.example.hobbycatalog.exceptions.ItemNotFoundException;
import org.example.hobbycatalog.repository.HobbiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbiesService {

    HobbiesRepository hobbiesRepository;

    public HobbiesService(HobbiesRepository hobbiesRepository) {
        this.hobbiesRepository = hobbiesRepository;
    }

    public HobbyDTO createNewHobby(HobbyDTO hobbyDTO) {
        return new HobbyDTO();
    }

    public  HobbyDTO updateNewHobby(Long id, UpdateHobbyDTO updateHobbyDTO) {
        return new HobbyDTO();

    }

    public Hobbies getHobbyById(Long id){
        if(hobbiesRepository.findById(id).isPresent())
            return hobbiesRepository.findById(id).get();
        throw new ItemNotFoundException("Hobby with id: " + id +" not found");
    }

    public List<Hobbies> getHobbyPagedResponse(){
        return hobbiesRepository.findAll();

    }

    public String deleteHobbyById(Long id){
        if(hobbiesRepository.findById(id).isPresent()){
            hobbiesRepository.deleteById(id);
            return "Hobby with id: " + id + " deleted";
        }
        throw new ItemNotFoundException("Hobby with id: " + id + " not found");
    }
}
