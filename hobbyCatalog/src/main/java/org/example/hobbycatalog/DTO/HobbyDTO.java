package org.example.hobbycatalog.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.example.hobbycatalog.entity.TypeHobbies;

import java.util.Set;

public class HobbyDTO {

    @NotEmpty
    private Set<TypeHobbies> typeAndHobbies;

    @NotEmpty
    @Size(min =1, max = 50)
    private String name;

    @NotEmpty
    @Size(min =1, max = 100)
    private String creator;

    @NotEmpty
    @Size(min =4, max = 6)
    private double price;

}
