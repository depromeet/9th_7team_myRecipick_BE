package com.myrecipick.core.domain.help;

import java.util.UUID;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

@Repository
public class RequestBrandRepository {

    private static final String REQUEST_BRAND_TABLE = "request_brands";
    private final DynamoDbAsyncClient dynamoDbAsyncClient;

    public RequestBrandRepository(DynamoDbAsyncClient dynamoDbAsyncClient) {
        this.dynamoDbAsyncClient = dynamoDbAsyncClient;
    }

    public Mono<UUID> save(RequestBrand requestBrand) {
        PutItemRequest putItemRequest = PutItemRequest.builder()
            .tableName(REQUEST_BRAND_TABLE)
            .item(RequestBrandMapper.toMap(requestBrand))
            .build();

        return Mono.fromCompletionStage(dynamoDbAsyncClient.putItem(putItemRequest))
            .map(PutItemResponse::attributes)
            .map(attributeValueMap -> requestBrand.getId());
    }
}
