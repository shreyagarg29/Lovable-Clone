package com.projects.lovableClone.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BadRequestException extends RuntimeException{

    private final String message;
}
