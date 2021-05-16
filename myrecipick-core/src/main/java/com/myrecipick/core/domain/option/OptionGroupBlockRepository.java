package com.myrecipick.core.domain.option;

import java.util.Comparator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

@Repository
public class OptionGroupBlockRepository {
    private static final String OPTION_GROUPS_TABLE = "option_groups";

    private final DynamoDbAsyncClient dynamoDbAsyncClient;

    public OptionGroupBlockRepository(DynamoDbAsyncClient dynamoDbAsyncClient) {
        this.dynamoDbAsyncClient = dynamoDbAsyncClient;
    }

    public OptionGroup findById(UUID optionGroupId) {
        GetItemRequest getItemRequest = GetItemRequest.builder()
            .tableName(OPTION_GROUPS_TABLE)
            .key(Map.of("id", AttributeValue.builder().s(optionGroupId.toString()).build()))
            .build();

        CompletableFuture<GetItemResponse> item = dynamoDbAsyncClient.getItem(getItemRequest);

        try {
            return OptionGroupMapper.fromMap(item.get().item());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException();
        }
    }
}
