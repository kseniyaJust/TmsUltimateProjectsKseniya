package org.example.hobbycatalog.service;

import org.example.hobbycatalog.DTO.UserAddressDTO;
import org.example.hobbycatalog.entity.UserAdress;
import org.example.hobbycatalog.exceptions.ItemNotFoundException;
import org.example.hobbycatalog.repository.UserAdressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressService {
    UserAdressRepository userAdressRepository;

    public UserAddressService(UserAdressRepository userAdressRepository) {
        this.userAdressRepository = userAdressRepository;
    }

    public List<UserAdress> getAllUserAdresses(){
        return userAdressRepository.findAll();
    }

    public UserAddressDTO createNewAddress(UserAddressDTO userAddressDTO){
        return new UserAddressDTO();
    }
    public UserAddressDTO updateAddress(Long id, UserAddressDTO userAddressDTO){
        return new UserAddressDTO();

    }
    public String deleteAddress(Long id) {
        if(userAdressRepository.findById(id).isPresent()){
            userAdressRepository.deleteById(id);
            return "Address with id: " + id + " deleted";
        }
        throw new ItemNotFoundException("Address with id: " + id + " not found");
    }

}
