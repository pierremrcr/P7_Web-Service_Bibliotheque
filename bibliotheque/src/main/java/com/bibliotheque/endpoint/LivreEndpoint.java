

package com.bibliotheque.endpoint;

import com.bibliotheque.entity.LivreEntity;
import com.bibliotheque.gs_ws.*;
import com.bibliotheque.service.LivreEntityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import java.util.ArrayList;
import java.util.List;

@Endpoint
public class LivreEndpoint {

    public static final String NAMESPACE_URI = "http://www.bibliotheque.com/livres-ws";

    private LivreEntityService service;

    public LivreEndpoint() {

    }

    @Autowired
    public LivreEndpoint(LivreEntityService service) {

        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLivreByIdRequest")
    @ResponsePayload
    public GetLivreByIdResponse getLivreById(@RequestPayload GetLivreByIdRequest request) {
        GetLivreByIdResponse response = new GetLivreByIdResponse();
        LivreEntity livreEntity = service.getLivreById(request.getId());
        LivreType livreType = new LivreType();
        BeanUtils.copyProperties(livreEntity, livreType);
        response.setLivreType(livreType);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllLivresRequest")
    @ResponsePayload
    public GetAllLivresResponse getAllLivres(@RequestPayload GetAllLivresRequest request) {
        GetAllLivresResponse response = new GetAllLivresResponse();
        List<LivreType> livreTypeList = new ArrayList<LivreType>();
        List<LivreEntity> livreEntityList = service.getAllLivres();
        for (LivreEntity entity : livreEntityList) {
            LivreType livreType = new LivreType();
            BeanUtils.copyProperties(entity, livreType);
            livreTypeList.add(livreType);
        }
        response.getLivreType().addAll(livreTypeList);

        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addLivreRequest")
    @ResponsePayload
    public AddLivreResponse addLivre(@RequestPayload AddLivreRequest request) {
        AddLivreResponse response = new AddLivreResponse();
        LivreType newLivreType = new LivreType();
        ServiceStatus serviceStatus = new ServiceStatus();

        LivreEntity newLivreEntity = new LivreEntity();
        LivreEntity savedLivreEntity = service.addLivre(newLivreEntity);

        if (savedLivreEntity == null) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Exception while adding Entity");
        } else {

            BeanUtils.copyProperties(savedLivreEntity,newLivreType);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
        }

        response.setLivreType(newLivreType);
        response.setServiceStatus(serviceStatus);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateLivreRequest")
    @ResponsePayload
    public UpdateLivreResponse updateLivre(@RequestPayload UpdateLivreRequest request) {
        UpdateLivreResponse response = new UpdateLivreResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        // 1. Find if movie available
        LivreEntity livreFromDB = service.getLivreByTitle(request.getTitre());

        if(livreFromDB == null) {
            serviceStatus.setStatusCode("NOT FOUND");
            serviceStatus.setMessage("Livre = " + request.getTitre() + " not found");
        } else {

            // 2. Get updated movie information from the request
            livreFromDB.setTitre(request.getTitre());
            livreFromDB.setAuteur(request.getAuteur());
            livreFromDB.setGenre(request.getGenre());
            //livreFromDB.setDate_publication(request.getDatePublication());
            livreFromDB.setResume(request.getResume());
            livreFromDB.setUrl_photo(request.getUrlPhoto());

            // 3. update the movie in database
            boolean flag = service.updateLivre(livreFromDB);

            if(flag == false) {
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Exception while updating Entity=" + request.getTitre());;
            }else {
                serviceStatus.setStatusCode("SUCCESS");
                serviceStatus.setMessage("Content updated Successfully");
            }


        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

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

}

