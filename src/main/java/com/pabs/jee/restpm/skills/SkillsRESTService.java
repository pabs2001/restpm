package com.pabs.jee.restpm.skills;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Timer;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;


import javax.ws.rs.core.Context;
import javax.inject.Inject;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.WebApplicationException;

/**
 * http://localhost:8080/restpm-0.0.1-SNAPSHOT/rest/pm/Skills
 * @author coder
 *
 */
@Path("pm")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class SkillsRESTService {
    @Inject
    private Logger log;

    @Inject
    private SkillsService service;

    @Context
    private UriInfo uriInfo;

	@GET
	@Path("Skills")
	public String skills() {
		return "All skills";
	}

	@GET
	@Path("skills")
	public Response allSkills() {
		List<Skill> skills = service.findAll();
	    return Response.ok(skills).build();
	}

	@GET
	@Path("listSkills")
	public String listSkills() throws JsonProcessingException {
		log.info("listskills with list at " + ZonedDateTime.now());
		List<Skill> list =   service.findAll();
		log.info("listskills length is  " + list.size());
		ObjectMapper objectMapper = new ObjectMapper();
		String skill = objectMapper.writeValueAsString(list.get(0));
		log.info(skill);
		String json = objectMapper.writeValueAsString(list);
		
		log.info(json);
		return json;
		
	
	}

    @GET
    @Path("/{name}")
    public Response retrieveSkillByName(@PathParam("name") String name) {
        Skill skill = service.findByName(name);
        if (skill == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return Response.ok(skill).build();
    }
	
}
