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

        ClientsRequest clientsRequest = new ClientsRequest();

       ClientsRequestResponse clientsRequestResponse= soapPort.clientsRequest(clientsRequest,new AuthenticationHeader());
       List<Client> clients =clientsRequestResponse.getReturn();
        for (Client client:clients) {
            System.out.printf("%s %s %s %s %s %s %s %n",client.getNom(), client.getPrenom(), client.getAdresse(), client.getCni(),client.getCodePostal(),client.getSexe(), client.getVille());
        }

    }

    public static void main(String[] args) {
        BanqueSoapClient client = new BanqueSoapClient();
        client.getClients();
    }
}
