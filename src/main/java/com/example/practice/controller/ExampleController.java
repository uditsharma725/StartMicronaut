package com.example.practice.controller;


import com.example.practice.service.TestService;
import com.example.responses.ResponseBuilder;
import com.example.responses.utils.Result;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/example")
public class ExampleController implements ResponseBuilder {

    private final TestService testService;

    @Inject
    public ExampleController(
            TestService testService
    ) {
        this.testService =testService;
    }

    @Post("/test")
    public Result testingFunction() {
        return testService.testController();
    }
}
