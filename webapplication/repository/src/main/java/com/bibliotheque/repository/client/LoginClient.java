package com.bibliotheque.repository.client;

import livres.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;

public class LoginClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(LoginClient.class);

    public LoginResponse loginCompte(String mail, String motDePasse) {

        LoginResponse response = new LoginResponse();

        try {

            LoginRequest request = new LoginRequest();
            request.setAdresseMail(mail);
            request.setMotDePasse(motDePasse);

            response = (LoginResponse) getWebServiceTemplate().marshalSendAndReceive(request);


        } catch (SoapFaultClientException pEX) {
            ServiceStatus serviceStatus = new ServiceStatus();
            serviceStatus.setStatusCode("CONFLICT");
            response.setServiceStatus(serviceStatus);
        }


        return response;
    }


    public GetCompteAfterLoginSuccessResponse getCompteAferLoginSuccess(String mail) {

        GetCompteAfterLoginSuccessResponse response = new GetCompteAfterLoginSuccessResponse();

        try {
            GetCompteAfterLoginSuccessRequest request = new GetCompteAfterLoginSuccessRequest();
            request.setAdresseMail(mail);
            response = (GetCompteAfterLoginSuccessResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        } catch (SoapFaultClientException pEX) {
            logger.error("GetCompteAfterLoginSuccessResponse : {}");
        }

        return response;
    }
}
