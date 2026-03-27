package org.example.hobbycatalog.repository;

import org.example.hobbycatalog.DTO.HobbyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.hobbycatalog.DTO.PagedHobbiesResponseDTO;


import java.util.List;

@Repository
public interface HobbiesRepository extends JpaRepository<HobbyDTO,Long> {
    List<HobbyDTO> findAll();
}
