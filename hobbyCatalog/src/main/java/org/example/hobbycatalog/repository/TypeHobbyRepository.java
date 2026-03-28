package org.example.hobbycatalog.repository;

import org.example.hobbycatalog.entity.TypeHobbies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeHobbyRepository extends JpaRepository<TypeHobbies,Long> {
}
