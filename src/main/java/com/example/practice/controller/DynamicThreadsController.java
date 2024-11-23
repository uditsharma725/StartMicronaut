package com.example.practice.controller;

import com.example.practice.service.TestService;
import com.example.responses.utils.Result;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;

@Slf4j
@Controller("/dynamic")
public class DynamicThreadsController {

    private final TestService testService;

    @Inject
    public DynamicThreadsController(
            TestService testService
    ) {
        this.testService = testService;
    }

    @Post("/test")
    public Publisher<Result> dynamicThreads() {

        // the main thread is not blocked

        // the callable inside the flowable is only called when the Flowable is subscribed to
        return Flowable.fromCallable(()-> {
            log.info("Request on dynamic thread controller");
            return testService.testController();
        }).subscribeOn(Schedulers.io());        // dynamic thread allocation
        // threads created when needed and reused when needed
        // handle burst requests without being constrained by a fixed thread pool
    }
}
