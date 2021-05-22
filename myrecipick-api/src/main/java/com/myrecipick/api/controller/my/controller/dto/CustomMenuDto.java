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
        image = menu.getMenuImage();
        description = menu.createDescription();
        createdDate = menu.getCreatedDate();
    }
}
