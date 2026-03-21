package org.example.hobbycatalog.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class WalletDTO {

    private String owner_name;

    private Long cart_number;

    @JsonFormat(pattern = "MM/yyyy")
    private Date date_expire;

    private Long CVC;

}
