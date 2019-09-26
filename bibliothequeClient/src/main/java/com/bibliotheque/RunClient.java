package com.bibliotheque;

import livres.wsdl.GetLivreByIdResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunClient {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);
        LivreClient client = context.getBean(LivreClient.class);
        GetLivreByIdResponse response = client.getLivreById(1);
        System.out.println("response : Livre id=" + response.getLivreType().getId() +
                ", titre=" + response.getLivreType().getTitre() +
                ", auteur=" + response.getLivreType().getAuteur() +
                ", genre=" + response.getLivreType().getGenre() +
                ", resume=" + response.getLivreType().getResume()
        );


    }
}
