package com.myrecipick.api.controller.menu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.controller.ServiceResponse;
import java.util.List;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
public class GetMenusResponse extends ServiceResponse {

    @JsonInclude(Include.NON_NULL)
    private List<SubCategoryData> data;

    public GetMenusResponse() {
    }

    public GetMenusResponse(HttpStatus status, String message,
                            List<SubCategoryData> data) {
        super(status, message);
        this.data = data;
    }

    public static GetMenusResponse ok(List<SubCategoryData> data) {
        GetMenusResponse getOptionGroupResponse = new GetMenusResponse();
        getOptionGroupResponse.status = HttpStatus.OK;
        getOptionGroupResponse.data = data;

        return getOptionGroupResponse;
    }

    public List<SubCategoryData> getData() {
        return data;
    }
}
