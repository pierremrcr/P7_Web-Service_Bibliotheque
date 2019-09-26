package com.bibliotheque;

import livres.wsdl.GetLivreByIdRequest;
import livres.wsdl.GetLivreByIdResponse;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;



public class LivreClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(LivreClient.class);

    public GetLivreByIdResponse getLivreById(int id){
        GetLivreByIdRequest request = new GetLivreByIdRequest();
        request.setId(id);

        log.info("Requesting Movie By id= " + id);
        return(GetLivreByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }


}
