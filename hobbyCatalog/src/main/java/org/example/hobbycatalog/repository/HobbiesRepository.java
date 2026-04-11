package org.example.hobbycatalog.repository;

import org.example.hobbycatalog.entity.Hobbies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbiesRepository extends JpaRepository<Hobbies, Long> {



    // Поиск по типу хобби с пагинацией
    @Query("SELECT h FROM Hobbies h WHERE h.typeAndHobbies.typeName = :typeName")
    Page<Hobbies> findByTypeName(@Param("typeName") String typeName, Pageable pageable);


    // Поиск с несколькими параметрами
    @Query("SELECT h FROM Hobbies h WHERE " +
            "(:name IS NULL OR LOWER(h.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:minPrice IS NULL OR h.price >= :minPrice) AND " +
            "(:maxPrice IS NULL OR h.price <= :maxPrice) AND " +
            "(:typeName IS NULL OR h.typeAndHobbies.typeName = :typeName)")
    Page<Hobbies> searchHobbies(@Param("name") String name,
                                @Param("minPrice") Double minPrice,
                                @Param("maxPrice") Double maxPrice,
                                @Param("typeName") String typeName,
                                Pageable pageable);
}