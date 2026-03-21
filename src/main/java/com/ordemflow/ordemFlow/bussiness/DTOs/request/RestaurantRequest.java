package com.ordemflow.ordemFlow.bussiness.DTOs.request;

import com.ordemflow.ordemFlow.infrastructure.Entity.Address;
import com.ordemflow.ordemFlow.infrastructure.Entity.Typedocument;

import java.time.LocalDateTime;


public record RestaurantRequest(String name, String description, String phone,
                                String email, boolean active, String imagemUrl,
                                Address address, Typedocument typedocument,
                                LocalDateTime createdAt) {
}
