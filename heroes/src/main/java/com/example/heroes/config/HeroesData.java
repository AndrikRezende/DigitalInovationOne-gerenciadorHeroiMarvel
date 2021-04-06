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
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import static com.exaple.heroes.constans.HeroesConstant.REGION_DYNAMO;
import static com.exaple.heroes.constans.HeroesConstant.ENDPOINT_DYNAMO;

public class HeroesData {
    public static void main (String [] args) throws Exception{
        AmazonDynamoDB cliente = AmazonDynamoDBClientBuilder.standard()
                .whithEndpointConfiguration(new AwsClienteBuilder.EndpointConfiguration(ENDPOINT_DYNAMO))
                .build();
        DynamoDB dynamoDB= new DynamoDB(cliente);
        Table table= dynamoDB.getTable("Heroes_Table_Demo");
        Item hero= new Item()
                .withPrimaryKey("id",2)
                .withString("name","Mulher Maravilha")
                .withString("universe","dc comics")
                .withNumber("films",3);
        PutItemOutcome outcome=table.putItem(hero);
        Item hero2= new Item()
                .withPrimaryKey("id",3)
                .withString("name","Viuva negra")
                .withString("universe","dc comics")
                .withNumber("films",3);
        PutItemOutcome outcome=table.putItem(hero2);
        Item hero3= new Item()
                .withPrimaryKey("id",4)
                .withString("name","Capita marvel")
                .withString("universe","dc comics")
                .withNumber("films",3);
        PutItemOutcome outcome=table.putItem(hero3);
    }
}