package uk.ac.ed.acp.cw2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for REST controllers.
 * Catches malformed or unreadable JSON requests
 * and returns HTTP 400 (Bad Request) response
 */
@RestControllerAdvice
public class RestExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    /**
     * Handles HTTP message not readable exceptions and logs the error message.
     * @param exception the HttpMessageNotReadableException to handle
     * @return a ResponseEntity with HTTP 400 (Bad Request)
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        logger.warn("Malformed JSON in request: {}", exception.getMessage());
        return ResponseEntity.badRequest().build();
    }

    /**
     * Handles validation exceptions and logs the error message.
     * @param exception the MethodArgumentNotValidException to handle
     * @return a ResponseEntity with HTTP 400 (Bad Request)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException exception) {
        StringBuilder logMessage = new StringBuilder();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            // Example output: "position1.lat: Latitude must be provided!"
            logMessage.append(fieldError.getObjectName())
                    .append(".")
                    .append(fieldError.getField())
                    .append(": ")
                    .append(fieldError.getDefaultMessage())
                    .append("\n");
        }
        logger.warn("Validation error: \n{}", logMessage.toString());
        return ResponseEntity.badRequest().build();
    }
}
