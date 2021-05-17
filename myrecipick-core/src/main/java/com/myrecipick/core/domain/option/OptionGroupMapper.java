package com.myrecipick.core.domain.option;

import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class OptionGroupMapper {
    private static final Comparator<Integer> comp = Integer::compare;

    public static List<OptionGroup> fromList(List<AttributeValue> items) {
        return items.stream()
            .map(AttributeValue::m)
            .map(OptionGroupMapper::fromMap)
            .collect(Collectors.toList());
    }

    public static OptionGroup fromMap(Map<String, AttributeValue> attributeValueMap) {
        if (attributeValueMap.isEmpty()) return OptionGroup.EMPTY;

        OptionGroup optionGroup = new OptionGroup();
        optionGroup.setId(UUID.fromString(attributeValueMap.get("id").s()));
        optionGroup.setName(attributeValueMap.get("name").s());
        optionGroup.setType(OptionGroupType.valueOf(attributeValueMap.get("type").s()));
        optionGroup.setImage(attributeValueMap.get("image").s());
        optionGroup.setOptions(OptionMapper.fromList(attributeValueMap.get("options").l()));
        optionGroup.setOrder(Integer.parseInt(attributeValueMap.get("order").n()));
        optionGroup.setPolicy(OptionPolicy.of(attributeValueMap.get("policy").m()));
        optionGroup.setCreatedDate(LocalDateTime.parse(attributeValueMap.get("createdDate").s()));
        optionGroup.setUpdatedDate(LocalDateTime.parse(attributeValueMap.get("updatedDate").s()));
        return optionGroup;
    }

}
