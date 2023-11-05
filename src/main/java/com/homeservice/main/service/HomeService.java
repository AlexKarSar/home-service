package com.homeservice.main.service;

import com.homeservice.main.dto.Home;
import com.homeservice.main.dto.request.HomeRequest;

import java.util.ArrayList;

public interface HomeService {
    Home create(HomeRequest homeRequest);
    Home get(Integer homeId);
    ArrayList<Home> get();
    Home put(HomeRequest HomeRequest, Integer id);
    void delete(Integer homeId);
}
