package com.myrecipick.core.domain.option;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OptionGroup {

    private UUID id;
    private OptionGroupType type;
    private String name;
    private String image;
    private List<Option> options;
    private OptionPolicy policy;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public OptionGroup() {
    }

    public OptionGroup(UUID id, OptionGroupType type, String name, String image,
        List<Option> options, OptionPolicy policy, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.image = image;
        this.options = options;
        this.policy = policy;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OptionGroupType getType() {
        return type;
    }

    public void setType(OptionGroupType type) {
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

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
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
