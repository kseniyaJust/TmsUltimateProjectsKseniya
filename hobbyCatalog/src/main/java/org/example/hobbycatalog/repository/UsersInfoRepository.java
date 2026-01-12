package org.example.hobbycatalog.repository;

import org.example.hobbycatalog.entity.UsersInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersInfoRepository extends JpaRepository<UsersInfo,Long> {
}
