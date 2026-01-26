package org.example.hobbycatalog.entity;

import com.google.errorprone.annotations.OverridingMethodsMustInvokeSuper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import org.apache.catalina.User;

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
    @ManyToMany (mappedBy = "typeAndHobbies")
    private Set<UsersInfo> users;
}
