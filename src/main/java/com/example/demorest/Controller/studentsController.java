package com.example.demorest.Controller;

import com.example.demorest.Bean.employee;
import com.example.demorest.Bean.organisations;
import com.example.demorest.Bean.students;
import com.example.demorest.DAO.orgDAO;
import com.example.demorest.DAO.DAOImplementation.orgDAOimpl;
import com.example.demorest.DAO.studentsDAO;
import com.example.demorest.DAO.DAOImplementation.studentsDAOimpl;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("student")
public class studentsController {

    studentsDAO studentsSer = new studentsDAOimpl();

    @GET
    @Path("/year")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getYear() {
        List<String> years = new ArrayList<>();
        years.add("2016");
        years.add("2017");
        years.add("2018");
        years.add("2019");
        years.add("2020");
        years.add("2021");
        years.add("2022");
        return Response.ok().entity(years).build();
    }

    @GET
    @Path("/domain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDomain() {
        List<String> domain = new ArrayList<>();
        domain.add("MT2022");
        domain.add("MT2021");
        domain.add("IMT2020");
        domain.add("IMT2021");
        domain.add("IMT2022");
        return Response.ok().entity(domain).build();
    }

    @GET
    @Path("/specialisation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecialisation() {
        List<String> spls = new ArrayList<>();
        spls.add("TSCD");
        spls.add("AIML");
        spls.add("NC");
        spls.add("VLSI");
        return Response.ok().entity(spls).build();
    }

    @GET
    @Path("/display_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Object[]> courses = studentsSer.getAll();
        return Response.ok().entity(courses).build();
    }

    @GET
    @Path("/get_placed")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlaced_Students() {
        List<Object[]> courses = studentsSer.getPlaced_Students();
        return Response.ok().entity(courses).build();
    }

    @GET
    @Path("/get_not_placed")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotPlaced_Students() {
        List<Object[]> courses = studentsSer.getNotPlaced_Students();
        return Response.ok().entity(courses).build();
    }

    @POST
    @Path("/get_specialisation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecialisation_Students(students st) {
        List<Object[]> courses = studentsSer.getSpecialisation(st);
        return Response.ok().entity(courses).build();
    }

    @POST
    @Path("/by_org")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsByOrg(organisations org) {
        //System.out.println(org.getName() + "    " + org.getId() + "    " + org.getAddress());
        List<Object[]> courses = studentsSer.getStudentsByOrg(org);
        return Response.ok().entity(courses).build();
    }

    @POST
    @Path("/by_year")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsByYear(String yr) {
        List<Object[]> courses = studentsSer.getStudentsByYear(yr);
        return Response.ok().entity(courses).build();
    }

    @POST
    @Path("/by_domain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentsByDomain(String dmn) {
        List<Object[]> courses = studentsSer.getStudentsByDomain(dmn);
        return Response.ok().entity(courses).build();
    }
    @POST
    @Path("/add")
    public Response addStudents(students st) throws URISyntaxException{
//        AddingData addingData = new AddingData();
//        addingData.add();
        if(studentsSer.addStudents(st))
        {
            return Response.ok().build();
        }
        else{
            return Response.status(203).build();
        }
    }
}