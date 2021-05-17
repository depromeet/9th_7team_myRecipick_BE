package com.myrecipick.core.domain.customMenu;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Repository
public class CustomMenuRepository {
    private static final String CUSTOM_MENU_TABLE = "custom_menu";
    private final DynamoDbAsyncClient dynamoDbAsyncClient;

    public CustomMenuRepository(DynamoDbAsyncClient dynamoDbAsyncClient) {
        this.dynamoDbAsyncClient = dynamoDbAsyncClient;
    }

    public Mono<CustomMenu> save(CustomMenu customMenu) {
        PutItemRequest putItemRequest = PutItemRequest.builder()
            .tableName(CUSTOM_MENU_TABLE)
            .item(CustomMenuMapper.toMap(customMenu))
            .build();

        return Mono.fromCompletionStage(dynamoDbAsyncClient.putItem(putItemRequest))
            .map(PutItemResponse::attributes)
            .map(attributeValueMap -> customMenu);
    }

    public CustomMenu findById(UUID customMenuId) {
        GetItemRequest getItemRequest = GetItemRequest.builder()
            .tableName(CUSTOM_MENU_TABLE)
            .key(Map.of("id", AttributeValue.builder().s(customMenuId.toString()).build()))
            .build();

        CompletableFuture<GetItemResponse> item = dynamoDbAsyncClient.getItem(getItemRequest);

        try {
            return CustomMenuMapper.fromMap(item.get().item());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException();
        }
    }

}
