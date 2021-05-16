package com.myrecipick.api.controller.menu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.controller.ServiceResponse;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
public class GetMenuResponse extends ServiceResponse {

    @JsonInclude(Include.NON_NULL)
    private MenuData data;

    public GetMenuResponse() {
    }

    public GetMenuResponse(HttpStatus status, String message, MenuData data) {
        super(status, message);
        this.data = data;
    }

    public static GetMenuResponse ok(MenuData data) {
        GetMenuResponse getOptionGroupResponse = new GetMenuResponse();
        getOptionGroupResponse.status = HttpStatus.OK;
        getOptionGroupResponse.data = data;

        return getOptionGroupResponse;
    }

    public MenuData getData() {
        return data;
    }
}
