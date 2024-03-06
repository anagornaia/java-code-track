package com.anagornii.learning.javacodetrack.controller.advice;

import com.anagornii.learning.javacodetrack.controller.dto.ErrorDetails;
import com.anagornii.learning.javacodetrack.controller.dto.ErrorResponse;
import com.anagornii.learning.javacodetrack.exception.ExceptionType;
import com.anagornii.learning.javacodetrack.exception.JavaCodeTrackException;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * This class extends ResponseEntityExceptionHandler to provide centralized exception handling across all {@code @RequestMapping} methods through
 * {@code @ExceptionHandler} methods.
 * It provides handling for exceptions thrown from request processing (controller methods), with a consistent style
 * that can be customized through configuration.
 *
 * <p>It handles {@link com.anagornii.learning.javacodetrack.exception.JavaCodeTrackException} type exceptions.
 *
 * <p>When a JavaCodeTrackException is thrown, the handle method is invoked to process the exception and to create a suitable ResponseEntity.
 * The ResponseEntity contains an instance of ErrorData, which includes the exception code, message, and timestamp.
 *
 * @author anagornaia
 * @version 2023.3.4
 * @since 1.0
 */
@ControllerAdvice
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {

    /**
     * Handles JavaCodeTrackException type exceptions.
     *
     * @param ex the JavaCodeTrackException to be handled.
     * @return a ResponseEntity object that includes the HTTP status code and the details of the exception.
     */
    @ExceptionHandler(value = {JavaCodeTrackException.class})
    protected ResponseEntity<ErrorResponse> handleKnownException(JavaCodeTrackException ex) {
        return ResponseEntity.status(HttpStatus.valueOf(ex.getErrorType().getStatusCode()))
            .contentType(MediaType.APPLICATION_JSON)
            .body(ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .errorData(ErrorDetails.builder()
                    .message(ex.getErrorType().getMessage())
                    .code(ex.getErrorType().name())
                    .build())
                .build());
    }

    /**
     * Handle unknown exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<ErrorResponse> handleUnknownException(RuntimeException ex) {
        return handleKnownException(JavaCodeTrackException.of(ExceptionType.INTERNAL_SERVER_ERROR, ex));
    }
}
