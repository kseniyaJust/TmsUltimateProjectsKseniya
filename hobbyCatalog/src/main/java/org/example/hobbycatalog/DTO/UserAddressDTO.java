package org.example.hobbycatalog.DTO;

import jakarta.validation.constraints.NotEmpty;

public class UserAddressDTO {
    @NotEmpty
    private String city;

    @NotEmpty
    private String street;

    @NotEmpty
    private int number_home;

    @NotEmpty
    private int number_flat;
}
