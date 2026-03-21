package com.ordemflow.ordemFlow.infrastructure.exception;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timestamp,
                           String message,
                           String detais) {
}
