package com.example.responses.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micronaut.http.HttpStatus;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result {

    private boolean success;

    private String errorCode;

    private String message;

    @JsonIgnore
    private HttpStatus status;


}
