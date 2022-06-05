package config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoDBConfig {

    public static DynamoDBMapper dynamoDBMapper(){

        return  new DynamoDBMapper(amazonDynamoDB());
    }

    public static AmazonDynamoDB amazonDynamoDB(){


        return AmazonDynamoDBClient.builder()
                .withCredentials(awsCredentials())
                .withRegion(Regions.US_EAST_1)
                .build();


    }

    public static AWSCredentialsProvider awsCredentials(){
        String accessKey = System.getenv("AWS_ACCESS_KEY_ID");
        String secretKey = System.getenv("AWS_SECRET_ACCESS_KEY");

        AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey,secretKey);
        return new AWSStaticCredentialsProvider(awsCredentials);
    }
}
