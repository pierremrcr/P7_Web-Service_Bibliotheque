package com.bibliotheque.repository.client;

import livres.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class EmpruntClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(EmpruntClient.class);


    public GetEmpruntByIdResponse getEmpruntById(int id) {
        GetEmpruntByIdRequest request = new GetEmpruntByIdRequest();
        request.setId(id);

        log.info("Requesting Livre By id= " + id);
        return (GetEmpruntByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }


    public GetAllEmpruntResponse getAllEmprunts() {

        GetAllEmpruntRequest request = new GetAllEmpruntRequest();
        return (GetAllEmpruntResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public GetAllEmpruntsWhereDateFinIsBeforeDateTodayResponse getAllEmpruntsWhereDateFinIsBeforeDateToday() {

        GetAllEmpruntsWhereDateFinIsBeforeDateTodayRequest request = new GetAllEmpruntsWhereDateFinIsBeforeDateTodayRequest();
        return (GetAllEmpruntsWhereDateFinIsBeforeDateTodayResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }


    public UpdateEmpruntResponse updateEmprunt(EmpruntType empruntType) {
        UpdateEmpruntRequest request = new UpdateEmpruntRequest();
        request.setEmpruntType(empruntType);
        return (UpdateEmpruntResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public UpdateRelanceEmpruntResponse updateRelanceEmprunt(EmpruntType empruntType) {
        UpdateRelanceEmpruntRequest request = new UpdateRelanceEmpruntRequest();
        request.setEmpruntType(empruntType);
        return (UpdateRelanceEmpruntResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }


    public AddEmpruntResponse addEmprunt(EmpruntType empruntType) {
        AddEmpruntRequest request = new AddEmpruntRequest();
        request.setEmpruntType(empruntType);
        return (AddEmpruntResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }


    public UpdateEmpruntTermineResponse updateEmpruntTermine(EmpruntType empruntType) {
        UpdateEmpruntTermineRequest request = new UpdateEmpruntTermineRequest();
        request.setEmpruntType(empruntType);
        return (UpdateEmpruntTermineResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
