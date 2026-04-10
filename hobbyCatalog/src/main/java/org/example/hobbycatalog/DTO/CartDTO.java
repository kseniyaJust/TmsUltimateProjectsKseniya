package org.example.hobbycatalog.DTO;

import lombok.Data;

import java.util.Set;

@Data
public class CartDTO {
    private Long id_cart;
    private Set<HobbyDTO> hobbies;
    private int amount;
}