package com.myrecipick.core.domain.home;


import java.time.LocalDateTime;
import java.util.UUID;

public class RecommendCustomMenu {

    private UUID id;
    private String name;
    private String menuName;
    private String image;
    private String backgroundColor;
    private LocalDateTime createdDate;

    public RecommendCustomMenu() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getImage() {
        return image;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }


    public static final class Builder {

        private UUID id;
        private String name;
        private String menuName;
        private String image;
        private String backgroundColor;
        private LocalDateTime createdDate;

        private Builder() {
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder menuName(String menuName) {
            this.menuName = menuName;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Builder backgroundColor(String backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return this;
        }

        public RecommendCustomMenu build() {
            RecommendCustomMenu recommendCustomMenu = new RecommendCustomMenu();
            recommendCustomMenu.image = this.image;
            recommendCustomMenu.name = this.name;
            recommendCustomMenu.menuName = this.menuName;
            recommendCustomMenu.id = this.id;
            recommendCustomMenu.backgroundColor = this.backgroundColor;
            recommendCustomMenu.createdDate = this.createdDate;
            return recommendCustomMenu;
        }
    }
}
