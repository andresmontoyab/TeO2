package com.teo2.prediosservices.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsS3Config {

    private AWSCredentials setUpCredentials() {
        AWSCredentials credentials = new BasicAWSCredentials(
                "AKIAZMDM7GZIGIXPZLWB",
                "IDOUUpBeWtzKKIhRApRxIOyjb7QA46kZRC0RBCi9"
        );
        return credentials;
    }

    @Bean
    public AmazonS3 createConnection() {
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(setUpCredentials()))
                .withRegion(Regions.US_EAST_2)
                .build();
    }

}
