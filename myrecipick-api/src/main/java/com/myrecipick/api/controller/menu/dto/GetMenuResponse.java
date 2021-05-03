package com.myrecipick.api.controller.menu.dto.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.controller.ServiceResponse;
import com.myrecipick.core.domain.menu.Menu;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
public class GetMenuResponse extends ServiceResponse {

    @JsonInclude(Include.NON_NULL)
    private Menu data;

    public GetMenuResponse() {
    }

    public GetMenuResponse(HttpStatus status, String message, Menu data) {
        super(status, message);
        this.data = data;
    }

    public static GetMenuResponse ok(Menu data) {
        GetMenuResponse getOptionGroupResponse = new GetMenuResponse();
        getOptionGroupResponse.status = HttpStatus.OK;
        getOptionGroupResponse.data = data;

        return getOptionGroupResponse;
    }

    public Menu getData() {
        return data;
    }
}
