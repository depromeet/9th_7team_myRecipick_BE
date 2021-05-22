package com.myrecipick.core.domain.my;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ComparisonOperator;
import software.amazon.awssdk.services.dynamodb.model.Condition;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

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

    public MyCustomMenu findById(UUID customMenuId) {
        GetItemRequest getItemRequest = GetItemRequest.builder()
            .tableName(CUSTOM_MENU_TABLE)
            .key(Map.of("id", AttributeValue.builder().s(customMenuId.toString()).build()))
            .build();

        CompletableFuture<GetItemResponse> item = dynamoDbAsyncClient.getItem(getItemRequest);

        try {
            return MyCustomMenuMapper.fromMap(item.get().item());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException();
        }
    }

    public Flux<MyCustomMenu> findAllByUserId(UUID userId) {
        Map<String, Condition> filter = Map.of(
            "isShow", Condition.builder()
                .comparisonOperator(ComparisonOperator.EQ)
                .attributeValueList(AttributeValue.builder()
                    .bool(true)
                    .build())
                .build(),
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

}
