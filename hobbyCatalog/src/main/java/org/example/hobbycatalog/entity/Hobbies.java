package org.example.hobbycatalog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Set;

@Entity
public class Hobbies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_hobby;


    @ManyToMany
    @JoinTable(
            name = "type_and_hobbies",
            joinColumns = @JoinColumn(name = "id_hobby"),
            inverseJoinColumns = @JoinColumn(name = "id_type")
    )
    private Set<TypeHobbies> typeAndHobbies;

    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "VARCHAR(100)")
    private String creator;

    @Column
    private double price;

    @ManyToMany
    @JoinTable(
            name = "cart_hobbies",
            joinColumns = @JoinColumn(name = "id_hobby"),
            inverseJoinColumns = @JoinColumn(name = "id_cart")
    )
    private Set<Cart> cartHobbies;
}
