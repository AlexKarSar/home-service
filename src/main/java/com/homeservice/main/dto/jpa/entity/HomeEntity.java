package com.homeservice.main.dto.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "homes_table")
    public class HomeEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String name, address;

        @OneToMany(mappedBy = "home",cascade = CascadeType.ALL)
        private List<RoomEntity> rooms = new ArrayList<>();
    }

