package com.homeservice.main.service.impl;

import com.homeservice.main.dto.Home;
import com.homeservice.main.dto.jpa.entity.HomeEntity;
import com.homeservice.main.dto.jpa.repository.HomeRepository;
import com.homeservice.main.dto.request.HomeRequest;
import lombok.Data;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Data
@Service
public class HomeServiceImpl implements com.homeservice.main.service.HomeService {

    private HomeRepository homeRepository;

    public HomeServiceImpl (HomeRepository homeRepository){
        this.homeRepository = homeRepository;
    }

    @Override
    public HomeEntity post(HomeRequest homeRequest) {
        HomeEntity homeEntity = HomeEntity.builder()
                .name(homeRequest.getName())
                .address(homeRequest.getAddress())
                .build();
        homeRepository.save(homeEntity);
        return homeEntity;
    }

    @Override
    public HomeEntity put(HomeRequest homeRequest, Integer id) {
        if(homeRepository == null) return null;
        Optional<HomeEntity> homeEntity = homeRepository.findById(id);
        if(homeEntity.isPresent()){
            HomeEntity home = HomeEntity.builder()
                    .address(homeRequest.getAddress())
                    .name(homeRequest.getName())
                    .build();
            homeRepository.updateById(id, home.getName(), home.getAddress());
            return home;
        }
        return null;
    }


    @Override
    public HomeEntity get(Integer homeId) {
        if (homeRepository == null) return null;
        return homeRepository.findById(homeId).orElse(null);
    }

    @Override
    public Map<Integer, String> getHomes() {
        if(getHomeRepository() == null) return null;
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < homeRepository.findAllPetsOrderedByIdASC().size(); i++) {
            map.put(homeRepository.findAllPetsOrderedByIdASC().get(i).getId(), homeRepository.findAllPetsOrderedByIdASC().get(i).getName());
        }
        return map;
    }


    @Override
    public void delete(Integer homeId) {
        if(homeRepository != null && homeRepository.existsById(homeId)) {
            homeRepository.deleteById(homeId);
        }
    }
}
