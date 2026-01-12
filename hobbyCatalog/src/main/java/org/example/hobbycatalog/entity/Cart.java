package org.example.hobbycatalog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cart;

//    @OneToMany(mappedBy = "cartUsers")
//    @JoinColumn(name = "id_user",nullable = false) - many to many
    private List<UsersInfo> usersInfo;

//    @OneToMany(mappedBy = "cartItems")
//    @JoinColumn(name = "id_item",nullable = false) - many to many
    private List<Items> items;

    private int amount;
}
