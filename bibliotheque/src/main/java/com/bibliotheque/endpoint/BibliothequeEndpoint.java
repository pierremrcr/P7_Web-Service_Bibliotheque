package com.bibliotheque.endpoint;

import com.bibliotheque.entity.BibliothequeEntity;
import com.bibliotheque.gs_ws.*;
import com.bibliotheque.service.contract.BibliothequeEntityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class BibliothequeEndpoint {

    public static final String NAMESPACE_URI = "http://www.bibliotheque.com/livres-ws";

    private BibliothequeEntityService bibliothequeService;

    public BibliothequeEndpoint() {
    }

    @Autowired
    public BibliothequeEndpoint(BibliothequeEntityService bibliothequeService) {
        this.bibliothequeService = bibliothequeService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBibliothequeByIdRequest")
    @ResponsePayload
    public GetBibliothequeByIdResponse getBibliothequeById(@RequestPayload GetBibliothequeByIdRequest request) {
        GetBibliothequeByIdResponse response = new GetBibliothequeByIdResponse();
        BibliothequeEntity bibliothequeEntity = bibliothequeService.getBibliothequeById(request.getId());
        BibliothequeType bibliothequeType = new BibliothequeType();
        BeanUtils.copyProperties(bibliothequeEntity, bibliothequeType);
        response.setBibliothequeType(bibliothequeType);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllBibliothequesRequest")
    @ResponsePayload
    public GetAllBibliothequesResponse getAllLivres(@RequestPayload GetAllBibliothequesRequest request) {
        GetAllBibliothequesResponse response = new GetAllBibliothequesResponse();
        List<BibliothequeType> bibliothequeTypeList = new ArrayList<BibliothequeType>();
        List<BibliothequeEntity> bibliothequeEntityList = bibliothequeService.getAllBibliotheques();
        for (BibliothequeEntity entity : bibliothequeEntityList) {
            BibliothequeType bibliothequeType = new BibliothequeType();
            BeanUtils.copyProperties(entity, bibliothequeType);
            bibliothequeTypeList.add(bibliothequeType);
        }
        response.getBibliothequeType().addAll(bibliothequeTypeList);

        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBibliothequeRequest")
    @ResponsePayload
    public AddBibliothequeResponse addBibliotheque(@RequestPayload AddBibliothequeRequest request) {
        AddBibliothequeResponse response = new AddBibliothequeResponse();
        BibliothequeType newBibliothequeType = new BibliothequeType();
        ServiceStatus serviceStatus = new ServiceStatus();

        BibliothequeEntity bibliothequeEntity = new BibliothequeEntity();
        BibliothequeEntity savedBibliothequeEntity = bibliothequeService.addBibliotheque(bibliothequeEntity);

        if (savedBibliothequeEntity == null) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Exception while adding Entity");
        } else {

            BeanUtils.copyProperties(savedBibliothequeEntity,newBibliothequeType);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
        }

        response.setBibliothequeType(newBibliothequeType);
        response.setServiceStatus(serviceStatus);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateBibliothequeRequest")
    @ResponsePayload
    public UpdateBibliothequeResponse updateBibliotheque(@RequestPayload UpdateBibliothequeRequest request) {
        UpdateBibliothequeResponse response = new UpdateBibliothequeResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        // 1. Find if bibliotheque available
        BibliothequeEntity bibliothequeFromDB = bibliothequeService.getBibliothequeById(request.getBibliothequeType().getId());

        if(bibliothequeFromDB == null) {
            serviceStatus.setStatusCode("NOT FOUND");
            serviceStatus.setMessage("Bibliotheque = " + request.getBibliothequeType().getNom() + " not found");

        } else {

            // 2. Get updated bibliotheque information from the request
            bibliothequeFromDB.setNom(request.getBibliothequeType().getNom());
            bibliothequeFromDB.setTelephone((request.getBibliothequeType().getTelephone()));


            // 3. update the bibliotheque in database
            boolean flag = true;
            // bibliothequeService.updateBibliotheque(bibliothequeFromDB);

            if(flag == false) {
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Exception while updating Entity=" + request.getBibliothequeType().getNom());
            }else {
                serviceStatus.setStatusCode("SUCCESS");
                serviceStatus.setMessage("Content updated Successfully");
            }

        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    /*
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteLivreRequest")
    @ResponsePayload
    public DeleteLivreResponse deleteLivre(@RequestPayload DeleteLivreRequest request) {
        DeleteLivreResponse response = new DeleteLivreResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        boolean flag = service.deleteLivreById(request.getId());

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

    */


}
