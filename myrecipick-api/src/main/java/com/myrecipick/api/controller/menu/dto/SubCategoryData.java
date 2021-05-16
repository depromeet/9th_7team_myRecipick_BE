package com.myrecipick.api.controller.menu.dto;

import com.myrecipick.core.domain.menu.Menu;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class SubCategoryData {

    private UUID id;
    private String name;
    private List<MenuData> menus;

    public static List<SubCategoryData> toData(List<Menu> items) {
        List<SubCategoryData> subCategoryDatas = items.stream()
            .map(item -> new SubCategoryData(item.getSubCategoryId(), item.getSubCategoryName()))
            .distinct()
            .collect(Collectors.toList());

        for(SubCategoryData subCategoryData: subCategoryDatas) {

            List<MenuData> menuData = items.stream()
                .filter(item -> item.isSameSubCategoryId(subCategoryData.getId()))
                .map(MenuData::toData)
                .collect(Collectors.toList());

            subCategoryData.addMenus(menuData);
        }

        return subCategoryDatas;
    }

    private void addMenus(List<MenuData> menuData) {
        this.menus = menuData;
    }

    public SubCategoryData(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuData> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuData> menus) {
        this.menus = menus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubCategoryData that = (SubCategoryData) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects
            .equals(menus, that.menus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, menus);
    }
}
