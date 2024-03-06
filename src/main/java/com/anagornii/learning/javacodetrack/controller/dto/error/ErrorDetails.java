package com.anagornii.learning.javacodetrack.controller.dto.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDetails {
    private String message;
    private String code;
}
