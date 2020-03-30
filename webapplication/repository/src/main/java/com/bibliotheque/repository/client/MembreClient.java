package com.bibliotheque.repository.client;

import livres.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;


public class MembreClient extends WebServiceGatewaySupport {

        private static final Logger log = LoggerFactory.getLogger(LivreClient.class);

        public GetMembreByIdResponse getMembreById(int id){
            GetMembreByIdRequest request = new GetMembreByIdRequest();
            request.setId(id);

            log.info("Requesting Membre By id= " + id);
            return (GetMembreByIdResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        }

        public AddMembreResponse addMembre(MembreType membreType){

            AddMembreRequest request = new AddMembreRequest();
            request.setMembreType(membreType);
            return (AddMembreResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        }

        public GetAllMembresResponse getAllMembres(){

            GetAllMembresRequest request = new GetAllMembresRequest();
            return (GetAllMembresResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        }


        public UpdateMembreResponse updateMembre(MembreType membreType) {

            UpdateMembreRequest request = new UpdateMembreRequest();
            request.setMembreType(membreType);
            return (UpdateMembreResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        }

        public DeleteMembreResponse deleteMembreById(int id) {

            DeleteMembreRequest request = new DeleteMembreRequest();
            request.setId(id);
            return (DeleteMembreResponse) getWebServiceTemplate().marshalSendAndReceive(request);
        }
    }


