package com.r2dsolution.comein.centaurs.function.cognito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.CognitoUserPoolPreSignUpEvent;
import com.r2dsolution.comein.centaurs.business.SendPDPAInviteDelegate;
import com.r2dsolution.comein.centaurs.client.CognitoClient;

@Component
public class SignUpPrePDPAInfoFunc {
	
	@Autowired
	SendPDPAInviteDelegate sendPDPAInviteDelegate;
	
	public CognitoUserPoolPreSignUpEvent execute(CognitoUserPoolPreSignUpEvent request) {
		log("Start SignUp PAPD........by event\n");
		log("username: "+request.getUserName());
		String username = request.getUserName();
		String cardId = request.getRequest().getUserAttributes().get(CognitoClient.ATTRIBUTE_COMEIN_CARD_ID);
		String email = request.getRequest().getUserAttributes().get(CognitoClient.ATTRIBUTE_EMAIL);
		String secret = cardId.substring(cardId.length()-6);
		
//		BusinessDelegateFactory factory = ctx.getBean(BusinessDelegateFactory.class);
//		SendPDPAInviteDelegate bd =	factory.initSendPDPAInviteDelegate(context);
		sendPDPAInviteDelegate.invitePDPA(email,username,secret);
		
		log("Finish SignUp PAPD........by event");
		return request;
		
	}
	
	protected void log(String s) {
		System.out.println(s);
	}

}
