package com.ordemflow.ordemFlow.bussines.controllers;


import com.ordemflow.ordemFlow.bussines.DTOs.RestaurantResponse;
import com.ordemflow.ordemFlow.bussines.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

}
