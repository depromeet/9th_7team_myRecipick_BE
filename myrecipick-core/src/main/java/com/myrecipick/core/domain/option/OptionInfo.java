package com.myrecipick.core.domain.option;

public class OptionInfo {

    private String description;
    private String calorie;
    private String image;

    public OptionInfo() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getDescription() {
        return description;
    }

    public String getCalorie() {
        return calorie;
    }

    public String getImage() {
        return image;
    }


    public static final class Builder {

        private String description;
        private String calorie;
        private String image;

        private Builder() {
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder calorie(String calorie) {
            this.calorie = calorie;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public OptionInfo build() {
            OptionInfo optionInfo = new OptionInfo();
            optionInfo.description = this.description;
            optionInfo.calorie = this.calorie;
            optionInfo.image = this.image;
            return optionInfo;
        }
    }
}
