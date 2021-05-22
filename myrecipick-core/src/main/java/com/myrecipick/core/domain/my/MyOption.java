package com.myrecipick.core.domain.my;

public class MyOption {
    private String name;
    private String image;

    public MyOption() {
    }

    public MyOption(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public static final class Builder {

        private String name;
        private String image;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public MyOption build() {
            return new MyOption(name, image);
        }
    }
}
