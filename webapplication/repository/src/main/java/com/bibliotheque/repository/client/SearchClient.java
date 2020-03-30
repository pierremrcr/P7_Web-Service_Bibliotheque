package com.bibliotheque.repository.client;

import livres.wsdl.GetSearchByKeywordRequest;
import livres.wsdl.GetSearchByKeywordResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;

public class SearchClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(LivreClient.class);

    public GetSearchByKeywordResponse getSearchByKeyword(String keyword) {

        GetSearchByKeywordResponse response = new GetSearchByKeywordResponse();

        try {
            GetSearchByKeywordRequest request = new GetSearchByKeywordRequest();
            request.setKeyword(keyword);
            response = (GetSearchByKeywordResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        } catch (SoapFaultClientException pEX) {
            logger.error("Metho GetSearchByKeywordResponse :  {}");
        }

        return response;
    }
}
