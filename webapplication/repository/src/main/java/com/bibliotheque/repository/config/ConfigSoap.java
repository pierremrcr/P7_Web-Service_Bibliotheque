package com.bibliotheque.repository.config;

import com.bibliotheque.repository.client.ExemplaireClient;
import com.bibliotheque.repository.client.LivreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConfigSoap {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the  specified in
        // pom.xml
        marshaller.setContextPath("livres.wsdl");
        return marshaller;
    }

    @Bean
    public LivreClient livreClient(Jaxb2Marshaller marshaller) {
        LivreClient client = new LivreClient();
        client.setDefaultUri("http://localhost:8080/ws/livres");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        System.out.println("passage dans configSoap");
        return client;
    }

    @Bean
    public ExemplaireClient exemplaireClient(Jaxb2Marshaller marshaller) {
        ExemplaireClient client = new ExemplaireClient();
        client.setDefaultUri("http://localhost:8080/ws/livres");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}


