package com.ordemflow.ordemFlow.bussiness.DTOs;

import com.ordemflow.ordemFlow.infrastructure.Entity.Address;

import java.time.LocalDateTime;


public record RestaurantRequest(String name, String description, String phone,
                                String email, boolean active, String imagemUrl, Address address,
                                LocalDateTime createdAt) {
}
