package com.homeservice.main.service;

import com.homeservice.main.dto.jpa.entity.HomeEntity;
import com.homeservice.main.dto.request.HomeRequest;

import java.util.Map;

public interface HomeService {
    HomeEntity post(HomeRequest homeRequest);

    HomeEntity put(HomeRequest homeRequest, Integer id);

    HomeEntity get(Integer homeId);

    Map<Integer, String> getHomes();

    void delete(Integer homeId);
}
