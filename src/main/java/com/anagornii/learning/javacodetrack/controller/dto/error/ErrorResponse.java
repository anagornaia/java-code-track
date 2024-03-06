package com.anagornii.learning.javacodetrack.controller.dto.error;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {
    private LocalDateTime timestamp;
    private ErrorDetails errorData;
}
