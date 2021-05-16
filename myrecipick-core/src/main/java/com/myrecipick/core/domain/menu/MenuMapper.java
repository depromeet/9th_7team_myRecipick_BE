package com.myrecipick.core.domain.menu;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class MenuMapper {

    private static final Comparator<Integer> comp = Integer::compare;

    private MenuMapper() {
    }

    public static List<Menu> fromList(List<Map<String, AttributeValue>> items) {
        return items.stream()
            .map(MenuMapper::fromMap)
            .sorted((item1, item2) -> comp.compare(item1.getOrder(), item2.getOrder()))
            .collect(Collectors.toList());
    }

    public static Menu fromMap(Map<String, AttributeValue> attributeValueMap) {
        Menu menu = new Menu();
        menu.setId(UUID.fromString(attributeValueMap.get("id").s()));
        menu.setName(attributeValueMap.get("name").s());
        menu.setImage(attributeValueMap.get("image").s());
        menu.setIsShow(attributeValueMap.get("isShow").bool());
        menu.setOrder(Integer.parseInt(attributeValueMap.get("order").n()));
        menu.setCreatedDate(LocalDateTime.parse(attributeValueMap.get("createdDate").s()));
        menu.setUpdatedDate(LocalDateTime.parse(attributeValueMap.get("updatedDate").s()));
        menu.setSubCategoryId(UUID.fromString(attributeValueMap.get("subCategoryId").s()));
        menu.setSubCategoryName(attributeValueMap.get("subCategoryName").s());
        return menu;
    }

    public static Map<String, AttributeValue> toMap(Menu menu) {
        return Map.of(
            "id", AttributeValue.builder().s(menu.getId().toString()).build(),
            "name", AttributeValue.builder().s(menu.getName()).build(),
            "image", AttributeValue.builder().s(menu.getImage()).build(),
            "isShow", AttributeValue.builder().bool(menu.getIsShow()).build(),
            "createdDate", AttributeValue.builder().s(menu.getCreatedDate().toString()).build(),
            "updatedDate", AttributeValue.builder().s(menu.getUpdatedDate().toString()).build()
        );
    }
}
