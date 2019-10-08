package com.bibliotheque.endpoint;

import com.bibliotheque.entity.AdresseEntity;
import com.bibliotheque.gs_ws.*;
import com.bibliotheque.service.contract.AdresseEntityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class AdresseEndpoint {

    public static final String NAMESPACE_URI = "http://www.bibliotheque.com/livres-ws";

    private AdresseEntityService adresseEntityService;

    public AdresseEndpoint() {
    }

    @Autowired
    public AdresseEndpoint(AdresseEntityService adresseEntityService) {
        this.adresseEntityService = adresseEntityService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAdresseByIdRequest")
    @ResponsePayload
    public GetAdresseByIdResponse getAdresseById(@RequestPayload GetAdresseByIdRequest request) {
        GetAdresseByIdResponse response = new GetAdresseByIdResponse();
        AdresseEntity adresseEntity = adresseEntityService.getAdresseById(request.getId());
        AdresseType adresseType = new AdresseType();

        BeanUtils.copyProperties(adresseEntity, adresseType);

        response.setAdresseType(adresseType);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllAdressesRequest")
    @ResponsePayload
    public GetAllAdressesResponse getAllAdresses(@RequestPayload GetAllAdressesRequest request) {
        GetAllAdressesResponse response = new GetAllAdressesResponse();
        List<AdresseType> adresseTypeList = new ArrayList<AdresseType>();
        List<AdresseEntity> adresseEntityList = adresseEntityService.getAllAdresses();
        for (AdresseEntity entity : adresseEntityList) {
            AdresseType adresseType = new AdresseType();
            BeanUtils.copyProperties(entity, adresseType);
            adresseTypeList.add(adresseType);
        }
        response.getAdresseType().addAll(adresseTypeList);

        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addAdresseRequest")
    @ResponsePayload
    public AddAdresseResponse addAdresse(@RequestPayload AddAdresseRequest request) {
        AddAdresseResponse response = new AddAdresseResponse();
        AdresseType newAdresseType = new AdresseType();
        ServiceStatus serviceStatus = new ServiceStatus();
        AdresseEntity newAdresseEntity = new AdresseEntity();

        BeanUtils.copyProperties(request.getAdresseType(), newAdresseEntity);
        AdresseEntity savedAdresseEntity = adresseEntityService.addAdresse(newAdresseEntity);

        if (savedAdresseEntity == null) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Exception while adding Entity");

        } else {

            BeanUtils.copyProperties(savedAdresseEntity,newAdresseType);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
        }

        response.setAdresseType(newAdresseType);
        response.setServiceStatus(serviceStatus);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateAdresseRequest")
    @ResponsePayload
    public UpdateAdresseResponse updateAdresse(@RequestPayload UpdateAdresseRequest request) {
        UpdateAdresseResponse response = new UpdateAdresseResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        // 1. Find if livre available
        AdresseEntity adresseFromDB = adresseEntityService.getAdresseById(request.getAdresseType().getId());

        if(adresseFromDB == null) {
            serviceStatus.setStatusCode("NOT FOUND");
            serviceStatus.setMessage("Adresse = " + request.getAdresseType().getId() + " not found");
        } else {

            // 2. Get updated livre information from the request
            //adresseFromDB.setNumero(request.getAdresseType().getNumero());
            adresseFromDB.setRue(request.getAdresseType().getRue());
            adresseFromDB.setCodePostal(request.getAdresseType().getCodePostal());
            adresseFromDB.setVille(request.getAdresseType().getVille());
            adresseFromDB.setPays(request.getAdresseType().getPays());

            // 3. update the livre in database
            boolean flag = adresseEntityService.updateAdresse(adresseFromDB);

            if(flag == false) {
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Exception while updating Entity=" + request.getAdresseType().getId());
            }else {
                serviceStatus.setStatusCode("SUCCESS");
                serviceStatus.setMessage("Content updated Successfully");
            }

        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteAdresseRequest")
    @ResponsePayload
    public DeleteAdresseResponse deleteAdresse(@RequestPayload DeleteAdresseRequest request) {
        DeleteAdresseResponse response = new DeleteAdresseResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        boolean flag = adresseEntityService.deleteAdresseById(request.getId());

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
