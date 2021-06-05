package com.myrecipick.core.domain.home;

import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Repository;
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
public class RecommendCustomMenuRepository {

    private static final String RECOMMEND_CUSTOM_MENU_COLLECTION_TBALE = "recommend_custom_menu_collection";

    private final DynamoDbAsyncClient dynamoDbAsyncClient;

    public RecommendCustomMenuRepository(
        DynamoDbAsyncClient dynamoDbAsyncClient) {
        this.dynamoDbAsyncClient = dynamoDbAsyncClient;
    }

    public Mono<RecommendCustomMenuCollection> findOne() {
        Map<String, Condition> filter = Map.of(
            "isView", Condition.builder()
                .comparisonOperator(ComparisonOperator.EQ)
                .attributeValueList(AttributeValue.builder()
                    .bool(true)
                    .build())
                .build());

        ScanRequest scanRequest = ScanRequest.builder()
            .tableName(RECOMMEND_CUSTOM_MENU_COLLECTION_TBALE)
            .scanFilter(filter)
            .build();

        return Mono.fromCompletionStage(dynamoDbAsyncClient.scan(scanRequest))
            .map(ScanResponse::items)
            .map(items -> items.stream()
                .findFirst()
                .orElseThrow(NoSuchElementException::new))
            .map(RecommendCustomMenuMapper::fromMap);
    }

}
