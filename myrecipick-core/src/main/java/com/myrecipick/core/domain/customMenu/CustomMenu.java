package com.myrecipick.core.domain.customMenu;

import com.myrecipick.core.domain.option.OptionGroup;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CustomMenu {
    private UUID id;
    private UUID userId;
    private UUID menuId;
    private String name;
    private String image;
    private List<OptionGroup> optionGroups;
    private Boolean isShow;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public CustomMenu() {

    }

    public CustomMenu(UUID id, UUID userId, String name, UUID menuId, List<OptionGroup> optionGroups, Boolean isShow, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.menuId = menuId;
        this.optionGroups = optionGroups;
        this.isShow = isShow;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UUID getMenuId() {
        return menuId;
    }

    public void setMenuId(UUID menuId) {
        this.menuId = menuId;
    }

    public List<OptionGroup> getOptionGroups() {
        return optionGroups;
    }

    public void setOptionGroups(List<OptionGroup> optionGroups) {
        this.optionGroups = optionGroups;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean show) {
        isShow = show;
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
