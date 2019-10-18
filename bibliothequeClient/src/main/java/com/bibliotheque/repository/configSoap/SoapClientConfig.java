package com.bibliotheque.repository.configSoap;

import com.bibliotheque.repository.LivreClient;
import com.bibliotheque.repository.LoginClient;
import com.bibliotheque.repository.MembreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

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
        return client;
    }

    @Bean
    public LoginClient loginClient(Jaxb2Marshaller marshaller){
        LoginClient client = new LoginClient();
        client.setDefaultUri("http://localhost:8080/ws/livres");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public MembreClient membreClient(Jaxb2Marshaller marshaller) {
        MembreClient client = new MembreClient();
        client.setDefaultUri("http://localhost:8080/ws/livres");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
