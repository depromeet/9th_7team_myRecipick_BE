package com.myrecipick.core.domain.my;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

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
            "menu", AttributeValue.builder().m(makeMenu(customMenu.getMenu())).build(),
            "optionGroups", AttributeValue.builder().l(makeOptionGroups(customMenu.getOptionGroups())).build(),
            "createdDate", AttributeValue.builder().s(customMenu.getCreatedDate().toString()).build(),
            "updatedDate", AttributeValue.builder().s(customMenu.getUpdatedDate().toString()).build()
        );
    }

    private static Map<String, AttributeValue> makeMenu(MyMenu menu) {
        return Map.of(
            "id", AttributeValue.builder().s(menu.getId().toString()).build(),
            "name", AttributeValue.builder().s(menu.getName()).build(),
            "image",AttributeValue.builder().s(menu.getImage()).build()
        );
    }

    private static List<AttributeValue> makeOptionGroups(List<MyOptionGroup> optionGroups) {
        return optionGroups.stream()
            .map(optionGroup -> AttributeValue.builder().m(
                Map.of(
                    "id", AttributeValue.builder().s(optionGroup.getId().toString()).build(),
                    "name", AttributeValue.builder().s(optionGroup.getName()).build(),
                    "options",AttributeValue.builder().l(
                        makeOptions(optionGroup.getOptions())
                    ).build()
                )
            ).build())
            .collect(Collectors.toList());
    }

    private static List<AttributeValue> makeOptions(List<MyOption> options) {
        return options.stream()
            .map(option -> AttributeValue.builder().m(
                Map.of(
                    "name", AttributeValue.builder().s(option.getName()).build(),
                    "image",AttributeValue.builder().s(option.getImage()).build()
                )
            ).build())
            .collect(Collectors.toList());
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
