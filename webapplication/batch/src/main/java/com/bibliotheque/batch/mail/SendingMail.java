package com.bibliotheque.batch.mail;

import com.sun.mail.smtp.SMTPMessage;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.io.InputStream;
import java.util.Properties;

@Component
public class SendingMail {

    public static void sendMessage(String subject, String text, String adresseMail) {

        final Properties propUrl = new Properties();
        InputStream stream = null;

        final String username = "bibliotheque.oc17@gmail.com";
        final String password = "batchbibliotheque";

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.transport.protocol", "smtp");


        Session session = Session.getInstance(properties);

        // 2 -> Création du message
        MimeMultipart content = new MimeMultipart("related");
        MimeBodyPart htmlPart = new MimeBodyPart();

        try {

            htmlPart.setText(""
                            + "<html>"
                            + "<body>"
                            + "<h1>Demande de restitution d'un livre</h1>"
                            + "<hr/>"
                            + "<div id=\"conteneur\" style=\" display:flex; width:100%; margin:auto\">"
                            +                ""+ text + ""
                            + "</div>"
                            + "<hr/>"
                            + "<div style=\"margin:auto; text-align:center; width:70%\">"
                            + "<h4><a href=\"http://localhost:8080/\">Bibliothèque de La Rochelle</a></h4>"
                            + "<small>Adresse : 7 Avenue Michel Crépeau, 17000 La Rochelle</small></br>"
                            + "<small>La bibliothéque est ouverte du lundi au samedi de 9h00 à 18h00</small></br>"
                            + "<small>Téléphone : 05 17 67 58 27</small></br>"
                            + "<small>Email : mediathequedelarochelle@gmail.com</small></br>"
                            + "</div>"
                            + "</body>"
                            + "</html>"
                    ,"UTF-8", "html");

            content.addBodyPart(htmlPart);



        } catch (MessagingException pEX){
            pEX.printStackTrace();
        }

        SMTPMessage message = new SMTPMessage(session);

        try {
            message.setContent(content);
            message.setSubject(subject);
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(adresseMail));
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(username));
        } catch (MessagingException pEX){

        }


        // 3 -> Envoi du message
        Transport transport = null;
        try{

            transport = session.getTransport("smtp");
            transport.connect(username, password);
            transport.sendMessage(message, new Address[]{
                    new InternetAddress(adresseMail), new InternetAddress(username)});

        } catch (MessagingException pEX){
            pEX.printStackTrace();
        } finally {
            try {
                if (transport != null){
                    transport.close();
                }
            } catch (MessagingException pEX){
                pEX.printStackTrace();
            }
        }
    }
}
