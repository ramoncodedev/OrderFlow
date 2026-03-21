package com.ordemflow.ordemFlow.infrastructure.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;






@Getter
public enum Typedocument {

    CPF("CPF"),
    CNPJ("CNPJ");

    private String document;

    private Typedocument(String description) {
        this.document = description;
    }





}
