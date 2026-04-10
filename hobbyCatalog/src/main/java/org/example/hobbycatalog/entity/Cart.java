package org.example.hobbycatalog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity
@Data
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart")
    private Long id_cart;

    @ManyToMany(mappedBy = "cartUsers")
    @JsonIgnore
    private Set<UsersInfo> usersInfo;

    @ManyToMany
    @JoinTable(
            name = "cart_hobbies_relation",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id")
    )
    private Set<Hobbies> hobbies;

    @Column(name = "amount")
    private int amount;
}