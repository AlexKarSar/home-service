package com.homeservice.main.dto.jpa.repository;

import com.homeservice.main.dto.jpa.entity.RoomEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "UPDATE rooms_table SET name = :name WHERE id = :id", nativeQuery = true)
    void updateById(@Param("id") Integer id, @Param("name") String name);
}
