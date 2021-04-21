package com.myrecipick.core.domain.user;

import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbAsyncTable;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.concurrent.CompletableFuture;

@Repository
public class UserRepository {
    private final DynamoDbEnhancedAsyncClient enhancedAsyncClient;
    private final DynamoDbAsyncTable<User> userDynamoDbAsyncTable;

    public UserRepository(DynamoDbEnhancedAsyncClient asyncClient) {
        enhancedAsyncClient = asyncClient;
        userDynamoDbAsyncTable = enhancedAsyncClient.table("user", TableSchema.fromBean(User.class));
    }

    public CompletableFuture<Void> save(User user) {
        return userDynamoDbAsyncTable.putItem(user);
    }

}
