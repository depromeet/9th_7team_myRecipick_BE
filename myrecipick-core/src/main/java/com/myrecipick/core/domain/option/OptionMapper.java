package com.myrecipick.core.domain.option;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class OptionMapper {
    private static final Comparator<Integer> comp = Integer::compare;

    private OptionMapper() {
    }

    public static List<Option> fromList(List<AttributeValue> items) {
        return items.stream()
            .map(AttributeValue::m)
            .map(OptionMapper::fromMap)
            .sorted((item1, item2) -> comp.compare(item1.getOrder(), item2.getOrder()))
            .collect(Collectors.toList());
    }

    public static Option fromMap(Map<String, AttributeValue> attributeValueMap) {
        Option option = new Option();
        option.setName(attributeValueMap.get("name").s());
        if(Objects.nonNull(attributeValueMap.get("description"))) {
            option.setDescription(attributeValueMap.get("description").s());
        }
        if(Objects.nonNull(attributeValueMap.get("description"))) {
            option.setDescription(attributeValueMap.get("description").s());
        }
        if(Objects.nonNull(attributeValueMap.get("calorie"))) {
            option.setCalorie(attributeValueMap.get("calorie").s());
        }
        option.setType(OptionType.valueOf(attributeValueMap.get("type").s()));
        option.setImage(attributeValueMap.get("image").s());
        option.setOrder(Integer.parseInt(attributeValueMap.get("order").n()));
        return option;
    }

}
