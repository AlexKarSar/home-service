package com.homeservice.main.service.impl;

import com.homeservice.main.dto.jpa.entity.HomeEntity;
import com.homeservice.main.dto.jpa.entity.RoomEntity;
import com.homeservice.main.dto.jpa.repository.HomeRepository;
import com.homeservice.main.dto.jpa.repository.RoomRepository;
import com.homeservice.main.dto.request.RoomRequest;
import com.homeservice.main.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    private HomeRepository homeRepository;

    public RoomServiceImpl(HomeRepository homeRepository, RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
        this.homeRepository = homeRepository;
    }

    @Override
    public RoomEntity post(Integer homeId, RoomRequest roomRequest) {
        if(homeRepository == null || !homeRepository.existsById(homeId)) return null;
        HomeEntity homeEntity = homeRepository.findById(homeId).orElse(null);
        RoomEntity roomEntity = RoomEntity.builder()
                .name(roomRequest.getName())
                .home(homeEntity)
                .build();
        roomRepository.save(roomEntity);
        return roomEntity;
    }

    @Override
    public RoomEntity put(Integer roomId, RoomRequest roomRequest) {
        if(roomRepository == null) return null;
        Optional<RoomEntity> homeEntity = roomRepository.findById(roomId);
        if(homeEntity.isPresent()){
            RoomEntity room = RoomEntity.builder()
                    .name(roomRequest.getName())
                    .id(roomId)
                    .build();
            roomRepository.updateById(roomId, room.getName());
            return room;
        }
        return null;
    }

    @Override
    public void delete(Integer roomId) {
        if(roomRepository != null && roomRepository.existsById(roomId)) {
            roomRepository.deleteById(roomId);
        }
    }
}
