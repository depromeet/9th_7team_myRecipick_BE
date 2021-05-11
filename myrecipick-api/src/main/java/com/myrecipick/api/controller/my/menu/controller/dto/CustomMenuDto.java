package com.myrecipick.api.controller.my.menu.controller.dto;

import com.myrecipick.core.domain.menu.Menu;
import lombok.Data;

import java.util.UUID;

@Data
public class CustomMenuDto {
    private UUID id;
    private UUID brandId;
    private String name;
    private String description;
    private String image;
    private Boolean isShow;

    public CustomMenuDto(Menu menu) {
        id = menu.getId();
        brandId = menu.getBrandId();
        name = menu.getName();
        image = menu.getImage();
        isShow = menu.getIsShow();
        description = "참깨빵 위에 순쇠고기 패티두장 특별한 소스 양상추 치즈 피클 양파까지";
    }
}
