package com.myrecipick.domain.user;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;

import java.util.concurrent.CompletableFuture;

@Repository
public class UserRepository {
    private final DynamoDbEnhancedAsyncClient enhancedAsyncClient;
    private final DynamoDbAsyncTable<User> userDynamoDbAsyncTable;

    public UserRepository(DynamoDbEnhancedAsyncClient asyncClient) {
        this.enhancedAsyncClient = asyncClient;
        this.userDynamoDbAsyncTable = enhancedAsyncClient.table(User.class.getSimpleName(), TableSchema.fromBean(User.class));
    }

    public CompletableFuture<Void> save(User user) {
        return userDynamoDbAsyncTable.putItem(user);
    }

}
