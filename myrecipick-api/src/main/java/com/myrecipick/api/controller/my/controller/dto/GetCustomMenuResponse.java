package com.myrecipick.api.controller.my.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.controller.ServiceResponse;
import com.myrecipick.core.domain.my.MyCustomMenu;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
public class GetCustomMenuResponse extends ServiceResponse {

    private MyCustomMenu data;

    public GetCustomMenuResponse() {

    }

    public static GetCustomMenuResponse ok(MyCustomMenu myCustomMenu) {
        GetCustomMenuResponse getCustomMenuResponse = new GetCustomMenuResponse();
        getCustomMenuResponse.status = HttpStatus.OK;
        getCustomMenuResponse.data = myCustomMenu;
        return getCustomMenuResponse;
    }

    public MyCustomMenu getData() {
        return data;
    }
}
