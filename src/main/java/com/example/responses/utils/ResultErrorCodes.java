package com.example.responses.utils;

import io.micronaut.http.HttpStatus;
import lombok.Getter;

@Getter
public enum ResultErrorCodes {

    ACCEPTED("Request Accepted for processing", "ACCEPTED", HttpStatus.ACCEPTED),
    ERROR("Some error occurred during processing the request", "ERROR", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String message;

    @Getter
    private final String errorCode;

    @Getter
    private final HttpStatus status;

    ResultErrorCodes(String message, String errorCode, HttpStatus status) {
        this.message = message;
        this.errorCode = errorCode;
        this.status = status;
    }

}
