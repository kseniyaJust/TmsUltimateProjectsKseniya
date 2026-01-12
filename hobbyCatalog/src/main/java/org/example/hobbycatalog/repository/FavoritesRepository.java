package org.example.hobbycatalog.repository;

import org.example.hobbycatalog.entity.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites,Long> {
}
