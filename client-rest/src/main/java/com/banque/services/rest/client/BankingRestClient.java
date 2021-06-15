package com.banque.services.rest.client;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class BankingRestClient {

    CloseableHttpClient httpclient = HttpClients.createDefault();

    private String url = "http://18.216.236.172:8080/banking-service/banking/comptes/get?numero=21013120";

    public void getClients() throws IOException {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept","application/json");

        HttpResponse response = httpclient.execute(httpGet);

        String reponse = IOUtils.toString(response.getEntity().getContent(),"UTF-8");
        System.out.println(reponse);
    }
    public static void main(String[] args) throws IOException {
      BankingRestClient client = new BankingRestClient();
      client.getClients();
    }
}
