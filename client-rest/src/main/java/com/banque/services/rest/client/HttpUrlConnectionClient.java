package com.banque.services.rest.client;

import com.banque.services.core.model.Compte;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectionClient {

    private static final String WEB_SERVICE_URL ="http://18.216.236.172:8080/banking-service/banking/";
    public static void main(String[] args) {
        String reponse ="";
        try {
            URL url = new URL(WEB_SERVICE_URL+"comptes/get?numero=21013120");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/xml");
            connection.setRequestProperty("Accept-Charset", "UTF-8");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                BufferedReader in =
                        new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String chunk = "";
                while ((chunk = in.readLine()) != null) reponse += chunk;
                in.close();
                if(reponse.startsWith("null")) reponse=reponse.substring(4);
                XMLInputFactory xif = XMLInputFactory.newFactory();
                xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
                XMLStreamReader xsr = xif.createXMLStreamReader(new StreamSource(new StringReader(reponse)));

                JAXBContext context = JAXBContext.newInstance(Compte.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();

                Compte compte = (Compte) unmarshaller.unmarshal(xsr);
                System.out.printf("%s %s %s %d", compte.getNumero(), compte.getIntitule(), compte.getCategorie(), compte.getSolde());
            }


        }
        catch(Exception e) {
            throw new RuntimeException("Arrrg! " + e); }

    }

}
