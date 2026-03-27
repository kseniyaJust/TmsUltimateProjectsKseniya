package org.example.hobbycatalog.service;

import org.example.hobbycatalog.DTO.HobbyDTO;
import org.example.hobbycatalog.DTO.PagedHobbiesResponseDTO;
import org.example.hobbycatalog.DTO.UpdateHobbyDTO;
import org.example.hobbycatalog.exceptions.HobbyNotFoundException;
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
    }

    public  HobbyDTO updateNewHobby(Long id, UpdateHobbyDTO updateHobbyDTO) {

    }

    public HobbyDTO getHobbyById(Long id){
        if(hobbiesRepository.findById(id).isPresent())
            return hobbiesRepository.findById(id).get();
        throw new HobbyNotFoundException("Hobby with id: " + id +" not found");
    }

    public List<HobbyDTO> getHobbyPagedResponse(){
        return hobbiesRepository.findAll();

    }

    public String deleteHobbyById(Long id){
        if(hobbiesRepository.findById(id).isPresent()){
            hobbiesRepository.deleteById(id);
            return "Hobby with id: " + id + " deleted";
        }
        throw new HobbyNotFoundException("Hobby with id: " + id + " not found");
    }
}
