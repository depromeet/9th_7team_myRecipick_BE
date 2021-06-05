package com.myrecipick.api.controller.help.dto;

import com.myrecipick.api.controller.ServiceResponse;
import org.springframework.http.HttpStatus;

public class SaveRequestBrandResponse extends ServiceResponse {

    public static SaveRequestBrandResponse ok() {
        SaveRequestBrandResponse response = new SaveRequestBrandResponse();
        response.status = HttpStatus.CREATED;
        return response;
    }
}
