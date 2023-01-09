package com.r2dsolution.comein.centaurs.function;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;


public interface IFunction {

	ComeInAPIResponse execute(ComeInAPIRequest request) throws Exception;
}
