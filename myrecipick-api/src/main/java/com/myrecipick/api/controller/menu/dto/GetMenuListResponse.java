package com.myrecipick.api.controller.menu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.route.ServiceResponse;
import com.myrecipick.core.domain.menu.Menu;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(Include.NON_NULL)
public class GetMenuListResponse extends ServiceResponse {

    @JsonInclude(Include.NON_NULL)
    private List<MenuDto> data;

    public GetMenuListResponse() {

    }

    public static GetMenuListResponse ok(List<Menu> menus) {
        GetMenuListResponse getMenuListResponse = new GetMenuListResponse();
        getMenuListResponse.status = HttpStatus.OK;
        getMenuListResponse.data = menus.stream()
            .map(MenuDto::new)
            .collect(Collectors.toList());
        return getMenuListResponse;
    }

    public List<MenuDto> getData() {
        return data;
    }
}
