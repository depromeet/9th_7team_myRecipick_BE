package com.myrecipick.core.domain.home;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class RecommendCustomMenuMapper {

    private RecommendCustomMenuMapper() {
    }

    public static RecommendCustomMenuCollection fromMap(Map<String, AttributeValue> attributeValueMap) {
        RecommendCustomMenuCollection collection = new RecommendCustomMenuCollection();
        collection.setId(UUID.fromString(attributeValueMap.get("id").s()));
        collection.setTitle(attributeValueMap.get("title").s());

        List<RecommendCustomMenu> recommendCustomMenu = recommendCustomMenus(attributeValueMap.get("recommendCustomMenus").l());
        collection.setRecommendCustomMenus(recommendCustomMenu);

        return collection;
    }

    private static List<RecommendCustomMenu> recommendCustomMenus(List<AttributeValue> recommendCustomMenus) {
        return recommendCustomMenus.stream()
            .map(AttributeValue::m)
            .map(attribute -> RecommendCustomMenu.builder()
                .id(UUID.fromString(attribute.get("id").s()))
                .name(attribute.get("name").s())
                .menuName(attribute.get("menuName").s())
                .image(attribute.get("image").s())
                .backgroundColor(attribute.get("backgroundColor").s())
                .createdDate(LocalDateTime.parse(attribute.get("createdDate").s()))
                .build())
            .collect(Collectors.toList());
    }
}
