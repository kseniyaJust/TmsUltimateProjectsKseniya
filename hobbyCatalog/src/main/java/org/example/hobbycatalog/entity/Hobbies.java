package org.example.hobbycatalog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Data
@Table(name = "hobbies")
public class Hobbies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Изменил с AUTO на IDENTITY
    @Column(name = "id_hobby")
    private Long idHobby;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private TypeHobbies typeAndHobbies;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "creator", columnDefinition = "VARCHAR(100)")
    private String creator;

    @Column(name = "price")
    private double price;

    @ManyToMany(mappedBy = "hobbies") // Соответствует полю hobbies в Cart
    @JsonIgnore
    private Set<Cart> carts; // Изменил имя с cartHobbies на carts для соответствия
}