package org.example.hobbycatalog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.example.hobbycatalog.enumpackage.Role;

@Entity
public class UsersInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;

    @Column
    private String name;

    @Column (unique = true)
    private String email;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Role role;

    @ManyToOne
    private Cart cartUsers;
}
