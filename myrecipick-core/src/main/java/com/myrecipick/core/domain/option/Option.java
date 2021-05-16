package com.myrecipick.core.domain.option;

public class Option {

    private OptionType type;
    private String name;
    private String image;
    private int order;

    public Option() {
    }

    public Option(OptionType type, String name, String image) {
        this.type = type;
        this.name = name;
        this.image = image;
    }

    public OptionType getType() {
        return type;
    }

    public void setType(OptionType type) {
        this.type = type;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
