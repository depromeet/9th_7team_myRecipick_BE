package com.myrecipick.api.route.menu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.route.ServiceResponse;
import com.myrecipick.core.domain.menu.Menu;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonInclude(Include.NON_NULL)
public class GetMenusResponse extends ServiceResponse {

    @JsonInclude(Include.NON_NULL)
    private List<Menu> data;

    public GetMenusResponse() {
    }

    public GetMenusResponse(HttpStatus status, String message,
                            List<Menu> data) {
        super(status, message);
        this.data = data;
    }

    public static GetMenusResponse ok(List<Menu> data) {
        GetMenusResponse getOptionGroupResponse = new GetMenusResponse();
        getOptionGroupResponse.status = HttpStatus.OK;
        getOptionGroupResponse.data = data;

        return getOptionGroupResponse;
    }

    public List<Menu> getData() {
        return data;
    }
}
