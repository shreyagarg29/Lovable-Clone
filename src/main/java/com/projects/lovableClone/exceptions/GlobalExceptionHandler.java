package com.projects.lovableClone.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice // to intercept all MVC request use this
public class GlobalExceptionHandler {

    //Thrown by us
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiException> handlesBadRequest(BadRequestException ex){
        ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST, ex.getMessage());
        log.error(apiException.toString(), ex);
        return ResponseEntity.status(apiException.status()).body(apiException);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiException> handlesResourceNotFound(ResourceNotFoundException ex){
        ApiException apiException = new ApiException(HttpStatus.NOT_FOUND, ex.getResourceName() + " with id " + ex.getResourceId() + " not found");
        log.error(apiException.toString(), ex);
        return ResponseEntity.status(apiException.status()).body(apiException);
    }

    //used when jakarta validation fails, automatically caught by spring boot
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiException> handlesInputValidationError(MethodArgumentNotValidException ex){
        List<ApiFieldException> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new ApiFieldException(fieldError.getField(), fieldError.getDefaultMessage()))
                .toList();

        ApiException apiException = new ApiException(HttpStatus.BAD_REQUEST, "Input Validation Failed", errors);
        log.error(apiException.toString(), ex);
        return ResponseEntity.status(apiException.status()).body(apiException);
    }
}
