package com.myrecipick.core.domain.option;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class OptionMapper {

    private OptionMapper() {
    }

    public static List<Option> fromList(List<AttributeValue> items) {
        return items.stream()
            .map(AttributeValue::m)
            .map(OptionMapper::fromMap)
            .collect(Collectors.toList());
    }

    public static Option fromMap(Map<String, AttributeValue> attributeValueMap) {
        Option optionGroup = new Option();
        optionGroup.setName(attributeValueMap.get("name").s());
        optionGroup.setType(OptionType.valueOf(attributeValueMap.get("type").s()));
        optionGroup.setImage(attributeValueMap.get("image").s());
        return optionGroup;
    }

}
