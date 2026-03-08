package com.ordemflow.ordemFlow.bussines.DTOs;

import com.ordemflow.ordemFlow.infrastructure.Entity.Address;

import java.time.LocalDateTime;


public record RestaurantRequest(String name, String description, String phone,
                                String email, boolean active, String imagemUrl, Address address,
                                LocalDateTime createdAt) {
}
