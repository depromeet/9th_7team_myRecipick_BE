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

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
