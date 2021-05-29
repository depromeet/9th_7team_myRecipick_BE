package com.myrecipick.core.domain.help;

import java.util.Map;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class RequestBrandMapper {

    public static Map<String, AttributeValue> toMap(RequestBrand requestBrand) {
        return Map.of(
            "id", AttributeValue.builder().s(requestBrand.getId().toString()).build(),
            "userId", AttributeValue.builder().s(requestBrand.getUserId().toString()).build(),
            "requestBrand", AttributeValue.builder().s(requestBrand.getRequestBrand()).build(),
            "createdDate", AttributeValue.builder().s(requestBrand.getCreatedDate().toString()).build()
        );
    }
}
