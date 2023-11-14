package com.homeservice.main.service;

import com.homeservice.main.dto.jpa.entity.RoomEntity;
import com.homeservice.main.dto.request.RoomRequest;

public interface RoomService {
    RoomEntity post(Integer homeId, RoomRequest roomRequest);

    RoomEntity put(Integer roomId, RoomRequest roomRequest);

    void delete(Integer roomId);
}
