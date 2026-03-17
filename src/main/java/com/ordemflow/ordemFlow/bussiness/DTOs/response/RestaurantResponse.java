package com.ordemflow.ordemFlow.bussiness.DTOs.response;

import com.ordemflow.ordemFlow.infrastructure.Entity.Address;
import com.ordemflow.ordemFlow.infrastructure.Entity.Typedocument;
import lombok.Builder;

import java.time.LocalDateTime;


@Builder
public record RestaurantResponse(Long id, String name, String description,
                                 String phone, String email, String imagemUrl, Address address,
                                 boolean active, LocalDateTime createdAt,
                                 Typedocument typedocument) {
}
