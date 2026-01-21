package org.example.hobbycatalog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/type")
public class TypeItemController {
    @GetMapping
    public String getAllTypes(){
        return "getAllTypes";
    }

    @PostMapping
    public String createNewType(){
        return "createNewType";
    }

    @PutMapping
    public String updateType(){
        return "updateType";
    }

    @DeleteMapping
    public String deleteType(){
        return "deleteType";
    }
}
