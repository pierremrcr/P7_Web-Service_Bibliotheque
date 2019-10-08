package com.bibliotheque.endpoint;

import com.bibliotheque.entity.EmpruntEntity;
import com.bibliotheque.gs_ws.*;
import com.bibliotheque.service.contract.EmpruntEntityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class EmpruntEndpoint {


    public static final String NAMESPACE_URI = "http://www.bibliotheque.com/livres-ws";

    private EmpruntEntityService empruntEntityService;

    public EmpruntEndpoint() {
    }

    @Autowired
    public EmpruntEndpoint(EmpruntEntityService empruntEntityService) {
        this.empruntEntityService = empruntEntityService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmpruntByIdRequest")
    @ResponsePayload
    public GetEmpruntByIdResponse getEmpruntById(@RequestPayload GetEmpruntByIdRequest request) {
        GetEmpruntByIdResponse response = new GetEmpruntByIdResponse();
        EmpruntEntity empruntEntity = empruntEntityService.getEmpruntById(request.getId());
        EmpruntType empruntType = new EmpruntType();

        BeanUtils.copyProperties(empruntEntity, empruntType);

        response.setEmpruntType(empruntType);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmpruntsRequest")
    @ResponsePayload
    // La méthode prend en paramètre une requête et renvoit une réponse
    public GetAllEmpruntResponse getAllEmprunts(@RequestPayload GetAllEmpruntRequest request) {
        //Instanciation de l'objet réponse à renvoyer
        GetAllEmpruntResponse response = new GetAllEmpruntResponse();
        //Instanciation de l'objet empruntTypeList qui va contenir la liste de tous les emprunts
        List<EmpruntType> empruntTypeList = new ArrayList<EmpruntType>();
        //On récupère tous les emprunts que l'on stocke dans une liste empruntEntityList
        List<EmpruntEntity> empruntEntityList = empruntEntityService.getAllEmprunts();
        //Pour chaque emprunt récupéré
        for (EmpruntEntity entity : empruntEntityList) {
            EmpruntType empruntType = new EmpruntType();
            //On copie cet emprunt dans un objet de type Emprunt type
            BeanUtils.copyProperties(entity, empruntType);
            //Puis on ajoute cet emprunt à la liste EmpruntTypeList
            empruntTypeList.add(empruntType);
        }
        //On ajoute la liste des emprunts à l'objet réponse que l'on retourne
        response.getEmpruntType().addAll(empruntTypeList);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmpruntRequest")
    @ResponsePayload
    public AddEmpruntResponse addEmprunt(@RequestPayload AddEmpruntRequest request) {
        AddEmpruntResponse response = new AddEmpruntResponse();
        EmpruntType newEmpruntType = new EmpruntType();
        ServiceStatus serviceStatus = new ServiceStatus();

        EmpruntEntity newEmpruntEntity = new EmpruntEntity();

        BeanUtils.copyProperties(request.getEmpruntType(), newEmpruntEntity);
        EmpruntEntity savedEmpruntEntity = empruntEntityService.addEmprunt(newEmpruntEntity);

        if (savedEmpruntEntity == null) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Exception while adding Entity");

        } else {

            BeanUtils.copyProperties(savedEmpruntEntity,newEmpruntType);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
        }

        response.setEmpruntType(newEmpruntType);
        response.setServiceStatus(serviceStatus);

        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmpruntRequest")
    @ResponsePayload
    public UpdateEmpruntResponse updateEmprunt(@RequestPayload UpdateEmpruntRequest request) {
        UpdateEmpruntResponse response = new UpdateEmpruntResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        // 1. Find if livre available
        EmpruntEntity empruntFromDB = empruntEntityService.getEmpruntById(request.getEmpruntType().getId());

        if(empruntFromDB == null) {
            serviceStatus.setStatusCode("NOT FOUND");
            serviceStatus.setMessage("Emprunt = " + request.getEmpruntType().getId() + " not found");

        } else {

            // 2. Get updated livre information from the request
          //  empruntFromDB.setDate_debut(request.getEmpruntType().getDateDebut());
          //  empruntFromDB.setDate_fin(request.getEmpruntType().getDateFin());

            // 3. update the livre in database
            boolean flag = empruntEntityService.updateEmprunt(empruntFromDB);

            if(flag == false) {
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Exception while updating Entity=" + request.getEmpruntType().getId());

            }else {
                serviceStatus.setStatusCode("SUCCESS");
                serviceStatus.setMessage("Content updated Successfully");
            }

        }

        response.setServiceStatus(serviceStatus);
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmpruntRequest")
    @ResponsePayload
    public DeleteEmpruntResponse deleteEmprunt(@RequestPayload DeleteEmpruntRequest request) {
        DeleteEmpruntResponse response = new DeleteEmpruntResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        boolean flag = empruntEntityService.deleteEmpruntById(request.getEmpruntId());

        if (flag == false) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Exception while deleting Entity id=" + request.getEmpruntId());
        } else {
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Deleted Successfully");
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }
}

