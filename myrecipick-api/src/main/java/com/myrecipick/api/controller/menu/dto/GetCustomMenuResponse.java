package com.myrecipick.api.controller.menu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.myrecipick.api.controller.ServiceResponse;
import com.myrecipick.core.domain.menu.CustomMenu;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetCustomMenuResponse extends ServiceResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CustomMenu data;

    public GetCustomMenuResponse() {

    }

    public static GetCustomMenuResponse ok(CustomMenu customMenu) {
        GetCustomMenuResponse getCustomMenuResponse = new GetCustomMenuResponse();
        getCustomMenuResponse.status = HttpStatus.OK;
        getCustomMenuResponse.data = customMenu;
        return getCustomMenuResponse;
    }

    public CustomMenu getData() {
        return data;
    }
}
