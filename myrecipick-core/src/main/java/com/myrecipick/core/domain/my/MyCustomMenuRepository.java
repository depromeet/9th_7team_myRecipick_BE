package com.myrecipick.core.domain.my;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.BatchWriteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.ComparisonOperator;
import software.amazon.awssdk.services.dynamodb.model.Condition;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemRequest;
import software.amazon.awssdk.services.dynamodb.model.DeleteItemResponse;
import software.amazon.awssdk.services.dynamodb.model.DeleteRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;
import software.amazon.awssdk.services.dynamodb.model.WriteRequest;

@Repository
public class MyCustomMenuRepository {
    private static final String CUSTOM_MENU_TABLE = "custom_menu";
    private final DynamoDbAsyncClient dynamoDbAsyncClient;

    public MyCustomMenuRepository(DynamoDbAsyncClient dynamoDbAsyncClient) {
        this.dynamoDbAsyncClient = dynamoDbAsyncClient;
    }

    public Mono<MyCustomMenu> save(MyCustomMenu customMenu) {
        PutItemRequest putItemRequest = PutItemRequest.builder()
            .tableName(CUSTOM_MENU_TABLE)
            .item(MyCustomMenuMapper.toMap(customMenu))
            .build();

        return Mono.fromCompletionStage(dynamoDbAsyncClient.putItem(putItemRequest))
            .map(PutItemResponse::attributes)
            .map(attributeValueMap -> customMenu);
    }

    public Mono<MyCustomMenu> findById(UUID customMenuId) {
        GetItemRequest getItemRequest = GetItemRequest.builder()
            .tableName(CUSTOM_MENU_TABLE)
            .key(Map.of("id", AttributeValue.builder().s(customMenuId.toString()).build()))
            .build();

        return Mono.fromCompletionStage(dynamoDbAsyncClient.getItem(getItemRequest))
            .map(GetItemResponse::item)
            .map(MyCustomMenuMapper::fromMap);
    }

    public Flux<MyCustomMenu> findAllByUserId(UUID userId) {
        Map<String, Condition> filter = Map.of(
            "userId", Condition.builder()
                .comparisonOperator(ComparisonOperator.EQ)
                .attributeValueList(AttributeValue.builder()
                    .s(userId.toString())
                    .build())
                .build());

        ScanRequest scanRequest = ScanRequest.builder()
            .tableName(CUSTOM_MENU_TABLE)
            .scanFilter(filter)
            .build();

        return Mono.fromCompletionStage(dynamoDbAsyncClient.scan(scanRequest))
            .map(ScanResponse::items)
            .map(MyCustomMenuMapper::fromList)
            .flatMapMany(Flux::fromIterable);
    }

    public Mono<UUID> delete(UUID customMenuId) {
        DeleteItemRequest deleteItemRequest = DeleteItemRequest.builder()
            .tableName(CUSTOM_MENU_TABLE)
            .key(Map.of("id", AttributeValue.builder().s(customMenuId.toString()).build()))
            .build();

        return Mono.fromCompletionStage(dynamoDbAsyncClient.deleteItem(deleteItemRequest))
            .map(DeleteItemResponse::attributes)
            .map(attributeValueMap -> customMenuId);
    }

    public Mono<Boolean> deletes(List<UUID> customMenuIds) {
        HashMap<String, List<WriteRequest>> requestItems = new HashMap<>();
        List<WriteRequest> writeRequests = new ArrayList<>();

        for(UUID customMenuId : customMenuIds) {
            writeRequests.add(WriteRequest.builder()
                .deleteRequest(DeleteRequest.builder()
                    .key(Map.of("id", AttributeValue.builder().s(customMenuId.toString()).build()))
                    .build())
                .build());
        }
        requestItems.put(CUSTOM_MENU_TABLE, writeRequests);

        return Mono.fromCompletionStage(dynamoDbAsyncClient.batchWriteItem(BatchWriteItemRequest.builder().requestItems(requestItems).build()))
            .map(BatchWriteItemResponse::unprocessedItems)
            .map(Map::isEmpty);
    }
}
