package com.example.demorest.Controller;



import com.example.demorest.DAO.orgDAO;
import com.example.demorest.DAO.DAOImplementation.orgDAOimpl;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("org")
public class orgController {

    orgDAO orgSer = new orgDAOimpl();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrganisations() {
        List<String> orgns = new ArrayList<>();
        orgns.add("Morgan Stanley");
        orgns.add("HP");
        orgns.add("Cisco");
        orgns.add("Microsoft");
        orgns.add("Flipkart");
        orgns.add("Amazon");
        return Response.ok().entity(orgns).build();
    }
}