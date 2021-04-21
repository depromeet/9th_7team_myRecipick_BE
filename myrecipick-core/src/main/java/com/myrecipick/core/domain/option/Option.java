package com.myrecipick.core.domain.option;

import java.time.LocalDateTime;
import java.util.UUID;

public class Option {

    private UUID id;
    private OptionType type;
    private String name;
    private String image;

    private OptionPolicy policy;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public Option() {
    }

    public Option(UUID id, OptionType type, String name, String image,
        OptionPolicy optionPolicy, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.image = image;
        this.policy = optionPolicy;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public OptionPolicy getPolicy() {
        return policy;
    }

    public void setPolicy(OptionPolicy policy) {
        this.policy = policy;
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
}
