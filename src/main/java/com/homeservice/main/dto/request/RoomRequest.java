package com.homeservice.main.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RoomRequest {

    @NotBlank
    private String name;
}
