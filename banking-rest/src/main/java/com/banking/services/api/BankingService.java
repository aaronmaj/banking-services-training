package com.banking.services.api;

import com.banque.services.core.model.Client;
import com.banque.services.core.model.Compte;
import com.banque.services.core.service.CorebankingService;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Service
@Path("/api")
public class BankingService {

    private CorebankingService corebankingService;
    {
        corebankingService = new CorebankingService();
    }
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @GET
    public List<Client> getClients(){
        return corebankingService.clients();

    }
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response creerClient(Client client){
        corebankingService.creerClient(client);
        return Response.ok(client).build();

    }
    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response supprimerClient(@PathParam("id") Integer id){
        corebankingService.supprimerClient(id);
        return Response.ok().build();
    }

    public Response creerCompte(Compte compte){
        corebankingService.creerComptet(compte);
        return Response.ok().build();
    }



}
