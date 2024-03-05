package com.anagornii.learning.javacodetrack.exception;

import lombok.Getter;

@Getter
public enum ExceptionType {

    POST_NOT_FOUND("Blog post not found", 404),
    INTERNAL_SERVER_ERROR("Internal server error", 500);

    final String message;
    final int statusCode;


    ExceptionType(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
