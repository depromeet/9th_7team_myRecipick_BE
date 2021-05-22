package com.myrecipick.api.controller.my.controller.dto;

import com.myrecipick.api.controller.ServiceResponse;
import com.myrecipick.core.domain.my.MyCustomMenu;
import org.springframework.http.HttpStatus;

public class CreateMyCustomMenuResponse extends ServiceResponse {

    private MyCustomMenu data;

    public static CreateMyCustomMenuResponse ok(MyCustomMenu myCustomMenu) {
        CreateMyCustomMenuResponse response = new CreateMyCustomMenuResponse();
        response.status = HttpStatus.CREATED;
        response.data = myCustomMenu;

        return response;
    }

    public MyCustomMenu getData() {
        return data;
    }
}
