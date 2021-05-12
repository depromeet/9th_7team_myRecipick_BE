package com.myrecipick.core.domain.option;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ComparisonOperator;
import software.amazon.awssdk.services.dynamodb.model.Condition;
import software.amazon.awssdk.services.dynamodb.model.ScanRequest;
import software.amazon.awssdk.services.dynamodb.model.ScanResponse;

@Repository
public class MenuOptionGroupBlockRepository {

    public static final String MENU_OPTION_GROUPS_TABLE = "menu_option_groups";

    private final DynamoDbAsyncClient dynamoDbAsyncClient;

    public MenuOptionGroupBlockRepository(DynamoDbAsyncClient dynamoDbAsyncClient) {
        this.dynamoDbAsyncClient = dynamoDbAsyncClient;
    }

    public List<MenuOptionGroup> findByMenuId(UUID menuId) {
        ScanRequest menuOptionGroupRequest = ScanRequest.builder()
            .tableName(MENU_OPTION_GROUPS_TABLE)
            .scanFilter(Map.of("menuId", Condition.builder()
                .comparisonOperator(ComparisonOperator.EQ)
                .attributeValueList(AttributeValue.builder()
                    .s(menuId.toString())
                    .build())
                .build()))
            .build();

        CompletableFuture<ScanResponse> scan = dynamoDbAsyncClient.scan(menuOptionGroupRequest);

        try {
            return scan.get()
                .items()
                .stream()
                .map(MenuOptionGroupMapper::fromMap)
                .collect(Collectors.toList());

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException();
        }
    }
}
