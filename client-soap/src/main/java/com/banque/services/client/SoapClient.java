package com.banque.services.client;

import com.banque.services.soap.*;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class SoapClient {
    private static final QName SERVICE_NAME
            = new QName("http://soap.services.banque.com", "BanqueWebservice");
    private static final QName PORT_NAME
            = new QName("http://soap.services.banque.com", "BanqueWebserviceSoapPort");

    public static void main(String[] args) throws Exception {
        Service service = Service.create(SERVICE_NAME);
        String endpointAddress = "http://18.221.54.25:8080/banque-webservice/banking";
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        BanqueWebserviceSoapPort webservice = service.getPort(PORT_NAME,BanqueWebserviceSoapPort.class);
        Client client = webservice.requeteClient("02723/123.74");
        Compte compte = new Compte();
        compte.setNumero("21011193");
        compte.setIntitule(client.getNom() + " "+client.getPrenom());
        compte.setType(Type.EPARGNE);
        compte.setStatus(Status.OUVERT);
        compte.setCategorie(Categorie.INDIVIDUEL);
        compte.setSolde(1_000_000.0);
        compte.setClient(client);

        String resultat= webservice.requeteCreerCompte(compte);
        System.out.println("Compte cree avec "+resultat.toLowerCase());
    }
}
