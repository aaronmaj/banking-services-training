package com.banque.services.rest.client;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebClientTest {

    public static final String URL = "http://18.221.54.25:8080/banking-service/banking";
    private static String token ="";
    public static List<Object> providers =
            Arrays.asList(new JacksonJsonProvider(), new JacksonJaxbJsonProvider());
    public static void main(String[] args) {

        Credentials credentials = new Credentials();
        credentials.setLogin("webuser");
        credentials.setPassword("webuserpassword");

        WebClient client = WebClient.create(URL+"/auth/tokens", Arrays.asList(new JacksonJsonProvider()))
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        Response response = client.post(Entity.entity(credentials,MediaType.APPLICATION_JSON));
        token = response.getHeaderString(HttpHeaders.AUTHORIZATION);
        System.out.println("Token :"+token);

        client = WebClient.create(URL+"/api", Arrays.asList(new JacksonJsonProvider()))
                .header(HttpHeaders.AUTHORIZATION, token.substring(10))
                .type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        response = client.get();

        System.out.println(response.getEntity().toString());

    }
}
