package com.myrecipick.api.controller.my.controller.dto;

import com.myrecipick.core.domain.my.MyCustomMenu;
import com.myrecipick.core.domain.my.MyMenu;
import com.myrecipick.core.domain.my.MyOptionGroup;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CreateMyCustomMenuRequest {
    private String name;
    private MyMenu menu;
    private List<MyOptionGroup> optionGroups;

    public CreateMyCustomMenuRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyMenu getMenu() {
        return menu;
    }

    public void setMenu(MyMenu menu) {
        this.menu = menu;
    }

    public List<MyOptionGroup> getOptionGroups() {
        return optionGroups;
    }

    public void setOptionGroups(List<MyOptionGroup> optionGroups) {
        this.optionGroups = optionGroups;
    }

    public MyCustomMenu toEntity(UUID userId) {
        return MyCustomMenu.builder()
            .userId(userId)
            .name(name)
            .menu(menu)
            .optionGroups(optionGroups)
            .createdDate(LocalDateTime.now())
            .updatedDate(LocalDateTime.now())
            .build();
    }
}
