package com.r2dsolution.comein.centaurs.client;

import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.AdminCreateUserRequest;
import com.amazonaws.services.cognitoidp.model.AdminCreateUserResult;
import com.amazonaws.services.cognitoidp.model.AttributeType;
import com.amazonaws.services.cognitoidp.model.ListUsersRequest;
import com.amazonaws.services.cognitoidp.model.ListUsersResult;
import com.amazonaws.services.cognitoidp.model.MessageActionType;
import com.amazonaws.services.cognitoidp.model.UserType;
import com.r2dsolution.comein.centaurs.function.CognitoUser;


@Service
public class CognitoClient {
	
	@Value( "${comein.cognito.userPoolId}" )
	private String userPoolId;
	
	@Value( "${comein.cognito.region}" )
	private String region;
	
//	@Autowired
//	private AWSCredentialsProvider awsCredentialsProvider;
	
	@Autowired
	private AWSCognitoIdentityProviderClientBuilder cognitoClientBuilder;
	
	public static  String ATTRIBUTE_COMEIN_ID = "custom:comein_id";
	public static  String ATTRIBUTE_COMEIN_TITLE = "custom:title";
	public static  String ATTRIBUTE_COMEIN_CARD_ID = "custom:card_id";
	public static  String ATTRIBUTE_COMEIN_CARD_TYPE = "custom:card_type";
	public static  String ATTRIBUTE_COMEIN_CARD_EXPIRE_DATE= "custom:card_expire_date";
	public static  String ATTRIBUTE_REF_NAME = "name";
	public static  String ATTRIBUTE_EMAIL = "email";
	public static  String ATTRIBUTE_GIVEN_NAME = "given_name";
	public static  String ATTRIBUTE_FAMILY_NAME = "family_name";
	public static  String ATTRIBUTE_BIRTHDATE = "birthdate";
	public static  String ATTRIBUTE_PREFERRED_USERNAME = "preferred_username";
	public static  String ATTRIBUTE_USERNAME = "username";

//	protected AWSCognitoIdentityProvider buildProvider() {
//		AWSCognitoIdentityProvider cognitoClient = cognitoClientBuilder.withCredentials(awsCredentialsProvider)
//				 .withRegion(region)
//				 .build();
//		return cognitoClient;
//	}
	
	public  UserType findByEmail( String email) {

        try {
        	Regions cognitoRegion = Regions.fromName(region);
        	AWSCognitoIdentityProvider cognitoClient = cognitoClientBuilder.withRegion(cognitoRegion).build();
        	
        	//AWSCognitoIdentityProvider cognitoClient = cognitoClientBuilder.build();
            // List all users
        	System.out.println("userPoolId="+userPoolId);
            ListUsersRequest usersRequest = new ListUsersRequest();
        	usersRequest.withUserPoolId(userPoolId);
        	usersRequest.withFilter( "email = \""+email.trim()+"\"");
                   
        	ListUsersResult results = cognitoClient.listUsers(usersRequest);
        	

            //ListUsersResponse response = cognitoClient.listUsers(usersRequest);
//        	results.getUsers().forEach(user -> {
//                        System.out.println("User " + user.getUsername()  + " attr-name " + user.getAttributes().get(2).getName()+  " attr-value "+user.getAttributes().get(2).getValue());
//                       
//                    }
//            );
        	
        	Optional<UserType> opt = results.getUsers().stream().findFirst();
        	if (opt.isPresent()) {
        		return opt.get();
        	}
        	return null;

        } catch (Exception e){
            System.err.println(e.getMessage());
           throw e;
        }
    }
	
	protected AttributeType newAttributeType(String name,String value) {
		AttributeType attr = new AttributeType();
		attr.setName(name);
		attr.setValue(value);
		return attr;
	}
	
	public String getAttr(UserType user,String name) {
		Optional<AttributeType> opt =	user.getAttributes().stream().filter(attr-> attr.getName().equals(name)).findFirst();
		if (opt.isPresent()) {
			return opt.get().getValue();
		}
		return null;
	}
	
	protected boolean isEmpty(String str) {
		if (str==null) {
			return true;
		} else if (str.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public UserType addUser(CognitoUser user) {
		 try {
			 
			 Regions cognitoRegion = Regions.fromName(region);
			 	String title = user.getTitle();
			 	String firstname = user.getFirstname();
			 	String lastname = user.getLastname();
			 	String ref_name = user.getRefName();
			 	String email = user.getEmail();
			 	String cardId = user.getCardId();
			 	String cardType = user.getCardType();
			 	String cardExpireDate = user.getCardExpireDate();
			 	String username = user.getUsername();
			 	
			 	String birthDate = user.getBirthDate();
			 	System.out.println("title: "+title);
			 	
			 	AWSCognitoIdentityProvider cognitoClient = cognitoClientBuilder.withRegion(cognitoRegion).build();
			 
			 	AdminCreateUserRequest req = new AdminCreateUserRequest();
			 	req.withUserPoolId(userPoolId);
			 	req.withUsername(username);
			 	req.withDesiredDeliveryMediums(new HashSet<String>());
			 	req.withMessageAction(MessageActionType.SUPPRESS);
			 	req.withUserAttributes(newAttributeType(ATTRIBUTE_EMAIL,email));
			 	req.withUserAttributes(newAttributeType(ATTRIBUTE_COMEIN_ID,"KYC-"+UUID.randomUUID().toString()));
			 	if (!isEmpty(title)) {
			 		req.withUserAttributes(newAttributeType(ATTRIBUTE_COMEIN_TITLE,title.trim()));
			 	};
			 	if (!isEmpty(firstname)) {
			 		req.withUserAttributes(newAttributeType(ATTRIBUTE_GIVEN_NAME,firstname.trim()));
			 	};
			 	if (!isEmpty(lastname)) {
			 		req.withUserAttributes(newAttributeType(ATTRIBUTE_FAMILY_NAME,lastname.trim()));
			 	};
			 	if (isEmpty(ref_name)) {
			 		ref_name = firstname+" "+lastname;
			 	};
			 	if (!isEmpty(ref_name)) {
			 		req.withUserAttributes(newAttributeType(ATTRIBUTE_REF_NAME,ref_name.trim()));
			 	};
			 	if (!isEmpty(birthDate)) {
			 		req.withUserAttributes(newAttributeType(ATTRIBUTE_BIRTHDATE,birthDate.trim()));
			 	};
			 	if (!isEmpty(cardId)) {
			 		req.withUserAttributes(newAttributeType(ATTRIBUTE_COMEIN_CARD_ID,cardId.trim()));
			 	};
			 	if (!isEmpty(cardType)) {
			 		req.withUserAttributes(newAttributeType(ATTRIBUTE_COMEIN_CARD_TYPE,cardType.trim()));
			 	};
			 	if (!isEmpty(cardExpireDate)) {
			 		req.withUserAttributes(newAttributeType(ATTRIBUTE_COMEIN_CARD_EXPIRE_DATE,cardExpireDate.trim()));
			 	};
	        	AdminCreateUserResult result = cognitoClient.adminCreateUser(req);
	        	return result.getUser();
			
		 } catch(Exception e) {
			 System.err.println(e.getMessage());
	         throw e;
		 }
	}
	public void withRegion(String region) {
		this.region=region;
	}
	public void withUserPoolId(String id) {
		this.userPoolId = id;
	}
	
	public void withCognitoClientBuilder(AWSCognitoIdentityProviderClientBuilder builder) {
		this.cognitoClientBuilder = builder;
	}
}