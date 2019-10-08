package com.bibliotheque.endpoint;

import com.bibliotheque.entity.MembreEntity;
import com.bibliotheque.gs_ws.*;
import com.bibliotheque.service.contract.MembreEntityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class MembreEndpoint {

    public static final String NAMESPACE_URI = "http://www.bibliotheque.com/livres-ws";

    private MembreEntityService membreEntityService;

    public MembreEndpoint(){

    }

    @Autowired
    public MembreEndpoint(MembreEntityService membreEntityService) {

        this.membreEntityService = membreEntityService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMembreByIdRequest")
    @ResponsePayload
    public GetMembreByIdResponse getMembreById(@RequestPayload GetMembreByIdRequest request)  {
        GetMembreByIdResponse response = new GetMembreByIdResponse();
        MembreEntity membreEntity = membreEntityService.getMembreById(request.getId());
        MembreType membreType = new MembreType();
        BeanUtils.copyProperties(membreEntity, membreType);
        response.setMembreType(membreType);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllMembresRequest")
    @ResponsePayload
    public GetAllMembresResponse getAllLivres(@RequestPayload GetAllMembresRequest request) {
        GetAllMembresResponse response = new GetAllMembresResponse();
        List<MembreType> membreTypeList = new ArrayList<MembreType>();
        List<MembreEntity> membreEntityList = membreEntityService.getAllMembres();
        for (MembreEntity entity : membreEntityList) {
            MembreType membreType = new MembreType();
            BeanUtils.copyProperties(entity, membreType);
            membreTypeList.add(membreType);
        }
        response.getMembreType().addAll(membreTypeList);

        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addMembreRequest")
    @ResponsePayload
    public AddMembreResponse addMembre(@RequestPayload AddMembreRequest request) {
        AddMembreResponse response = new AddMembreResponse();
        MembreType newMembreType = new MembreType();
        ServiceStatus serviceStatus = new ServiceStatus();

        MembreEntity newMembreEntity = new MembreEntity();

        BeanUtils.copyProperties(request.getMembreType(),newMembreEntity);
        MembreEntity savedMembreEntity = membreEntityService.addMembre(newMembreEntity);

        if (savedMembreEntity == null) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Exception while adding Entity");
        } else {

            BeanUtils.copyProperties(savedMembreEntity,newMembreType);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
        }

        response.setMembreType(newMembreType);
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateMembreRequest")
    @ResponsePayload
    public UpdateMembreResponse updateMembre(@RequestPayload UpdateMembreRequest request) {
        UpdateMembreResponse response = new UpdateMembreResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        // 1. Find if livre available
        MembreEntity membreFromDB = membreEntityService.getMembreByNom(request.getMembreType().getNom());

        if(membreFromDB == null) {
            serviceStatus.setStatusCode("NOT FOUND");
            serviceStatus.setMessage("Membre = " + request.getMembreType().getNom() + " not found");
        } else {

            // 2. Get updated livre information from the request
            membreFromDB.setNom(request.getMembreType().getNom());
            membreFromDB.setPrenom(request.getMembreType().getPrenom());
            membreFromDB.setAdresseMail(request.getMembreType().getAdresseMail());
            membreFromDB.setMotDePasse((request.getMembreType().getMotDePasse()));
            //livreFromDB.setDate_publication(request.getDatePublication());
            membreFromDB.setTelephone(request.getMembreType().getTelephone());

            // 3. update the livre in database
            boolean flag = membreEntityService.updateMembre(membreFromDB);

            if(flag == false) {
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Exception while updating Entity=" + request.getMembreType().getNom());
            }else {
                serviceStatus.setStatusCode("SUCCESS");
                serviceStatus.setMessage("Content updated Successfully");
            }

        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteMembreRequest")
    @ResponsePayload
    public DeleteMembreResponse deleteMembre(@RequestPayload DeleteMembreRequest request) {
        DeleteMembreResponse response = new DeleteMembreResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        boolean flag = membreEntityService.deleteMembreById(request.getId());

        if (flag == false) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Exception while deletint Entity id=" + request.getId());
        } else {
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Deleted Successfully");
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }


}
