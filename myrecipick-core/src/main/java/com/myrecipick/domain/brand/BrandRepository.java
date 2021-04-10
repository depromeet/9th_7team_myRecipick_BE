package com.myrecipick.domain.brand;

import java.util.Map;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ComparisonOperator;
import software.amazon.awssdk.services.dynamodb.model.Condition;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

@Repository
public class BrandRepository {
    private final DynamoDbAsyncClient dynamoDbAsyncClient;

    public BrandRepository(DynamoDbAsyncClient dynamoDbAsyncClient) {
        this.dynamoDbAsyncClient = dynamoDbAsyncClient;
    }

    public Flux<Brand> findAll() {
        ScanRequest scanRequest = ScanRequest.builder()
            .tableName("brand")
            .scanFilter(Map.of("view", Condition.builder()
                .comparisonOperator(ComparisonOperator.EQ)
                .attributeValueList(AttributeValue.builder()
                    .bool(true)
                    .build())
                .build()))
            .build();

        return Mono.fromCompletionStage(dynamoDbAsyncClient.scan(scanRequest))
            .map(ScanResponse::items)
            .map(BrandMapper::fromList)
            .flatMapMany(Flux::fromIterable);
    }
}