package com.pabs.jee.restpm.util;
import java.text.SimpleDateFormat;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is a config class that effects the Jackson library used to translate the data over the REST endpoint.
 *
 * @author Joshua Wilson, Vineet Reynolds
 *
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonConfig implements ContextResolver<ObjectMapper> {
    private ObjectMapper objectMapper;

    // Configure the Date coming from the client to be in ISO-8601 instead of milliseconds from the epoch.
    public JacksonConfig() throws Exception {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
    }

    @Override
    public ObjectMapper getContext(Class<?> objectType) {
        return objectMapper;
    }
}