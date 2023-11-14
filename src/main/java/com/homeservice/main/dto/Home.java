package com.homeservice.main.dto;

import com.homeservice.main.dto.request.HomeRequest;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Home {

    @NotBlank
    private String name;

    @Nullable
    private String address;

    @NotNull
    private Integer id;

    public void create(HomeRequest homeRequest, Integer id) {
        this.id = id;
        this.address = homeRequest.getAddress();
        this.name = homeRequest.getName();
    }
}
