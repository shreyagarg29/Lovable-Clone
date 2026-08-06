package com.projects.lovableClone.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude; //Jackson library is used to convert json object to java object and vice versa ---- This is also known as serialization and deserialization
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

public record ApiException (
        HttpStatus status,
        String message,
        Instant timestamp,
        @JsonInclude(JsonInclude.Include.NON_NULL) List<ApiFieldException> errors //include errors only when they are not null
){
    //Creating constructor
    public ApiException(HttpStatus status, String message){
        this(status, message, Instant.now(), null);
    }

    public ApiException(HttpStatus status, String message, List<ApiFieldException> errors){
        this(status, message, Instant.now(), errors);
    }

}

//passing apiException fields for field exceptions
record ApiFieldException(String field, String message){}
