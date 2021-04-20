package com.myrecipick.api.route;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
public class ServiceResponse {

    protected HttpStatus status;
    protected String message;

    public ServiceResponse() {
    }

    public ServiceResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ServiceResponse fail(HttpStatus status, String message) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.status = status;
        serviceResponse.message = message;

        return serviceResponse;
    }

    public int getStatus() {
        return status.value();
    }

    public String getMessage() {
        return message;
    }
}
