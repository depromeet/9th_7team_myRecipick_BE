package com.myrecipick.api.controller.my.menu.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.myrecipick.api.controller.ServiceResponse;
import com.myrecipick.core.domain.menu.Menu;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;

@JsonInclude(Include.NON_NULL)
public class GetCustomMenuListResponse extends ServiceResponse {

    @JsonInclude(Include.NON_NULL)
    private List<CustomMenuDto> data;

    public GetCustomMenuListResponse() {

    }

    public static GetCustomMenuListResponse ok(List<Menu> menus) {
        GetCustomMenuListResponse getCustomMenuListResponse = new GetCustomMenuListResponse();
        getCustomMenuListResponse.status = HttpStatus.OK;
        getCustomMenuListResponse.data = menus.stream()
            .map(CustomMenuDto::new)
            .collect(Collectors.toList());
        return getCustomMenuListResponse;
    }

    public List<CustomMenuDto> getData() {
        return data;
    }
}
