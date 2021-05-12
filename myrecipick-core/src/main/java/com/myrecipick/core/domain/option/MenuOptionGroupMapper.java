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
        menuOptionGroup.setOptionGroupId(UUID.fromString(attributeValueMap.get("optionGroupId").s()));

        return menuOptionGroup;
    }
}
