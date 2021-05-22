package com.myrecipick.api.controller.my.controller;

import com.myrecipick.api.controller.ServiceResponse;
import org.springframework.http.HttpStatus;

public class DeleteMyCustomMenuResponse extends ServiceResponse {

    public static DeleteMyCustomMenuResponse ok() {
        DeleteMyCustomMenuResponse response = new DeleteMyCustomMenuResponse();
        response.status = HttpStatus.NO_CONTENT;
        return response;
    }
}
