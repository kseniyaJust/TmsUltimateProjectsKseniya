package org.example.hobbycatalog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Hobbies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_hobby")
    private Long idHobby;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private TypeHobbies typeAndHobbies;

    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "VARCHAR(100)")
    private String creator;

    @Column
    private double price;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "cart_hobbies",
            joinColumns = @JoinColumn(name = "id_hobby"),
            inverseJoinColumns = @JoinColumn(name = "id_cart")
    )
    private Set<Cart> cartHobbies;  // Убедитесь, что это поле существует

}