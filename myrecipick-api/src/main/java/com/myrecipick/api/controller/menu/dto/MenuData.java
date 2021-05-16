package com.myrecipick.api.controller.menu.dto;

import com.myrecipick.core.domain.menu.Menu;
import java.time.LocalDateTime;
import java.util.UUID;

public class MenuData {

    private UUID id;
    private UUID brandId;
    private String name;
    private String image;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public MenuData() {
    }

    public static MenuData toData(Menu item) {
        MenuData menuData = new MenuData();

        menuData.setId(item.getId());
        menuData.setBrandId(item.getBrandId());
        menuData.setName(item.getName());
        menuData.setImage(item.getImage());
        menuData.setCreatedDate(item.getCreatedDate());
        menuData.setUpdatedDate(item.getUpdatedDate());

        return menuData;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getBrandId() {
        return brandId;
    }

    public void setBrandId(UUID brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
