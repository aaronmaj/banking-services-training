package com.banking.services.api.resources;


import com.banque.services.core.model.Compte;
import com.banque.services.core.service.CorebankingService;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Service
@Path("/comptes")
public class CompteService {
    private CorebankingService corebankingService;
    {    corebankingService = new CorebankingService();}
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @GET
    public Response getComptes(){
        return Response.ok(corebankingService.comptes()).build();
    }
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @GET
    public Response getCompteById(@PathParam("id") Integer id){
        return Response.ok(corebankingService.compte(id)).build();
    }
    @Path("/get")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @GET
    public Response getCompteById(@QueryParam("numero") String numero, @Context UriInfo uriInfo){
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        return Response.ok(corebankingService.requeteCompte(queryParams.getFirst("numero"))).build();
    }
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response creerCompte(Compte compte){
        corebankingService.creerCompte(compte);
        return Response.ok(compte).build();
    }
}
