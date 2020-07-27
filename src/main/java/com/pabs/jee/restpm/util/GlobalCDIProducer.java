package com.pabs.jee.restpm.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;

import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationScoped
public class GlobalCDIProducer {
 
    private ObjectMapper mapper;
     
    @Produces
    public ObjectMapper getMapper(){
        if(this.mapper==null){
            this.mapper=new ObjectMapper();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            this.mapper.setDateFormat(df);
        }
        return this.mapper;
    }
}
