package com.myrecipick.core.domain.option;

import java.util.UUID;

public class MenuOptionGroup {

    private UUID id;
    private UUID menuId;
    private UUID optionGroupId;

    public MenuOptionGroup() {
    }

    public MenuOptionGroup(UUID id, UUID menuId, UUID optionGroupId) {
        this.id = id;
        this.menuId = menuId;
        this.optionGroupId = optionGroupId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getMenuId() {
        return menuId;
    }

    public void setMenuId(UUID menuId) {
        this.menuId = menuId;
    }

    public UUID getOptionGroupId() {
        return optionGroupId;
    }

    public void setOptionGroupId(UUID optionGroupId) {
        this.optionGroupId = optionGroupId;
    }
}
