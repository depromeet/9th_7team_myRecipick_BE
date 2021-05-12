package com.myrecipick.core.domain.user;

import java.util.Map;
import java.util.UUID;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class UserMapper {
    private UserMapper() {

    }

    public static User fromMap(Map<String, AttributeValue> attributeValueMap) {
        User user = new User();
        user.setId(UUID.fromString(attributeValueMap.get("id").s()));
        return user;
    }

    public static Map<String, AttributeValue> toMap(User user) {
        return Map.of(
            "id", AttributeValue.builder().s(user.getId().toString()).build()
        );
    }
}
