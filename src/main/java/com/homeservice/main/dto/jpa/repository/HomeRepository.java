package com.homeservice.main.dto.jpa.repository;

import com.homeservice.main.dto.jpa.entity.HomeEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HomeRepository extends JpaRepository<HomeEntity, Integer> {

    @Query("SELECT homes_table FROM HomeEntity homes_table ORDER BY homes_table.name ASC")
    ArrayList<HomeEntity> findAllPetsOrderedByIdASC();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE homes_table SET name = :name, address = :address WHERE id = :id", nativeQuery = true)
    void updateById(@Param("id") Integer id, @Param("name") String name, @Param("address") String address);

}
