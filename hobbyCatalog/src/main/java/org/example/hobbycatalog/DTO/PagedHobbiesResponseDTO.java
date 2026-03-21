package org.example.hobbycatalog.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public class PagedHobbiesResponseDTO {
    private List<HobbyDTO> content;

    private int totalPages;

    private long totalElements;

    private int pageNumber;

    private int pageSize;
}
