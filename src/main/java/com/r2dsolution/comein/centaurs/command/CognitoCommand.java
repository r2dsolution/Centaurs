package com.r2dsolution.comein.centaurs.command;

import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.UserType;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.r2dsolution.comein.centaurs.client.CognitoClient;
import com.r2dsolution.comein.centaurs.config.AppAWSConfig;

public class CognitoCommand {

	public static void main(String[] args) {
		
		AppAWSConfig config = new AppAWSConfig();
		config.withAccessKey("AKIARKRCXVNEIJRAB62J");
		config.withSecretKey("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");
		config.withMode("dev");
		AWSSecretsManager sc = config.initAWSSecretsManager();
		
		
		AWSCognitoIdentityProviderClientBuilder builder = config.initAWSCognitoIdentityProviderClientBuilder(sc);
		// TODO Auto-generated method stub
		CognitoClient client = new CognitoClient();
		client.withRegion("ap-southeast-1");
		client.withUserPoolId("ap-southeast-1_uIzEe8OBV");
		client.withCognitoClientBuilder(builder);
		UserType user =client.findByEmail("tawatchai@r2dsolution.com");
		System.out.println("email="+user.getUsername());
	}

	private static AWSCognitoIdentityProviderClientBuilder initBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

}
