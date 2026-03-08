package com.ordemflow.ordemFlow.bussines.DTOs;

import com.ordemflow.ordemFlow.infrastructure.Entity.Address;
import lombok.Builder;

import java.time.LocalDateTime;


@Builder
public record RestaurantResponse(Long id, String name, String description,
                                 String phone, String email,String imagemUrl, Address address,
                                 boolean active, LocalDateTime createdAt) {
}
