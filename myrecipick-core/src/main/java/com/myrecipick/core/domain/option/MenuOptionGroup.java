package com.myrecipick.core.domain.option;

import java.util.List;
import java.util.UUID;

public class MenuOptionGroup {

    private UUID id;
    private UUID menuId;
    private List<UUID> optionGroupIds;

    public MenuOptionGroup() {
    }

    public MenuOptionGroup(UUID id, UUID menuId, List<UUID> optionGroupIds) {
        this.id = id;
        this.menuId = menuId;
        this.optionGroupIds = optionGroupIds;
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

    public List<UUID> getOptionGroupIds() {
        return optionGroupIds;
    }

    public void setOptionGroupIds(List<UUID> optionGroupIds) {
        this.optionGroupIds = optionGroupIds;
    }
}
