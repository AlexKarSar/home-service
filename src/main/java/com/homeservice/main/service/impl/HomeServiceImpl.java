package com.homeservice.main.service.impl;

import com.homeservice.main.dto.Home;
import com.homeservice.main.dto.request.HomeRequest;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
@Data
@Service
public class HomeServiceImpl implements com.homeservice.main.service.HomeService {

    private ArrayList<Home> homeArrayList = new ArrayList<>();

    @Override
    public Home create(HomeRequest homeRequest) {
        Home home = new Home();
        home.create(homeRequest, homeArrayList.size());
        homeArrayList.add(home);
        return home;
    }

    @Override
    public Home get(Integer homeId) {
        for (Home home : homeArrayList) {
            if (home.getId() == homeId) return home;
        }
        return null;
    }

    @Override
    public ArrayList<Home> get() {
        return homeArrayList;
    }

    @Override
    public Home put(HomeRequest HomeRequest, Integer id) {
        homeArrayList.get(id).setAddress(HomeRequest.getAddress());
        homeArrayList.get(id).setName(HomeRequest.getName());
        return homeArrayList.get(id);
    }

    @Override
    public void delete(Integer homeId) {
        for (int i = 0; i < homeArrayList.size(); i++) {
            if(homeArrayList.get(i).getId() == homeId) homeArrayList.remove(i);
        }
    }


}
