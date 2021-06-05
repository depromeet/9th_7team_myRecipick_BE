package com.myrecipick.core.domain.home;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.UUID;

public class RecommendCustomMenuCollection {

    @JsonInclude
    private UUID id;
    private String title;
    private List<RecommendCustomMenu> recommendCustomMenus;

    public RecommendCustomMenuCollection() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RecommendCustomMenu> getRecommendCustomMenus() {
        return recommendCustomMenus;
    }

    public void setRecommendCustomMenus(List<RecommendCustomMenu> recommendCustomMenus) {
        this.recommendCustomMenus = recommendCustomMenus;
    }
}
