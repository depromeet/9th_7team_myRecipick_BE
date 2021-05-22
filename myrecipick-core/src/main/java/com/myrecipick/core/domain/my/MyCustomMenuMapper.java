package com.myrecipick.core.domain.my;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class MyCustomMenuMapper {
    private MyCustomMenuMapper() {
    }

    public static List<MyCustomMenu> fromList(List<Map<String, AttributeValue>> items) {
        return items.stream()
            .map(MyCustomMenuMapper::fromMap)
            .collect(Collectors.toList());
    }

    public static MyCustomMenu fromMap(Map<String, AttributeValue> attributeValueMap) {
        MyCustomMenu menu = new MyCustomMenu();
        menu.setId(UUID.fromString(attributeValueMap.get("id").s()));
        menu.setUserId(UUID.fromString(attributeValueMap.get("userId").s()));
        menu.setName(attributeValueMap.get("name").s());
        menu.setCreatedDate(LocalDateTime.parse(attributeValueMap.get("createdDate").s()));
        menu.setUpdatedDate(LocalDateTime.parse(attributeValueMap.get("updatedDate").s()));
        return menu;
    }

    public static Map<String, AttributeValue> toMap(MyCustomMenu customMenu) {
        return Map.of(
            "id", AttributeValue.builder().s(customMenu.getId().toString()).build(),
            "userId", AttributeValue.builder().s(customMenu.getUserId().toString()).build(),
            "name", AttributeValue.builder().s(customMenu.getName()).build(),
            "createdDate", AttributeValue.builder().s(customMenu.getCreatedDate().toString()).build(),
            "updatedDate", AttributeValue.builder().s(customMenu.getUpdatedDate().toString()).build()
        );
    }
}
