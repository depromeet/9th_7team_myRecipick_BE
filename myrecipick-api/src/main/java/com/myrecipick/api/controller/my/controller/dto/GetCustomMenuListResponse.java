package com.myrecipick.api.controller.my.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.controller.ServiceResponse;
import com.myrecipick.core.domain.my.MyCustomMenu;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
public class GetCustomMenuListResponse extends ServiceResponse {

    private List<CustomMenuDto> data;

    public GetCustomMenuListResponse() {
    }

    public static GetCustomMenuListResponse ok(List<MyCustomMenu> menus) {
        GetCustomMenuListResponse response = new GetCustomMenuListResponse();
        response.status = HttpStatus.OK;
        response.data = menus.stream()
            .map(CustomMenuDto::new)
            .collect(Collectors.toList());
        return response;
    }

    public List<CustomMenuDto> getData() {
        return data;
    }
}
