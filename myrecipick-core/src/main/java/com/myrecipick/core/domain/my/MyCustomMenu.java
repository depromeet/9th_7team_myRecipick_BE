package com.myrecipick.core.domain.my;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public static Builder builder() {
        return new Builder();
    }

    public UUID getId() {
        if(Objects.isNull(id)) {
            return UUID.randomUUID();
        }
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

    public String createDescription() {
        return menu.getName()
            + ", "
            + optionGroups.stream()
            .map(MyOptionGroup::makeDescription)
            .collect(Collectors.joining(", "));
    }

    @JsonIgnore
    public String getMenuImage() {
        return menu.getImage();
    }

    public static final class Builder {

        private UUID id;
        private UUID userId;
        private String name;
        private MyMenu menu;
        private List<MyOptionGroup> optionGroups;
        private LocalDateTime createdDate;
        private LocalDateTime updatedDate;

        private Builder() {
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder userId(UUID userId) {
            this.userId = userId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder menu(MyMenu menu) {
            this.menu = menu;
            return this;
        }

        public Builder optionGroups(List<MyOptionGroup> optionGroups) {
            this.optionGroups = optionGroups;
            return this;
        }

        public Builder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public Builder updatedDate(LocalDateTime updatedDate) {
            this.updatedDate = updatedDate;
            return this;
        }

        public MyCustomMenu build() {
            MyCustomMenu myCustomMenu = new MyCustomMenu();
            myCustomMenu.setId(id);
            myCustomMenu.setUserId(userId);
            myCustomMenu.setName(name);
            myCustomMenu.setMenu(menu);
            myCustomMenu.setOptionGroups(optionGroups);
            myCustomMenu.setCreatedDate(createdDate);
            myCustomMenu.setUpdatedDate(updatedDate);
            return myCustomMenu;
        }
    }
}
