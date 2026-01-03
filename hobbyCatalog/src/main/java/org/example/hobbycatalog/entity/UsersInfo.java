package org.example.hobbycatalog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UsersInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;
}
