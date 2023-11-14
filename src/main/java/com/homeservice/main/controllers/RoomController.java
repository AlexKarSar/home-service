package com.homeservice.main.controllers;

import com.homeservice.main.dto.jpa.entity.RoomEntity;
import com.homeservice.main.dto.request.RoomRequest;
import com.homeservice.main.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomController {
    private final RoomService roomService;

    public RoomController (RoomService roomService){
        this.roomService = roomService;
    }

    @PostMapping("/rooms")
    public ResponseEntity<RoomEntity> createRoom(@RequestParam Integer homeId, @RequestBody @Valid RoomRequest roomRequest){
        RoomEntity roomEntity = roomService.post(homeId, roomRequest);
        return ResponseEntity.ok(roomEntity);
    }

    @PutMapping("/rooms/{roomId}")
    public ResponseEntity<RoomEntity> changeRoom(@PathVariable Integer roomId, @RequestBody @Valid RoomRequest roomRequest){
        return ResponseEntity.ok(roomService.put(roomId, roomRequest));
    }

    @DeleteMapping("/rooms/{roomId}")
    public ResponseEntity<String> deleteRoom(@PathVariable Integer roomId){
        roomService.delete(roomId);
        return ResponseEntity.ok(null);
    }

}
