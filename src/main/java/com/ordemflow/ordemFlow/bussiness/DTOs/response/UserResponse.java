package com.ordemflow.ordemFlow.bussiness.DTOs.response;

import com.ordemflow.ordemFlow.infrastructure.Entity.Address;
import com.ordemflow.ordemFlow.infrastructure.Entity.Typedocument;
import lombok.Builder;

import java.util.List;

@Builder
public record UserResponse(Long id, String name, String email, String password,
                           List<Address> address, Typedocument typedocument, String document) {
}
