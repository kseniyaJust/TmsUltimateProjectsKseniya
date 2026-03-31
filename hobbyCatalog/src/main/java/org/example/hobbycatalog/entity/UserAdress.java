package org.example.hobbycatalog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class UserAdress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_adress;


    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private int number_home;

    @Column(nullable = false)
    private int number_flat;

    @ManyToOne
    @JoinColumn(name = "id_user")
    @JsonIgnore
    private UsersInfo usersInfo_adress;

}
