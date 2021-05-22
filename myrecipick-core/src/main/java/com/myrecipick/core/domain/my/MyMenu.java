package com.myrecipick.core.domain.my;

import java.util.UUID;

public class MyMenu {

    private UUID id;
    private String name;
    private String image;

    public MyMenu() {
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

    public String getImage() {
        return image;
    }

    public static final class Builder {

        private UUID id;
        private String name;
        private String image;

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

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public MyMenu build() {
            MyMenu myMenu = new MyMenu();
            myMenu.id = this.id;
            myMenu.image = this.image;
            myMenu.name = this.name;
            return myMenu;
        }
    }
}
