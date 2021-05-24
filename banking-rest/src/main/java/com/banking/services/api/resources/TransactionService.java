package com.banking.services.api.resources;

import com.banking.services.api.providers.JwtAuth;
import com.banque.services.core.service.CorebankingService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@WebService
@Path("/transactions")
public class TransactionService {

    private CorebankingService corebankingService;
    {
        corebankingService = new CorebankingService();
    }
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @GET
    public Response getTransactions(){
        return Response.ok().build();
    }
}

