package org.example.hobbycatalog.repository;

import org.example.hobbycatalog.DTO.HobbyDTO;
import org.example.hobbycatalog.entity.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface HobbiesRepository extends JpaRepository<Hobbies,Long> {

}
