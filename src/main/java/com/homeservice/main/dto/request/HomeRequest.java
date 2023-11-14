package com.homeservice.main.dto.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HomeRequest {

    @Nullable
    private String address;

    @NotBlank
    private String name;
}
