package com.myrecipick.api.route.menu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.route.ServiceResponse;
import com.myrecipick.core.domain.menu.Menu;
import com.myrecipick.core.domain.option.OptionGroup;
import java.util.List;
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
