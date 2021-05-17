package com.myrecipick.core.domain.customMenu;

import com.myrecipick.core.domain.option.OptionGroupMapper;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

public class CustomMenuMapper {
    private CustomMenuMapper() {
    }

    public static CustomMenu fromMap(Map<String, AttributeValue> attributeValueMap) {
        CustomMenu menu = new CustomMenu();
        menu.setId(UUID.fromString(attributeValueMap.get("id").s()));
        menu.setMenuId(UUID.fromString(attributeValueMap.get("menuId").s()));
        menu.setUserId(UUID.fromString(attributeValueMap.get("userId").s()));
        menu.setName(attributeValueMap.get("name").s());
        menu.setImage(attributeValueMap.get("image").s());
        menu.setOptionGroups(OptionGroupMapper.fromList(attributeValueMap.get("optionGroupList").l()));
        menu.setIsShow(attributeValueMap.get("isShow").bool());
        menu.setCreatedDate(LocalDateTime.parse(attributeValueMap.get("createdDate").s()));
        menu.setUpdatedDate(LocalDateTime.parse(attributeValueMap.get("updatedDate").s()));
        return menu;
    }

    public static Map<String, AttributeValue> toMap(CustomMenu customMenu) {
        return Map.of(
            "id", AttributeValue.builder().s(customMenu.getId().toString()).build(),
            "menuId", AttributeValue.builder().s(customMenu.getMenuId().toString()).build(),
            "userId", AttributeValue.builder().s(customMenu.getUserId().toString()).build(),
            "name", AttributeValue.builder().s(customMenu.getName()).build(),
            "image", AttributeValue.builder().s(customMenu.getImage()).build(),
            "optionGroupList", AttributeValue.builder().l((Consumer<AttributeValue.Builder>) customMenu.getOptionGroups()).build(),
            "isShow", AttributeValue.builder().bool(customMenu.getIsShow()).build(),
            "createdDate", AttributeValue.builder().s(customMenu.getCreatedDate().toString()).build(),
            "updatedDate", AttributeValue.builder().s(customMenu.getUpdatedDate().toString()).build()
        );
    }
}
