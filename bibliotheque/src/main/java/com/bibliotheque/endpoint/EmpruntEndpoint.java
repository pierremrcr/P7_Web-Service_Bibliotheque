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

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;


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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmpruntRequest")
    @ResponsePayload
    public GetAllEmpruntResponse getAllEmprunts(@RequestPayload GetAllEmpruntRequest request) throws DatatypeConfigurationException{
        GetAllEmpruntResponse response = new GetAllEmpruntResponse();
        List<EmpruntType> empruntTypeList = new ArrayList<EmpruntType>();
        List<EmpruntEntity> empruntEntityList = empruntEntityService.getAllEmprunts();
        for (EmpruntEntity entity : empruntEntityList) {
            EmpruntType empruntType = new EmpruntType();

            GregorianCalendar dateDebut = new GregorianCalendar();
            GregorianCalendar dateFin = new GregorianCalendar();
            dateDebut.setTime(entity.getDate_debut());
            dateFin.setTime(entity.getDate_fin());
            XMLGregorianCalendar dateConvertedDebut = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateDebut);
            XMLGregorianCalendar dateConvertedFin = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateFin);

            empruntType.setDateDebut(dateConvertedDebut);
            empruntType.setDateFin(dateConvertedFin);
            BeanUtils.copyProperties(entity, empruntType);
            empruntTypeList.add(empruntType);
        }
        response.getEmpruntType().addAll(empruntTypeList);

        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmpruntsWhereDateFinIsBeforeDateTodayRequest")
    @ResponsePayload
    public GetAllEmpruntsWhereDateFinIsBeforeDateTodayResponse getAllEmpruntssWhereDateFinIsBeforeDateTodayResponse(@RequestPayload GetAllEmpruntsWhereDateFinIsBeforeDateTodayRequest request) throws DatatypeConfigurationException{
        GetAllEmpruntsWhereDateFinIsBeforeDateTodayResponse response = new GetAllEmpruntsWhereDateFinIsBeforeDateTodayResponse();
        List<EmpruntType> empruntTypeList = new ArrayList<EmpruntType>();
        List<EmpruntEntity> empruntEntityList = empruntEntityService.getAllEmpruntsWhereDateFinIsBeforeDateToday();
        for (EmpruntEntity entity : empruntEntityList) {
            EmpruntType empruntType = new EmpruntType();

            GregorianCalendar dateDebut = new GregorianCalendar();
            GregorianCalendar dateFin = new GregorianCalendar();
            dateDebut.setTime(entity.getDate_debut());
            dateFin.setTime(entity.getDate_fin());
            XMLGregorianCalendar dateConvertedDebut = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateDebut);
            XMLGregorianCalendar dateConvertedFin = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateFin);

            empruntType.setDateDebut(dateConvertedDebut);
            empruntType.setDateFin(dateConvertedFin);
            BeanUtils.copyProperties(entity, empruntType);
            empruntTypeList.add(empruntType);
        }
        response.getEmpruntType().addAll(empruntTypeList);

        return response;

    }



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmpruntRequest")
    @ResponsePayload
    public AddEmpruntResponse addEmprunt(@RequestPayload AddEmpruntRequest request) throws DatatypeConfigurationException {
        AddEmpruntResponse response = new AddEmpruntResponse();
        EmpruntType empruntType = request.getEmpruntType();
        ServiceStatus serviceStatus = new ServiceStatus();

        EmpruntEntity empruntEntity = new EmpruntEntity();

        GregorianCalendar dateDebut = new GregorianCalendar();
        GregorianCalendar dateFin = new GregorianCalendar();
        Date today = Calendar.getInstance().getTime();
        dateDebut.setTime(today);
        dateFin.add(GregorianCalendar.WEEK_OF_MONTH,4);
        XMLGregorianCalendar dateConvertedDebut = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateDebut);
        XMLGregorianCalendar dateConvertedFin = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateFin);
        empruntType.setDateDebut(dateConvertedDebut);
        empruntType.setDateFin(dateConvertedFin);
        empruntEntity.setDate_debut(today);
        empruntEntity.setDate_fin(addDays(today,28));

        //On récupère les données de la requête que l'on copie dans un objet EmpruntEntity
        BeanUtils.copyProperties(request.getEmpruntType(), empruntEntity);

        EmpruntEntity savedEmpruntEntity = empruntEntityService.addEmprunt(empruntEntity);

        if (savedEmpruntEntity == null) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Exception while adding Entity");

        } else {

            BeanUtils.copyProperties(savedEmpruntEntity,empruntType);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Content Added Successfully");
        }

        response.setEmpruntType(empruntType);
        response.setServiceStatus(serviceStatus);

        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmpruntRequest")
    @ResponsePayload
    public UpdateEmpruntResponse updateEmprunt(@RequestPayload UpdateEmpruntRequest request) throws DatatypeConfigurationException, Exception {
        UpdateEmpruntResponse response = new UpdateEmpruntResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        EmpruntType empruntType = new EmpruntType();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        LocalDateTime currentTime = LocalDateTime.now();

        Date dateToday = dateFormat.parse(dateFormat.format(dateFormat.parse(currentTime.toLocalDate().toString())));

        // 1. Find if livre available
        EmpruntEntity empruntFromDB = empruntEntityService.getEmpruntById(request.getEmpruntType().getId());

        if(empruntFromDB == null) {
            serviceStatus.setStatusCode("NOT FOUND");
            serviceStatus.setMessage("Emprunt = " + request.getEmpruntType().getId() + " not found");

        } else {

            if (!empruntFromDB.isProlongation()) {

                GregorianCalendar calendar = new GregorianCalendar();
                calendar.setTime(empruntFromDB.getDate_fin());
                calendar.add(GregorianCalendar.WEEK_OF_MONTH, 4);
                XMLGregorianCalendar dateProlongation = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
                empruntType.setDateFin(dateProlongation);
                empruntType.setProlongation(true);

                // 2. Get updated livre information from the request
                //  empruntFromDB.setDate_debut(request.getEmpruntType().getDateDebut());
                empruntFromDB.setProlongation(true);
                empruntFromDB.setDate_fin(addDays(empruntFromDB.getDate_fin(),30));
            }

            else{
                empruntType.setProlongation(false);
                empruntFromDB.setProlongation(request.getEmpruntType().isProlongation());
            }

            // 3. update the livre in database
            BeanUtils.copyProperties(empruntFromDB, empruntType);
            boolean flag = empruntEntityService.updateEmprunt(empruntFromDB);

            if (flag == false) {
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Exception while updating Entity=" + request.getEmpruntType().getId());

            } else {
                serviceStatus.setStatusCode("SUCCESS");
                serviceStatus.setMessage("Content updated Successfully");
            }

        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateRelanceEmpruntRequest")
    @ResponsePayload
    public UpdateRelanceEmpruntResponse updateRelanceEmprunt(@RequestPayload UpdateRelanceEmpruntRequest request) throws DatatypeConfigurationException, Exception {
        UpdateRelanceEmpruntResponse response = new UpdateRelanceEmpruntResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        EmpruntType empruntType = new EmpruntType();

        // 1. Find if livre available
        EmpruntEntity empruntFromDB = empruntEntityService.getEmpruntById(request.getEmpruntType().getId());

        if(empruntFromDB == null) {
            serviceStatus.setStatusCode("NOT FOUND");
            serviceStatus.setMessage("Emprunt = " + request.getEmpruntType().getId() + " not found");

        } else {

            empruntType.setRelance(true);

                // 2. Get updated livre information from the request
            empruntFromDB.setRelance(true);

            // 3. update the livre in database
            BeanUtils.copyProperties(empruntFromDB, empruntType);
            boolean flag = empruntEntityService.updateEmprunt(empruntFromDB);

            if (flag == false) {
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Exception while updating Entity=" + request.getEmpruntType().getId());

            } else {
                serviceStatus.setStatusCode("SUCCESS");
                serviceStatus.setMessage("Content updated Successfully");
            }
        }

        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmpruntTermineRequest")
    @ResponsePayload
    public UpdateEmpruntTermineResponse updateEmpruntTermine(@RequestPayload UpdateEmpruntTermineRequest request) throws DatatypeConfigurationException, Exception {
        UpdateEmpruntTermineResponse response = new UpdateEmpruntTermineResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        EmpruntType empruntType = new EmpruntType();

        // 1. Find if livre available
        EmpruntEntity empruntFromDB = empruntEntityService.getEmpruntById(request.getEmpruntType().getId());

        if(empruntFromDB == null) {
            serviceStatus.setStatusCode("NOT FOUND");
            serviceStatus.setMessage("Emprunt = " + request.getEmpruntType().getId() + " not found");

        } else {

            empruntType.setTermine(true);
            empruntFromDB.setTermine(true);
            BeanUtils.copyProperties(empruntFromDB, empruntType);
            boolean flag = empruntEntityService.updateEmpruntTermine(empruntFromDB);


            if (flag == false) {
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Exception while updating Entity=" + request.getEmpruntType().getId());

            } else {
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

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
}



