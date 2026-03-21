package org.example.hobbycatalog.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public class UserAdressDTO {
    @NotEmpty
    private String city;

    @NotEmpty
    private String street;

    @NotEmpty
    private int number_home;

    @NotEmpty
    private int number_flat;
}
