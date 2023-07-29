package com.example.demorest.Controller;

import com.example.demorest.Bean.organisations;
import com.example.demorest.DAO.DAOImplementation.almorgDAOimpl;
import com.example.demorest.DAO.almorgDAO;
//import com.example.demorest.DAO.;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.List;

@Path("almorg")
public class almorgController {

    almorgDAO almorg = new almorgDAOimpl();

    @POST
    @Path("/get_alumni")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAlumni(organisations org) {
        //System.out.println("step2 " + org.getName());
        List<Object[]> alumni = almorg.getAlumni(org);
        return Response.ok().entity(alumni).build();
    }
}