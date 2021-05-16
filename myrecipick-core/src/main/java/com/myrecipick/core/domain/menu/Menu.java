package com.myrecipick.core.domain.menu;

import java.time.LocalDateTime;
import java.util.UUID;

public class Menu {

    private UUID id;
    private UUID brandId;
    private String name;
    private String image;
    private Boolean isShow;
    private int order;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    private UUID subCategoryId;
    private String subCategoryName;

    public Menu() {
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

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean show) {
        isShow = show;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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

    public UUID getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(UUID subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public boolean isSameSubCategoryId(UUID subCategoryId) {
        return this.subCategoryId.equals(subCategoryId);
    }
}
