package org.example.hobbycatalog.service;

import org.example.hobbycatalog.DTO.HobbyDTO;
import org.example.hobbycatalog.DTO.UpdateHobbyDTO;
import org.example.hobbycatalog.entity.Hobbies;
import org.example.hobbycatalog.entity.TypeHobbies;
import org.example.hobbycatalog.exceptions.ItemNotFoundException;
import org.example.hobbycatalog.mapper.HobbiesMapper;
import org.example.hobbycatalog.repository.HobbiesRepository;
import org.example.hobbycatalog.repository.TypeHobbyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HobbiesService {

    HobbiesRepository hobbiesRepository;
    HobbiesMapper hobbiesMapper;
    private TypeHobbyRepository typeHobbiesRepository;

    public HobbiesService(HobbiesRepository hobbiesRepository, HobbiesMapper hobbiesMapper, TypeHobbyRepository typeHobbiesRepository) {

        this.hobbiesRepository = hobbiesRepository;
        this.hobbiesMapper = hobbiesMapper;
        this.typeHobbiesRepository = typeHobbiesRepository;
    }

    @Transactional
    public HobbyDTO createNewHobby(HobbyDTO hobbyDTO) {
// 1. Находим TypeHobbies по названию
        TypeHobbies typeHobbies = typeHobbiesRepository.findByTypeName(hobbyDTO.getTypeName())
                .orElseThrow(() -> new RuntimeException(
                        "Type hobby not found with name: " + hobbyDTO.getTypeName()
                ));

        // 2. Маппим DTO в Entity (без typeAndHobbies)
        Hobbies hobbies = hobbiesMapper.toEntity(hobbyDTO);

        // 3. Устанавливаем найденный тип
        hobbies.setTypeAndHobbies(typeHobbies);

        // 4. Сохраняем в БД
        Hobbies savedHobby = hobbiesRepository.save(hobbies);

        return hobbiesMapper.toDTO(savedHobby);
    }

    public  HobbyDTO updateNewHobby(Long id, UpdateHobbyDTO updateHobbyDTO) {
        Hobbies existingHobby = hobbiesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Type hobby not found with id: " + id));

        if(updateHobbyDTO.getName() != null){
            existingHobby.setName(updateHobbyDTO.getName());
        }
        if(updateHobbyDTO.getCreator() != null)
            existingHobby.setCreator(updateHobbyDTO.getCreator());
        if(updateHobbyDTO.getPrice() > 4)
            existingHobby.setPrice(updateHobbyDTO.getPrice());
        if(updateHobbyDTO.getNameType() != null){
            TypeHobbies newType = typeHobbiesRepository.findByTypeName(updateHobbyDTO.getName())
                    .orElseThrow(() -> new RuntimeException(
                            "Type hobby not found with name: " + updateHobbyDTO.getName()
                    ));
            existingHobby.setTypeAndHobbies(newType);
        }

        Hobbies updatedType = hobbiesRepository.save(existingHobby);

        return hobbiesMapper.toDTO(updatedType);

    }

    public Hobbies getHobbyById(Long id){
        if(hobbiesRepository.findById(id).isPresent())
            return hobbiesRepository.findById(id).get();
        throw new ItemNotFoundException("Hobby with id: " + id +" not found");
    }

    public List<HobbyDTO> getHobbyPagedResponse(){
        List<Hobbies> hobbies = hobbiesRepository.findAll();

        // Преобразуем каждую сущность в DTO с помощью маппера
        return hobbies.stream()
                .map(hobbiesMapper::toDTO)
                .collect(Collectors.toList());

    }

    public String deleteHobbyById(Long id){
        if(hobbiesRepository.findById(id).isPresent()){
            hobbiesRepository.deleteById(id);
            return "Hobby with id: " + id + " deleted";
        }
        throw new ItemNotFoundException("Hobby with id: " + id + " not found");
    }
}
