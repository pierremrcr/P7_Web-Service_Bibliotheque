package com.bibliotheque.repository.client;

import livres.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ExemplaireClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(ExemplaireClient.class);

    public GetExemplaireByIdResponse getExemplaireById(int id) {
        GetExemplaireByIdRequest request = new GetExemplaireByIdRequest();
        request.setId(id);

        log.info("Requesting Exemplaire By id= " + id);
        return (GetExemplaireByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public GetAllExemplairesResponse getAllExemplaires() {
        GetAllExemplairesRequest request = new GetAllExemplairesRequest();
        return (GetAllExemplairesResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public GetAllExemplairesAndEmpruntsResponse getAllExemplairesAndEmprunts() {
        GetAllExemplairesAndEmpruntsRequest request = new GetAllExemplairesAndEmpruntsRequest();
        return (GetAllExemplairesAndEmpruntsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

}