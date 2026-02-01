package org.example.hobbycatalog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import org.example.hobbycatalog.enumpackage.Role;

import java.util.Set;

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

    private int balance_amount;

    @OneToMany(mappedBy = "usersInfo_wallet")
    private Set<Wallet>  wallets;

    @ManyToMany
    @JoinTable(
            name = "cart_users",
            joinColumns = @JoinColumn(name ="id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_cart")
    )

    private Set<Cart> cartUsers;

    @OneToMany(mappedBy = "usersInfo_adress")
    private Set<UserAdress> userAdresses;
}
