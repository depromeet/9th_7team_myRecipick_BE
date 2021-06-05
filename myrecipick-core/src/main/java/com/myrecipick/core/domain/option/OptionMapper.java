package com.myrecipick.core.domain.option;

import com.myrecipick.core.domain.option.OptionInfo.Builder;
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


        if(Objects.nonNull(attributeValueMap.get("info"))) {
            OptionInfo optionInfo = getInfo(attributeValueMap.get("info").m());
            option.setInfo(optionInfo);
        }

        option.setType(OptionType.valueOf(attributeValueMap.get("type").s()));
        option.setImage(attributeValueMap.get("image").s());
        option.setOrder(Integer.parseInt(attributeValueMap.get("order").n()));
        return option;
    }

    private static OptionInfo getInfo(Map<String, AttributeValue> info) {
        Builder builder = OptionInfo.builder();
        if(Objects.nonNull(info.get("description"))) {
            builder.description(info.get("description").s());
        }

        if(Objects.nonNull(info.get("calorie"))) {
            builder.calorie(info.get("calorie").s());
        }

        if(Objects.nonNull(info.get("image"))) {
            builder.image(info.get("image").s());
        }
        return builder.build();
    }

}
