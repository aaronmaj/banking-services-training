package com.banking.services.api.providers;


import com.banking.services.api.model.Credentials;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

@Provider
@Consumes({MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.TEXT_XML, MediaType.APPLICATION_JSON})
public class TokenProvider implements MessageBodyReader<Credentials>, MessageBodyWriter<Credentials> {
    @Context
    protected Providers providers;

    @Override
    public boolean isReadable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public Credentials readFrom(Class<Credentials> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, String> mm, InputStream in) throws IOException, WebApplicationException {

        JAXBContext context = null;
        Unmarshaller toJavaObj = null;
        Credentials javaDomainObject = null;


        try {
            context = JAXBContext.newInstance(Credentials.class);
            toJavaObj = context.createUnmarshaller();
            javaDomainObject = (Credentials) toJavaObj.unmarshal(in);

        } catch (JAXBException ex) {
            Logger.getLogger(TokenProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return javaDomainObject;
    }

    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return true;
    }

    @Override
    public long getSize(Credentials o, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Credentials o, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {
        try {
            ContextResolver<JAXBContext> resolver = providers.getContextResolver(JAXBContext.class, mediaType);
            JAXBContext context;

            if (null == resolver || null == (context = resolver.getContext(aClass))) {
                context = JAXBContext.newInstance(aClass);
            }
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(o, outputStream);
        } catch (JAXBException exception) {
            throw new WebApplicationException(exception);
        }
    }
}