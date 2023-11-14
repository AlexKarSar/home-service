package com.homeservice.main.service;

import com.homeservice.main.dto.jpa.entity.HomeEntity;
import com.homeservice.main.dto.jpa.entity.RoomEntity;
import com.homeservice.main.dto.request.HomeRequest;
import com.homeservice.main.dto.request.RoomRequest;

import java.util.Map;
import java.util.Optional;

public interface RoomService {
    RoomEntity post(Integer homeId ,RoomRequest roomRequest);

    RoomEntity put(Integer roomId, RoomRequest roomRequest);

    void delete(Integer roomId);
}
