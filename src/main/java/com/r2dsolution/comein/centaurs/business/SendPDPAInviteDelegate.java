package com.r2dsolution.comein.centaurs.business;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.cognitoidp.model.UserType;
import com.amazonaws.services.sqs.AmazonSQS;
import com.r2dsolution.comein.centaurs.client.SimpleQueueServiceClient;
import com.r2dsolution.comein.centaurs.entity.PDPAInviteTokenM;
import com.r2dsolution.comein.centaurs.function.EmailRequest;
import com.r2dsolution.comein.centaurs.repository.PDPAInviteTokenRepository;



@Component
public class SendPDPAInviteDelegate extends BusinessDelegate{
	
//	@Autowired
//	private AdminCognitoClient cognitoClient;
	
	@Autowired
	private PDPAInviteTokenRepository tokenRepository;
	
	@Autowired
	private SimpleQueueServiceClient client;

	public void invitePDPA(String emailTo,String comeinId,String secret) {
		//PDPAInviteRequest req = bodyToModel(message,context);
		//String email=req.getCognito_email();
//		String target_email = "";
//		String ref_name = "";
		String tokenStr = UUID.randomUUID().toString();
		log("email: "+emailTo);
		if (emailTo!=null && !emailTo.trim().isEmpty()) {
			log("find cognito by email: "+emailTo);
			//UserType user = cognitoClient.findByEmail(email);
			
			//String comeinId = cognitoClient.getAttr(user, cognitoClient.ATTRIBUTE_COMEIN_ID);
			//String secretCode = cognitoClient.getAttr(user, cognitoClient.ATTRIBUTE_COMEIN_CARD_ID);
			//ref_name = cognitoClient.getAttr(user, cognitoClient.ATTRIBUTE_REF_NAME);
			//target_email = user.getUsername();
		
			Optional<PDPAInviteTokenM> opt = tokenRepository.findByComeinIdAndStatus(comeinId,PDPAInviteTokenM.STATUS_ACTIVE);
			if (opt.isPresent()) {
				PDPAInviteTokenM activeToken = opt.get();
				activeToken.setStatus(PDPAInviteTokenM.STATUS_EXPIRED);
				tokenRepository.save(activeToken);
			}
			
			PDPAInviteTokenM token = new PDPAInviteTokenM();
			token.setComeinId(comeinId);
			token.setMaxUsed(5);
			token.setSecretCode(secret);
			token.setToken(tokenStr);
			token.setStatus(PDPAInviteTokenM.STATUS_ACTIVE);
			
			Calendar cal = Calendar.getInstance(Locale.ENGLISH);	
			cal.add(Calendar.DATE, 30);
			Date d = cal.getTime();
			token.setExpireDate(new Timestamp(d.getTime()));
			
			tokenRepository.save(token);
			
			EmailRequest req = tokenToEmailRequest(emailTo,token);
			//client.sendMessage(req);
			AmazonSQS sqsClient = client.initClient();
			String url = client.urlSendEmail(sqsClient);
			client.send(sqsClient, url, req);
			
		};
	}

	private EmailRequest tokenToEmailRequest(String email,PDPAInviteTokenM token) {
		EmailRequest req = new EmailRequest();
		req.setEmail(email);
		req.getParams().put("ref_name", token.getComeinId());	
		req.getParams().put("token", token.getSecretCode());	
		return req;
	}
}
