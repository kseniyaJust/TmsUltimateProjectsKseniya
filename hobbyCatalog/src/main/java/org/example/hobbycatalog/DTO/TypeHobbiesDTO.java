package org.example.hobbycatalog.DTO;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.example.hobbycatalog.entity.UsersInfo;

public class TypeHobbiesDTO {

    @NotEmpty
    private String type_name;

    @Min(2)
    private int countPlayers;

    @NotEmpty
    private String summary;

}
