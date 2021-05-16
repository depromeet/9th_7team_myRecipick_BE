package com.myrecipick.core.domain.option;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class MenuOptionGroupMapper {

    private MenuOptionGroupMapper() {
    }

    public static List<MenuOptionGroup> fromList(List<Map<String, AttributeValue>> items) {
        return items.stream()
            .map(MenuOptionGroupMapper::fromMap)
            .collect(Collectors.toList());
    }

    public static MenuOptionGroup fromMap(Map<String, AttributeValue> attributeValueMap) {
        MenuOptionGroup menuOptionGroup = new MenuOptionGroup();
        menuOptionGroup.setId(UUID.fromString(attributeValueMap.get("id").s()));
        menuOptionGroup.setMenuId(UUID.fromString(attributeValueMap.get("menuId").s()));
        menuOptionGroup.setOptionGroupIds(getOptionGroupIds(attributeValueMap));

        return menuOptionGroup;
    }

    private static List<UUID> getOptionGroupIds(Map<String, AttributeValue> attributeValueMap) {
        List<AttributeValue> optionGroupIds = attributeValueMap.get("optionGroupIds").l();
        return optionGroupIds.stream()
            .map(AttributeValue::s)
            .map(UUID::fromString)
            .collect(Collectors.toList());
    }
}
