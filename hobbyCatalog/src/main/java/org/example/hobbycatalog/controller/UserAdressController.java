package org.example.hobbycatalog.controller;

import org.example.hobbycatalog.DTO.UserAdressDTO;
import org.example.hobbycatalog.entity.UserAdress;
import org.example.hobbycatalog.entity.Wallet;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/adress")
//acces only to current user
public class UserAdressController {

    @GetMapping
    public String getAllAdresses(){
        return "get all adresses";
    }

    @PostMapping
    public String addAdress(@RequestBody UserAdressDTO userAdress){
        return  "add adress";
    }

    @PutMapping
    public String updateAdress(@RequestBody UserAdressDTO userAdress){
        return "update adress";
    }

    @DeleteMapping
    public String deleteAdress(@RequestParam Long id_adress){
        return "delete adress";
    }
}
