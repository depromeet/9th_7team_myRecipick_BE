package com.myrecipick.core.domain.my;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class MyCustomMenu {
    private UUID id;
    private UUID userId;
    private String name;

    private MyMenu menu;
    private List<MyOptionGroup> optionGroups;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public MyCustomMenu() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }


}
