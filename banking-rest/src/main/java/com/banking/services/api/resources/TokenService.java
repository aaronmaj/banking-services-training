package com.banking.services.api.resources;

import com.banking.services.api.model.Credentials;
import com.banking.services.api.util.KeyGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.cxf.jaxrs.ext.MessageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

@Service
@Produces({APPLICATION_JSON, APPLICATION_XML})
@Consumes({APPLICATION_JSON, APPLICATION_XML})
@Transactional
@Path("/auth")
public class TokenService {

    @Context
    private MessageContext context;
    @Context
    private UriInfo uriInfo;
    @Autowired
    private KeyGenerator keyGenerator;
    @Autowired
    private Environment env;

    @POST
    @Path("/tokens")
    @Consumes({MediaType.APPLICATION_JSON, APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, APPLICATION_XML})
    public Response authenticate(Credentials credentials) {
        String login = credentials.getLogin();
        String password = credentials.getPassword();

        try {

            // Authenticate the user using the credentials provided
            this.authenticate(login, password);
            // Issue a token for the user
            String token = issueToken(login);
            // Return the token on the response
            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();

        } catch (Exception e) {
            return Response.status(UNAUTHORIZED).build();
        }

    }

    private void authenticate(String login, String password) throws Exception {


     if(!(login.trim().equals("webuser")&&password.equals("webuserpassword"))){
         throw new SecurityException("Invalid user/password");
     }
    }

    private String issueToken(String login) {
        Key key = keyGenerator.generateKey();
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return jwtToken;
    }

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
