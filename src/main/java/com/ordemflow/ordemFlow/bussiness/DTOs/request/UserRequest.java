package com.ordemflow.ordemFlow.bussiness.DTOs.request;

import com.ordemflow.ordemFlow.infrastructure.Entity.Address;
import com.ordemflow.ordemFlow.infrastructure.Entity.Typedocument;

import java.util.List;

public record UserRequest(String name,
                          String email,
                          String password,
                          List<Address> address,
                          String document,
                          Typedocument typedocument) {
}
