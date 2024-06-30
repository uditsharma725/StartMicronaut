package com.example.responses;

import com.example.responses.utils.Result;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;

public interface ResponseBuilder {

    default HttpResponse buildResponse(Result result, Object response) {
        if(result.isSuccess()) return HttpResponse.ok(response);

        if(!HttpStatus.OK.equals(result.getStatus())) {
            if(result.getStatus() == HttpStatus.BAD_REQUEST) return HttpResponse.badRequest(response);
        }
        return HttpResponse.ok(response);
    }
}
