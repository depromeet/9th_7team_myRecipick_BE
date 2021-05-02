package com.myrecipick.api.controller.menu.dto;

import com.myrecipick.core.domain.menu.Menu;
import lombok.Data;

import java.util.UUID;

@Data
public class MenuDto {
    private UUID id;
    private UUID brandId;
    private String name;
    private String description;
    private String logoImage;
    private Boolean isShow;

    public MenuDto(Menu menu) {
        id = menu.getId();
        brandId = menu.getBrandId();
        name = menu.getName();
        logoImage = menu.getLogoImage();
        isShow = menu.getIsShow();
        description = "참깨빵 위에 순쇠고기 패티두장 특별한 소스 양상추 치즈 피클 양파까지";
    }
}
