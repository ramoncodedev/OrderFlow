package com.ordemflow.ordemFlow.bussiness.controllers;


import com.ordemflow.ordemFlow.bussiness.DTOs.request.RestaurantRequest;
import com.ordemflow.ordemFlow.bussiness.DTOs.response.RestaurantResponse;
import com.ordemflow.ordemFlow.bussiness.mapper.RestaurantMapper;
import com.ordemflow.ordemFlow.bussiness.service.RestaurantService;
import com.ordemflow.ordemFlow.infrastructure.Entity.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<RestaurantResponse> createRestaurant( @RequestBody RestaurantRequest restaurantRequest){
        Restaurant restaurant = RestaurantMapper.toConvert(restaurantRequest);
        Restaurant newRestaurant = restaurantService.saveRestaurant(restaurant);

        return ResponseEntity.status(HttpStatus.CREATED).body(RestaurantMapper.toConvertResponse(newRestaurant));
    }

    @GetMapping("/list")
    public ResponseEntity<List<RestaurantResponse>> listRestaurant(){
        List<Restaurant> restaurants = restaurantService.findList();
        List<RestaurantResponse> newlist = restaurants.stream()
                .map(restaurant -> RestaurantMapper.toConvertResponse(restaurant))
                .toList();
        return ResponseEntity.ok().body(newlist);


    }

}
