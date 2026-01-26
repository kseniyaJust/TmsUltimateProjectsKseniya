package org.example.hobbycatalog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cart;

    @ManyToMany(mappedBy = "cartUsers")
    private Set<UsersInfo> usersInfo;

    @ManyToMany(mappedBy = "cartHobbies")
    private Set<Hobbies> hobbies;

    private int amount;
}
