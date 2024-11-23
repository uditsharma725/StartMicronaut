package com.example.practice.service;

import com.example.responses.utils.Result;
import io.micronaut.http.HttpStatus;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class TestService {

    public Result testController() {
        Result result = Result.builder()
                .success(true)
                .message("Test controller working fine")
                .errorCode("Success")
                .status(HttpStatus.OK)
                .build();

        return result;
    }
}
