package org.example.hobbycatalog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;

import java.util.List;
import java.util.Set;

@Entity
public class TypeHobbies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_type;

    @Column(unique = true)
    private String type_name;

    @Min(2)
    private int countPlayers;

    private String summary;

    @ManyToMany (mappedBy = "typeAndHobbies")
    private Set<Hobbies> users;

    @ManyToOne
    @JoinColumn(name ="id_user")
    private UsersInfo creatorUser;
}
