package com.ordemflow.ordemFlow.bussiness.mapper;


import com.ordemflow.ordemFlow.bussiness.DTOs.RestaurantRequest;
import com.ordemflow.ordemFlow.bussiness.DTOs.RestaurantResponse;
import com.ordemflow.ordemFlow.infrastructure.Entity.Restaurant;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RestaurantMapper {

    public Restaurant toConvert(RestaurantRequest restaurantRequest){
        return Restaurant.builder()
                .name(restaurantRequest.name())
                .email(restaurantRequest.email())
                .phone(restaurantRequest.phone())
                .description(restaurantRequest.description())
                .imagemUrl(restaurantRequest.imagemUrl())
                .createdAt(restaurantRequest.createdAt())
                .address(restaurantRequest.address())
                .build();
    }


    public RestaurantResponse toConvertResponse(Restaurant restaurant){
        return RestaurantResponse.builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .phone(restaurant.getPhone())
                .email(restaurant.getEmail())
                .description(restaurant.getDescription())
                .imagemUrl(restaurant.getImagemUrl())
                .active(restaurant.isActive())
                .address(restaurant.getAddress())
                .build();
    }
}
