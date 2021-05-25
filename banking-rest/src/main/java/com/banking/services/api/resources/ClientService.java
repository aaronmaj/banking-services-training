package com.banking.services.api.resources;

import com.banking.services.api.providers.JwtAuth;
import com.banque.services.core.model.Client;
import com.banque.services.core.service.CorebankingService;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.jaxrs.ext.MessageContextImpl;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Service
@Path("/clients")
public class ClientService {
    private CorebankingService corebankingService;
    {
        corebankingService = new CorebankingService();
    }
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @GET
    public Response getClients() {
        return Response.ok(corebankingService.clients()).build();
    }

    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @GET
    public Response getClient(@QueryParam("cni") String cni, @Context UriInfo uriInfo) {
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        return Response.ok(corebankingService.requeteClient(queryParams.getFirst("cni"))).build();
    }
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @GET
    public Response getClient(@PathParam("id") Integer id) {
        return Response.ok(corebankingService.client(id)).build();
    }
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response creerClient(Client client) {
        corebankingService.creerClient(client);
        return Response.ok(client).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response supprimerClient(@PathParam("id") Integer id) {
        corebankingService.supprimerClient(id);
        return Response.ok().build();
    }
}
