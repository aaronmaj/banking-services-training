package com.banque.services.client;
import com.banque.services.soap.*;

import java.util.List;

public class BanqueSoapClient {


    private BanqueWebservice banqueWebservice;
    private BanqueWebserviceSoapPort soapPort;

    public BanqueSoapClient(){
        banqueWebservice = new BanqueWebservice();
        soapPort = banqueWebservice.getBanqueWebserviceSoapPort();
    }

    public void getClients(){
        ListeClients listeClients = new ListeClients();

        ListeClientsResponse response = soapPort.listeClients(listeClients,new AuthenticationHeader());

       List<Client> clients =response.getListeClientsReponse();
        for (Client client:clients) {
            System.out.printf("%s %s %s %s %s %s %s %n",client.getNom(), client.getPrenom(), client.getAdresse(), client.getCni(),client.getCodePostal(),client.getSexe(), client.getVille());
        }

    }

    public static void main(String[] args) {
        BanqueSoapClient client = new BanqueSoapClient();
        client.getClients();
    }
}
