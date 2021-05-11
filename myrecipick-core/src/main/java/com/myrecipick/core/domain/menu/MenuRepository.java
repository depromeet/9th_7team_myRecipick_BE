package com.myrecipick.core.domain.menu;

import com.myrecipick.core.domain.brand.Brand;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ComparisonOperator;
import software.amazon.awssdk.services.dynamodb.model.Condition;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

@Repository
public class MenuRepository {

    private static final String MENUS_TABLE = "menus";

    private final DynamoDbAsyncClient dynamoDbAsyncClient;

    public MenuRepository(DynamoDbAsyncClient dynamoDbAsyncClient) {
        this.dynamoDbAsyncClient = dynamoDbAsyncClient;
    }

    public Flux<Menu> findAllByBrandId(UUID brandId) {
        Map<String, Condition> filter = Map.of(
            "isShow", Condition.builder()
                    .comparisonOperator(ComparisonOperator.EQ)
                    .attributeValueList(AttributeValue.builder()
                        .bool(true)
                        .build())
                    .build(),
            "brandId", Condition.builder()
                    .comparisonOperator(ComparisonOperator.EQ)
                    .attributeValueList(AttributeValue.builder()
                        .s(brandId.toString())
                        .build())
                    .build());


        ScanRequest scanRequest = ScanRequest.builder()
            .tableName(MENUS_TABLE)
            .scanFilter(filter)
            .build();

        return Mono.fromCompletionStage(dynamoDbAsyncClient.scan(scanRequest))
            .map(ScanResponse::items)
            .map(MenuMapper::fromList)
            .flatMapMany(Flux::fromIterable);
    }

    public Mono<Menu> findByMenuId(UUID menuId) {
        GetItemRequest getItemRequest = GetItemRequest.builder()
            .tableName(MENUS_TABLE)
            .key(Map.of("id", AttributeValue.builder().s(menuId.toString()).build()))
            .build();

        return Mono.fromCompletionStage(dynamoDbAsyncClient.getItem(getItemRequest))
            .map(GetItemResponse::item)
            .map(MenuMapper::fromMap);
    }
}