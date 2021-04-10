package com.myrecipick.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

@Configuration
public class DynamoDBConfig {

    @Value("${aws.account.access-key-id}")
    private String accessKeyId;

    @Value("${aws.account.secret-access-key}")
    private String secretAccessKey;

    @Bean
    public DynamoDbAsyncClient dynamoDbClient() {
        AwsBasicCredentials awsBasicCredentials = AwsBasicCredentials.create(
            accessKeyId,
            secretAccessKey);

        return DynamoDbAsyncClient.builder()
            .region(Region.AP_NORTHEAST_2)
            .credentialsProvider(StaticCredentialsProvider.create(awsBasicCredentials))
            .build();
    }


}
