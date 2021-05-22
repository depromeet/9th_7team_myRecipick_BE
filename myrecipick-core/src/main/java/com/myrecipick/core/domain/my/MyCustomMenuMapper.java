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

        MyMenu myMenu = getMyMenu(attributeValueMap.get("menu").m());
        menu.setMenu(myMenu);

        List<MyOptionGroup> myOptionGroup = getMyOptionGroup(attributeValueMap.get("optionGroups").l());
        menu.setOptionGroups(myOptionGroup);

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

    private static MyMenu getMyMenu(Map<String, AttributeValue> menu) {
        return MyMenu.builder()
            .id(UUID.fromString(menu.get("id").s()))
            .name(menu.get("name").s())
            .image(menu.get("image").s()).build();
    }

    private static List<MyOptionGroup> getMyOptionGroup(List<AttributeValue> optionGroups) {
        return optionGroups.stream()
            .map(AttributeValue::m)
            .map(attribute -> MyOptionGroup.builder()
                .id(UUID.fromString(attribute.get("id").s()))
                .name(attribute.get("name").s())
                .options(getOptions(attribute.get("options").l()))
                .build())
            .collect(Collectors.toList());
    }

    private static List<MyOption> getOptions(List<AttributeValue> options) {
        return options.stream()
            .map(AttributeValue::m)
            .map(attribute -> MyOption.builder()
                .name(attribute.get("name").s())
                .image(attribute.get("image").s())
                .build())
            .collect(Collectors.toList());

    }

}
