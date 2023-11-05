package com.homeservice.main.controllers;
import com.homeservice.main.dto.Home;
import com.homeservice.main.dto.request.HomeRequest;
import com.homeservice.main.service.HomeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping(value = "/home-service", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {
   private final HomeService homeService;

   public HomeController (HomeService homeService){
      this.homeService = homeService;
   }

   @PostMapping("/api/homes")
   public ResponseEntity<Home> createHome(@RequestBody @Valid HomeRequest homeRequest){
      Home home = homeService.create(homeRequest);
      return ResponseEntity.ok(home);
   }

   @PutMapping("/api/homes/{homeId}")
   public ResponseEntity<Home> editHouse(@RequestBody @Valid HomeRequest HomeRequest, @PathVariable int homeId){
      return ResponseEntity.ok(homeService.put(HomeRequest, homeId));
   }

   @GetMapping("/api/homes/{homeId}")
   public ResponseEntity<Home> getHome(@PathVariable int homeId){
      return ResponseEntity.ok(homeService.get(homeId));
   }

   @GetMapping("/api/homes")
   public ResponseEntity<ArrayList<Home>> getListOfHomes(){
      return ResponseEntity.ok(homeService.get());
   }

   @DeleteMapping("/api/homes/{homeId}")
   public void delete(@PathVariable int homeId){
      homeService.delete(homeId);
   }
}
