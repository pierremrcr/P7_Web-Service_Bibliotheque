package com.bibliotheque.endpoint;

import com.bibliotheque.service.contract.AdresseEntityService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
public class AdresseEndpoint {

    public static final String NAMESPACE_URI = "http://www.bibliotheque.com/livres-ws";

    private AdresseEntityService adresseEntityService;
}
