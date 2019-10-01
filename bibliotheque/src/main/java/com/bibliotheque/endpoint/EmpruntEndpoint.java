package com.bibliotheque.endpoint;

import com.bibliotheque.service.contract.EmpruntEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
public class EmpruntEndpoint {

    private EmpruntEntityService empruntEntityService;

    public static final String NAMESPACE_URI = "http://www.bibliotheque.com/livres-ws";

    public EmpruntEndpoint() {
    }

    @Autowired
    public EmpruntEndpoint(EmpruntEntityService empruntEntityService) {
        this.empruntEntityService = empruntEntityService;
    }
}
