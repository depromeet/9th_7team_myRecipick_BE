package com.myrecipick.api.controller.my.controller.dto;

import com.myrecipick.core.domain.my.MyCustomMenu;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class CustomMenuDto {
    private UUID id;
    private String name;
    private String description;
    private String image;
    private LocalDateTime createdDate;

    public CustomMenuDto(MyCustomMenu menu) {
        id = menu.getId();
        name = menu.getName();
        image = menu.getMenu().getImage();
        description = "참깨빵 위에 순쇠고기 패티두장 특별한 소스 양상추 치즈 피클 양파까지";
        createdDate = menu.getCreatedDate();
    }
}
