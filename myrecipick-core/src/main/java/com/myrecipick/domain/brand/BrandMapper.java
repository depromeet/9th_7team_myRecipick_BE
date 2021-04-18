package com.myrecipick.domain.brand;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class BrandMapper {

    private BrandMapper() {
    }

    public static List<Brand> fromList(List<Map<String, AttributeValue>> items) {
        return items.stream()
            .map(BrandMapper::fromMap)
            .collect(Collectors.toList());
    }

    public static Brand fromMap(Map<String, AttributeValue> attributeValueMap) {
        Brand brand = new Brand();
        brand.setId(UUID.fromString(attributeValueMap.get("id").s()));
        brand.setName(attributeValueMap.get("name").s());
        brand.setLogoImage(attributeValueMap.get("logoImage").s());
        brand.setIsShow(attributeValueMap.get("isShow").bool());
        brand.setCreatedDate(LocalDateTime.parse(attributeValueMap.get("createdDate").s()));
        brand.setUpdatedDate(LocalDateTime.parse(attributeValueMap.get("updatedDate").s()));
        return brand;
    }

    public static Map<String, AttributeValue> toMap(Brand brand) {
        return Map.of(
            "id", AttributeValue.builder().s(brand.getId().toString()).build(),
            "name", AttributeValue.builder().s(brand.getName()).build(),
            "logoImage", AttributeValue.builder().s(brand.getLogoImage()).build(),
            "isShow", AttributeValue.builder().bool(brand.getIsShow()).build(),
            "createdDate", AttributeValue.builder().s(brand.getCreatedDate().toString()).build(),
            "updatedDate", AttributeValue.builder().s(brand.getUpdatedDate().toString()).build()
        );
    }
}
