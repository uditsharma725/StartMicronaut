package com.example.practice.controller;


import com.example.responses.ResponseBuilder;
import com.example.responses.utils.Result;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.reactivestreams.Publisher;

@Controller("/example")
public class ExampleController implements ResponseBuilder {

    @Get("/start")
    @ApiResponse(responseCode = "200", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "500", description = "Some error occurred please try after some time")
    public Publisher<? extends HttpResponse> print() {
        return Flowable.fromCallable(()-> {

            Result result = Result.builder()
                    .message("test response")
                    .status(HttpStatus.ACCEPTED)
                    .success(true)
                    .build();

            return buildResponse(result, null);
        }).subscribeOn(Schedulers.io());

    }
}
