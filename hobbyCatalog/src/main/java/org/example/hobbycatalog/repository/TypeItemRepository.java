package org.example.hobbycatalog.repository;

import org.example.hobbycatalog.entity.TypeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeItemRepository extends JpaRepository<TypeItem,Long> {
}
