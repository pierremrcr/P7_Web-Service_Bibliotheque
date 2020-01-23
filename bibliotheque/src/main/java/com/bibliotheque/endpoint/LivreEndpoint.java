

package com.bibliotheque.endpoint;

import com.bibliotheque.entity.EmpruntEntity;
import com.bibliotheque.entity.ExemplaireEntity;
import com.bibliotheque.entity.LivreEntity;
import com.bibliotheque.gs_ws.*;
import com.bibliotheque.service.contract.LivreEntityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.transaction.Transactional;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
    public GetLivreByIdResponse getLivreById(@RequestPayload GetLivreByIdRequest request) throws DatatypeConfigurationException {
        GetLivreByIdResponse response = new GetLivreByIdResponse();
        LivreEntity livreEntity = this.service.getLivreById(request.getId());
        LivreType livreType = new LivreType();

        for(ExemplaireEntity exemplaireEntity : livreEntity.getListeExemplaires()){
            ExemplaireType exemplaireType = new ExemplaireType();
            BeanUtils.copyProperties(exemplaireEntity, exemplaireType);
            livreType.getListeExemplaires().add(exemplaireType);

        }

        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(livreEntity.getDatePublication());
        XMLGregorianCalendar datePublication = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
        livreType.setDatePublication(datePublication);
        BeanUtils.copyProperties(livreEntity, livreType);

        response.setLivreType(livreType);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllLivresRequest")
    @ResponsePayload
    public GetAllLivresResponse getAllLivres(@RequestPayload GetAllLivresRequest request)  throws DatatypeConfigurationException {
        GetAllLivresResponse response = new GetAllLivresResponse();
        List<LivreType> livreTypeList = new ArrayList<LivreType>();
        List<LivreEntity> livreEntityList = this.service.getAllLivres();

        GregorianCalendar calendar = new GregorianCalendar();

        for (LivreEntity entity : livreEntityList) {
            LivreType livreType = new LivreType();

            for(ExemplaireEntity exemplaireEntity: entity.getListeExemplaires()){
                ExemplaireType exemplaireType = new ExemplaireType();

                BeanUtils.copyProperties(exemplaireEntity, exemplaireType);
                livreType.getListeExemplaires().add(exemplaireType);
            }


            calendar.setTime(entity.getDatePublication());
            XMLGregorianCalendar datePublication = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
            livreType.setDatePublication(datePublication);
            BeanUtils.copyProperties(entity, livreType);
            livreTypeList.add(livreType);
        }
        response.getLivreType().addAll(livreTypeList);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllLivresEmpruntesRequest")
    @ResponsePayload
    public GetAllLivresEmpruntesResponse getAllLivresEmpruntes(@RequestPayload GetAllLivresEmpruntesRequest request)  throws DatatypeConfigurationException {
        GetAllLivresEmpruntesResponse response = new GetAllLivresEmpruntesResponse();
        List<LivreType> livreTypeList = new ArrayList<LivreType>();
        List<LivreEntity> livreEntityList = this.service.getAllLivreEmpruntesByUser(request.getId());


        for (LivreEntity entity : livreEntityList) {
            LivreType livreType = new LivreType();


            for(ExemplaireEntity exemplaireEntity: entity.getListeExemplaires()){
                ExemplaireType exemplaireType = new ExemplaireType();


                BeanUtils.copyProperties(exemplaireEntity, exemplaireType);
                livreType.getListeExemplaires().add(exemplaireType);

                for (EmpruntEntity empruntEntity : exemplaireEntity.getListeEmprunts()){
                    EmpruntType empruntType = new EmpruntType();

                    GregorianCalendar dateDebut = new GregorianCalendar();
                    GregorianCalendar dateFin = new GregorianCalendar();
                    dateDebut.setTime(empruntEntity.getDate_debut());
                    dateFin.setTime(empruntEntity.getDate_fin());
                    XMLGregorianCalendar dateConvertedDebut = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateDebut);
                    XMLGregorianCalendar dateConvertedFin = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateFin);

                    empruntType.setDateDebut(dateConvertedDebut);
                    empruntType.setDateFin(dateConvertedFin);

                    BeanUtils.copyProperties(empruntEntity, empruntType);
                    exemplaireType.getListeEmprunts().add(empruntType);
                }


            }

            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(entity.getDatePublication());
            XMLGregorianCalendar datePublication = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
            livreType.setDatePublication(datePublication);
            BeanUtils.copyProperties(entity, livreType);
            livreTypeList.add(livreType);

        }

        response.getLivreType().addAll(livreTypeList);
        return response;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addLivreRequest")
    @ResponsePayload
    public AddLivreResponse addLivre(@RequestPayload AddLivreRequest request) throws ParseException {
        AddLivreResponse response = new AddLivreResponse();
        LivreType newLivreType = new LivreType();
        LivreEntity newLivreEntity = new LivreEntity();
        ServiceStatus serviceStatus = new ServiceStatus();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date datePublication = dateFormat.parse(request.getLivreType().getDatePublication().toString());
        newLivreEntity.setDatePublication(datePublication);

        BeanUtils.copyProperties(request.getLivreType(),newLivreEntity);
        LivreEntity savedLivreEntity = this.service.addLivre(newLivreEntity);

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

        // 1. Find if livre available
        LivreEntity livreFromDB = this.service.getLivreByTitle(request.getLivreType().getTitre());

        if(livreFromDB == null) {
            serviceStatus.setStatusCode("NOT FOUND");
            serviceStatus.setMessage("Livre = " + request.getLivreType().getTitre() + " not found");

        } else {

            // 2. Get updated livre information from the request
            livreFromDB.setTitre(request.getLivreType().getTitre());
            livreFromDB.setAuteur(request.getLivreType().getAuteur());
            livreFromDB.setGenre(request.getLivreType().getGenre());
            //livreFromDB.setDate_publication(request.getDatePublication());
            livreFromDB.setResume(request.getLivreType().getResume());
            livreFromDB.setUrlPhoto(request.getLivreType().getUrlPhoto());

            // 3. update the livre in database
            boolean flag = this.service.updateLivre(livreFromDB);

            if(flag == false) {
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Exception while updating Entity=" + request.getLivreType().getTitre());
            } else {
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

        boolean flag = this.service.deleteLivreById(request.getId());

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

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSearchByKeywordRequest")
    @ResponsePayload
    @Transactional
    public GetSearchByKeywordResponse getSearchByKeyword(@RequestPayload GetSearchByKeywordRequest request){
        GetSearchByKeywordResponse response = new GetSearchByKeywordResponse();
        List<LivreEntity> listeLivresEntity = this.service.getAllLivresByKeyword("%" + request.getKeyword() + "%");
        List<LivreType>  listeLivreType = new ArrayList<>();

        for(LivreEntity entity : listeLivresEntity){
            LivreType livreType = new LivreType();

            for(ExemplaireEntity exemplaireEntity : entity.getListeExemplaires()){
                ExemplaireType exemplaireType = new ExemplaireType();

                BeanUtils.copyProperties(exemplaireEntity, exemplaireType);
                livreType.getListeExemplaires().add(exemplaireType);

            }

            BeanUtils.copyProperties(entity, livreType);
            listeLivreType.add(livreType);

        }

        response.getLivreType().addAll(listeLivreType);
        return response;
    }



}

