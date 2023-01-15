package com.r2dsolution.comein.centaurs.function.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.r2dsolution.comein.centaurs.client.CognitoClient;
import com.r2dsolution.comein.centaurs.entity.UserKYCInfoM;
import com.r2dsolution.comein.centaurs.function.ComeInFunction;
import com.r2dsolution.comein.centaurs.function.CognitoUser;
import com.r2dsolution.comein.centaurs.function.ComeInAPIRequest;
import com.r2dsolution.comein.centaurs.function.ComeInAPIResponse;
import com.r2dsolution.comein.centaurs.repository.UserKYCRepository;

import com.amazonaws.services.cognitoidp.model.UserType;

@Component
public class AddKYCInfoFunc   extends ComeInFunction{
	
	@Autowired
	UserKYCRepository kycRepo;
	
	@Autowired
	CognitoClient client;

	@Override
	public ComeInAPIResponse doExecute(ComeInAPIRequest request) throws Exception {
		//String profile_email = input.getProfile().getEmail();
		Map<String,Object> output = new HashMap<String,Object>();
		Map<String,Object> input = request.getJsonBody();
				String ownerId = request.getProfile().getComeinId();
				String email = (String) input.get("email");
				String title = (String) input.get("title");
//				String language = (String) input.getBody().get("language");
				String firstname = (String) input.get("firstname");
				String lastname = (String) input.get("lastname");
				String name = (String) input.get("name");
				String birthdate = (String) input.get("birthdate");
				String cardId = (String) input.get("card-id");
				String cardType = (String) input.get("card-type");
				String cardExpireDate = (String) input.get("card-expire-date");
				String displayName = (String) input.get("display-name");
//				String refImage = (String) input.getBody().get("ref-image");
//				String signImage = (String) input.getBody().get("sign-image");
				
//				log("email="+email+", ref-type="+refType+", owner="+ownerId);
				log("email="+email);
//				UserKYCRepository kycRepo = ctx.getBean(UserKYCRepository.class);
//				AdminCognitoClient client = ctx.getBean(AdminCognitoClient.class);
				
				UserType u = client.findByEmail(email);
				if (u!=null) {
					log("username: "+u.getUsername());
				}
//				if (cognitoUser==null) {
//					log("not-found user by email: "+email);
					CognitoUser	dataUser = new CognitoUser();
					dataUser.setUsername(UUID.randomUUID().toString()+"@thecomein.com");
					dataUser.setEmail(email);
					dataUser.setTitle(title);
					dataUser.setFirstname(firstname);
					dataUser.setLastname(lastname);
					dataUser.setRefName(name);
					dataUser.setCardId(cardId);
					dataUser.setCardType(cardType);
					dataUser.setBirthDate(birthdate);
					dataUser.setCardExpireDate(cardExpireDate);
					UserType cognitoUser  = client.addUser(dataUser);
			//	}
				
				//UserType 
//				String refId = "";
//				if (refType!=null && refType.equals(UserKYCInfoM.COMEIN_ID_REF)) {
//					refId = client.getAttr(cognitoUser, AdminCognitoClient.ATTRIBUTE_COMEIN_ID);
//				} else if (refType!=null && refType.equals(UserKYCInfoM.EMAIL_REF)) {
//					refId = email;
//				} else if (refType!=null && refType.equals(UserKYCInfoM.NATIONAL_CARD_REF)) {
//					refId = cardId;
//				}
//				log("card-id: "+refId);
//				String refId = client.getAttr(cognitoUser, AdminCognitoClient.ATTRIBUTE_COMEIN_ID);
				String refId = cognitoUser.getUsername();
				log("ref-id: "+refId);
				//UserKYCInfoM user = kycRepo.findByEmailAndProfile(email, profile_email);
				UserKYCInfoM user = null;//kycRepo.findByRefIdAndRefTypeAndOwnerId(refId, refType, ownerId);
				if (user==null) {
					user = new UserKYCInfoM();
					//user.setProfile(profile_email);
					user.setOwnerId(ownerId);
					user.setRefId(refId);
					user.setRefType(UserKYCInfoM.COMEIN_ID_REF);
					user.setRefName(displayName);
					user = kycRepo.save(user);
					log("save-user id:"+user.getId());
				}
//				String titleCode = "";
//				TitleRepository titleRepo = ctx.getBean(TitleRepository.class);
//				if (language!=null && language.trim().equals(Language.TH)) {
//					Optional<TitleM> opt = titleRepo.findByNameTh(title);
//					if (opt.isPresent()) {
//						titleCode = opt.get().getCode();
//					}
//				} else {
//					Optional<TitleM> opt = titleRepo.findByNameEn(title);
//					if (opt.isPresent()) {
//						titleCode = opt.get().getCode();
//					}
//				}
//				
//				//user.setEmail(email);
//				user.setTitle(titleCode);
//				user.setFirstname(firstname);
//				user.setLastname(lastname);
//				user.setLanguage(language);
//				user.setRefImage(refImage);
//				user.setSignImage(signImage);
//				
//				
//				
//				
//				kycRepo.save(user);
				
				log("add success");
				return toComeInResults(output);
	}

}
