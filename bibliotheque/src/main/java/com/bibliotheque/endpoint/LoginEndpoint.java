package com.bibliotheque.endpoint;

import com.bibliotheque.entity.MembreEntity;
import com.bibliotheque.gs_ws.*;
import com.bibliotheque.service.contract.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoginEndpoint {

    public static final String NAMESPACE_URI = "http://www.bibliotheque.com/livres-ws";

    private LoginService loginService;

    public LoginEndpoint() {
    }

    @Autowired
    public LoginEndpoint(LoginService loginService) {

        this.loginService = loginService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginRequest")
    @ResponsePayload
    public LoginResponse loginResponse(@RequestPayload LoginRequest request){
        LoginResponse response = new LoginResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        MembreType membreType = new MembreType();
        MembreEntity membreEntity = loginService.getMembreByEmailandAdresse(request.getAdresseMail(), request.getMotDePasse());

        try{

            if (membreEntity.getAdresseMail().equals(request.getAdresseMail()) && membreEntity.getMotDePasse().equals(request.getMotDePasse())){
                serviceStatus.setStatusCode("SUCCESS");
            }

        } catch (NullPointerException pEX){
            serviceStatus.setStatusCode("CONFLICT");
        }

        BeanUtils.copyProperties(membreEntity, membreType);
        response.setCompteType(membreType);
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCompteAfterLoginSuccessRequest")
    @ResponsePayload
    public GetCompteAfterLoginSuccessResponse getCompteAfterLoginSuccessResponse(@RequestPayload GetCompteAfterLoginSuccessRequest request){
        GetCompteAfterLoginSuccessResponse response = new GetCompteAfterLoginSuccessResponse();
        MembreType membreType = new MembreType();
        MembreEntity membreEntity = loginService.getMembrebyEmail(request.getAdresseMail());

        BeanUtils.copyProperties(membreEntity, membreType);
        response.setCompteType(membreType);
        return response;
    }
}

