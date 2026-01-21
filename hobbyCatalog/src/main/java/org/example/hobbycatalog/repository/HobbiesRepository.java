package org.example.hobbycatalog.repository;

import org.example.hobbycatalog.entity.Hobbies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbiesRepository extends JpaRepository<Hobbies,Long> {
}
