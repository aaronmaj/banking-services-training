package com.banking.services.api.providers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import javax.enterprise.inject.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.Objects;

@JwtAuth
@Provider
public class JwtAuthVerifier implements ContainerRequestFilter, ContainerResponseFilter {

    static final String AUTHORIZATION_HEADER = "Authorization";
    static final String BEARER_TYPE = "Bearer";

    private ThreadLocal<DecodedJWT> decodedJWT = new ThreadLocal<>();

    @Override
    public void filter(ContainerRequestContext requestContext) {
        try {
            String header = getAuthorizationHeader(requestContext);
            decodeBearerToken(header);
        } catch (SecurityException e) {
            requestContext.abortWith(Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity(e.getMessage())
                    .build());
        }
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
        decodedJWT.remove();
    }

    @Produces
    @Bean
    @Scope(value="", proxyMode = ScopedProxyMode.INTERFACES)
    public DecodedJWT inject() {
        return decodedJWT.get();
    }

    private void decodeBearerToken(String authorization) {
        String token = extractJwtToken(authorization);
        Verification verification = JWT.require(getSecret()).acceptLeeway(1L);
        DecodedJWT jwt = verify(token, verification);
        decodedJWT.set(jwt);
    }

    private DecodedJWT verify(String token, Verification verification) throws SecurityException {
        try {
            JWTVerifier verifier = verification.build();
            return verifier.verify(token);
        } catch (JWTVerificationException var4) {
            throw new SecurityException("Invalid JWT token.", var4);
        }
    }

    private Algorithm getSecret() {
        return Algorithm.HMAC256("secret");
    }

    private String getAuthorizationHeader(ContainerRequestContext requestContext) {
        return requestContext.getHeaderString(AUTHORIZATION_HEADER);
    }

    private String extractJwtToken(String authorization) {
        if (Objects.isNull(authorization) || "".equals(authorization)) {
            throw new SecurityException("Authorization required.");
        }

        String[] parts = authorization.split(" ");
        if (!BEARER_TYPE.equals(parts[0])) {
            throw new SecurityException("Unsupported authorization " + parts[0]);
        }

        return parts[1];
    }
}
