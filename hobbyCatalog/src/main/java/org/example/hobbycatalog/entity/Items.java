package org.example.hobbycatalog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_item;

//    @Column()
//    private TypeItem type;

    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "VARCHAR(100)")
    private String creator;

    @Column
    private double price;

    @ManyToOne
    private Cart cartItems;
}
