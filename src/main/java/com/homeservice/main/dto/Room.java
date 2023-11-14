package com.homeservice.main.dto;

import com.homeservice.main.dto.request.RoomRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {

    @NotBlank
    private String name;

    @NotNull
    private Integer id;

    public void create(RoomRequest roomRequest, Integer id) {
        this.id = id;
        this.name = roomRequest.getName();
    }
}
