package com.bibliotheque.endpoint;

import com.bibliotheque.entity.EmpruntEntity;
import com.bibliotheque.entity.ExemplaireEntity;
import com.bibliotheque.gs_ws.*;
import com.bibliotheque.service.contract.ExemplaireEntityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class ExemplaireEndpoint {

    public static final String NAMESPACE_URI = "http://www.bibliotheque.com/livres-ws";

    private ExemplaireEntityService exemplaireEntityService;

    public ExemplaireEndpoint() {
    }

    @Autowired
    public ExemplaireEndpoint(ExemplaireEntityService exemplaireEntityService) {
        this.exemplaireEntityService = exemplaireEntityService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getExemplaireByIdRequest")
    @ResponsePayload
    public GetExemplaireByIdResponse getExemplaireById(@RequestPayload GetExemplaireByIdRequest request) {
        GetExemplaireByIdResponse response = new GetExemplaireByIdResponse();
        ExemplaireEntity exemplaireEntity = exemplaireEntityService.getExemplaireById(request.getId());
        ExemplaireType exemplaireType = new ExemplaireType();

        for(EmpruntEntity empruntEntity : exemplaireEntity.getListeEmprunts()){
            EmpruntType empruntType = new EmpruntType();

            BeanUtils.copyProperties(empruntEntity, empruntType);
            exemplaireType.getListeEmprunts().add(empruntType);
        }

        BeanUtils.copyProperties(exemplaireEntity, exemplaireType);

        response.setExemplaireType(exemplaireType);
        return response;

    }



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllExemplairesAndEmpruntsRequest")
    @ResponsePayload
    // La méthode prend en paramètre une requête et renvoit une réponse
    public GetAllExemplairesAndEmpruntsResponse getAllExemplaires(@RequestPayload GetAllExemplairesAndEmpruntsRequest request) {
        //Instanciation de l'objet réponse à renvoyer
        GetAllExemplairesAndEmpruntsResponse response = new GetAllExemplairesAndEmpruntsResponse();
        //Instanciation de l'objet exemplaireTypeList qui va contenir la liste de tous les exemplaires
        List<ExemplaireType> exemplaireTypeList = new ArrayList<ExemplaireType>();
        //On récupère tous les exemplaires que l'on stocke dans une liste
        //List<ExemplaireEntity> exemplaireEntityList = exemplaireEntityService.getAllExemlaires();
        List<ExemplaireEntity> exemplaireEntityList = exemplaireEntityService.getAllExemplairesAndEmprunts(request.getId());
        //Pour chaque exemplaire récupéré
        for (ExemplaireEntity entity : exemplaireEntityList) {
            ExemplaireType exemplaireType = new ExemplaireType();

            for(EmpruntEntity empruntEntity : entity.getListeEmprunts()){
                EmpruntType empruntType = new EmpruntType();

                BeanUtils.copyProperties(empruntEntity, empruntType);
                exemplaireType.getListeEmprunts().add(empruntType);
            }
            //On copie cet exemplaire dans un objet de type Exemplaire type
            BeanUtils.copyProperties(entity, exemplaireType);
            //Puis on ajoute cet exemplaire à la liste ExemplaireTypeList
            exemplaireTypeList.add(exemplaireType);
        }
        //On ajoute la liste des exemplaires à l'objet réponse que l'on retourne
        response.getExemplaireType().addAll(exemplaireTypeList);

        return response;
    }



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addExemplaireRequest")
    @ResponsePayload
    public AddExemplaireResponse addExemplaire(@RequestPayload AddExemplaireRequest request) {
        AddExemplaireResponse response = new AddExemplaireResponse();
        ExemplaireType newExemplaireType = new ExemplaireType();
        ServiceStatus serviceStatus = new ServiceStatus();
        ExemplaireEntity newExemplaireEntity = new ExemplaireEntity();

        BeanUtils.copyProperties(request.getExemplaireType(), newExemplaireEntity);
        ExemplaireEntity savedExemplaireEntity = exemplaireEntityService.addExemplaire(newExemplaireEntity);

        if (savedExemplaireEntity == null) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Exception while adding Entity");

        } else {

            BeanUtils.copyProperties(savedExemplaireEntity,newExemplaireType);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
        }

        response.setExemplaireType(newExemplaireType);
        response.setServiceStatus(serviceStatus);

        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateExemplaireRequest")
    @ResponsePayload
    public UpdateExemplaireResponse updateExemplaire(@RequestPayload UpdateExemplaireRequest request) {
        UpdateExemplaireResponse response = new UpdateExemplaireResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        // 1. Find if livre available
        ExemplaireEntity exemplaireFromDB = exemplaireEntityService.getExemplaireById(request.getExemplaireType().getId());

        if(exemplaireFromDB == null) {
            serviceStatus.setStatusCode("NOT FOUND");
            serviceStatus.setMessage("Exemplaire = " + request.getExemplaireType().getId() + " not found");

        } else {

            // 2. Get updated livre information from the request
            //  empruntFromDB.setDate_debut(request.getEmpruntType().getDateDebut());
            //  empruntFromDB.setDate_fin(request.getEmpruntType().getDateFin());
            exemplaireFromDB.setDisponibilite(request.getExemplaireType().isDisponibilite());

            // 3. update the livre in database
            boolean flag = exemplaireEntityService.updateExemplaire(exemplaireFromDB);

            if(flag == false) {
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Exception while updating Entity=" + request.getExemplaireType().getId());

            }else {
                serviceStatus.setStatusCode("SUCCESS");
                serviceStatus.setMessage("Content updated Successfully");
            }

        }

        response.setServiceStatus(serviceStatus);
        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteExemplaireRequest")
    @ResponsePayload
    public DeleteExemplaireResponse deleteExemplaire(@RequestPayload DeleteExemplaireRequest request) {
        DeleteExemplaireResponse response = new DeleteExemplaireResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        boolean flag = exemplaireEntityService.deleteExemplaireById(request.getId());

        if (flag == false) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Exception while deleting Entity id=" + request.getId());
        } else {
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Deleted Successfully");
        }
        response.setServiceStatus(serviceStatus);
        return response;
    }


}
