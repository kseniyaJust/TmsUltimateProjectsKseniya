package org.example.hobbycatalog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_wallet;

    @ManyToOne
    @JoinColumn(name = "id_user",nullable = false)
    private UsersInfo usersInfo_wallet;

    private String owner_name;

    private Long cart_number;

    @JsonFormat(pattern = "MM/yyyy")
    private Date date_expire;

    private Long CVC;





}
