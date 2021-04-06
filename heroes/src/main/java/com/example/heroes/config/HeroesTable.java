package com.example.heroes.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SpringUtils;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.exaple.heroes.constans.HeroesConstant.REGION_DYNAMO;
import static com.exaple.heroes.constans.HeroesConstant.ENDPOINT_DYNAMO;

@Configuration
@EnableDynamoDBRepositories
public class HeroesTable {
    public static void main(String []args) throws Exception{
        AmazonDynamoDb client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClienteBuilder.EndpointConfiguration())
                .build();
        DynamoDB dynamoDB=new DynamoDB(client);
        String tableName="Heroes_Table";
        try{
            Table table = dynamoDB.createTable(tableName,
                    Arrays.asList(new KeySchemaElement("id",KeyType.HASH)),
                    Arrays.asList(new AttributeDefinition("id"),ScalarAttributeType.S)),
                    new ProvisionedThroughput(5L,5l));
table.waitForActive();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}