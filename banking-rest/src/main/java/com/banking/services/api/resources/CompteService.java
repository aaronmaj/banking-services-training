package com.banking.services.api.resources;

import com.banking.services.api.providers.JwtAuth;
import com.banque.services.core.model.Compte;
import com.banque.services.core.service.CorebankingService;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@WebService
@Path("/comptes")
public class CompteService {

    @Context
    MessageContext messageContext;
    @Context
    HttpServletRequest httpServletRequest;

    private CorebankingService corebankingService;
    {
        corebankingService = new CorebankingService();
    }
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @GET
    public Response getComptes(){
        return Response.ok(corebankingService.comptes()).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response creerCompte(Compte compte){
        corebankingService.creerCompte(compte);
        return Response.ok(compte).build();
    }
}
