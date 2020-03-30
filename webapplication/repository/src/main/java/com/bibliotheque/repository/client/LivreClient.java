package com.bibliotheque.repository.client;

import livres.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class LivreClient extends WebServiceGatewaySupport{

    private static final Logger log = (Logger) LoggerFactory.getLogger(LivreClient.class);

    public GetLivreByIdResponse getLivreById(int id){
        GetLivreByIdRequest request = new GetLivreByIdRequest();
        request.setId(id);

        log.info("Requesting Livre By id= " + id);
        return(GetLivreByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public GetAllLivresResponse getAllLivres() {
        GetAllLivresRequest request = new GetAllLivresRequest();
        return (GetAllLivresResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }


    public GetAllLivresEmpruntesResponse getAllLivresEmpruntes(int id){
        GetAllLivresEmpruntesRequest request = new GetAllLivresEmpruntesRequest();
        request.setId(id);

        return(GetAllLivresEmpruntesResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}