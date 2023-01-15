package com.r2dsolution.comein.centaurs.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.r2dsolution.comein.centaurs.util.SecretManagerUtils;


@Configuration
@PropertySource("classpath:aws.properties")
public class AppAWSConfig {
	
	@Value( "${comein.mode}" )
	public String mode;
	
	@Value( "${accessKey}" )
	public String accessKey;
	
	@Value( "${secretKey}" )
	public String secretKey;
	
	
	@Value( "${region}" )
	public String region;
	
	public void withAccessKey(String key) {
		this.accessKey=key;
	}
	
	public void withSecretKey(String key) {
		this.secretKey=key;
	}
	public void withMode(String m) {
		this.mode=m;
	}
	
	
    @Bean
    public AmazonSQSClientBuilder intAmazonSQSClientBuilder(AWSSecretsManager secretManager) {
    	Map<String,String> awsSecrets = SecretManagerUtils.getSecret(secretManager, mode+"/sqs/comein");
    	String accessKey = awsSecrets.get("accessKey");
		String secretKey = awsSecrets.get("secretKey");
		
		
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey,secretKey);
    	
    	return  AmazonSQSClientBuilder.standard()
		          .withCredentials(new AWSStaticCredentialsProvider(awsCreds)) ;
    }
	
	@Bean
    public AWSCognitoIdentityProviderClientBuilder initAWSCognitoIdentityProviderClientBuilder(AWSSecretsManager secretManager) {
    	Map<String,String> awsSecrets = SecretManagerUtils.getSecret(secretManager, mode+"/cognito/comein");
    	String _accessKey = awsSecrets.get("accessKey");
    	String _secretKey = awsSecrets.get("secretKey");
    	//String _region = awsSecrets.get("region");
    	BasicAWSCredentials awsCreds = new BasicAWSCredentials(_accessKey,_secretKey);
    	return AWSCognitoIdentityProviderClientBuilder.standard()
    			.withCredentials(new AWSStaticCredentialsProvider(awsCreds));
//    			.withRegion(RegionsUtils.initRegions(region));
//				.withCredentials(new ClasspathPropertiesFileCredentialsProvider("aws.properties"));
//				 .withRegion(region);
    }
	
	 @Bean
	    public AWSCredentialsProvider initCredentialsProvider() {
	    	
	    	BasicAWSCredentials awsCreds = new BasicAWSCredentials(accessKey,secretKey);
	    	
	    	
	    	return new AWSStaticCredentialsProvider(awsCreds);
	    }

	    
	    @Bean 
	    public AWSSecretsManager initAWSSecretsManager() {
	    	Regions region = Regions.AP_SOUTHEAST_1;
	    	 AWSSecretsManager client  = AWSSecretsManagerClientBuilder.standard()
						.withCredentials(initCredentialsProvider()) 
	                 .withRegion(region)
	                 .build();
	    	 return client;
	    }

}
