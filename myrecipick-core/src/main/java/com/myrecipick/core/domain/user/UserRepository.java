package com.myrecipick.core.domain.user;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.PutItemResponse;

@Repository
public class UserRepository {
    private final DynamoDbAsyncClient dynamoDbAsyncClient;

    public UserRepository(DynamoDbAsyncClient dynamoDbAsyncClient) {
        this.dynamoDbAsyncClient = dynamoDbAsyncClient;
    }

    public Mono<User> save(User user) {
        PutItemRequest putItemRequest = PutItemRequest.builder()
            .tableName("user")
            .item(UserMapper.toMap(user))
            .build();

        return Mono.fromCompletionStage(dynamoDbAsyncClient.putItem(putItemRequest))
            .map(PutItemResponse::attributes)
            .map(attributeValueMap -> user);
    }

}
