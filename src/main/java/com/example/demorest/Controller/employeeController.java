package com.example.demorest.Controller;

import com.example.demorest.Bean.employee;
import com.example.demorest.DAO.employeeDAO;
import com.example.demorest.DAO.DAOImplementation.employeeDAOimpl;
import com.example.demorest.Util.AddingData;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Path("employee")
public class employeeController {

    employeeDAO employeeSer = new employeeDAOimpl();

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDepartments() {
        List<String> departments = new ArrayList<>();
        departments.add("IT");
        departments.add("Management");
        departments.add("Admission");
        departments.add("outreach");
        departments.add("Library");
        return Response.ok().entity(departments).build();
    }

    @POST
    @Path("/add")
    public Response addEmployee(employee emp) throws URISyntaxException{
//        AddingData addingData = new AddingData();
//        addingData.add();
        if(employeeSer.addEmployee(emp))
        {
            return Response.ok().build();
        }
        else{
            return Response.status(203).build();
        }
    }

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginStudent(employee emp) throws URISyntaxException {
        System.out.print(emp);

        if(employeeSer.emailVerify(emp)){
            return Response.ok().build();
        }else{
            return Response.status(203).build();
        }
    }

    @GET
    @Path("/options")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOptions() {
        List<String> options = new ArrayList<>();
        options.add("Placed");
        options.add("Not Placed");
        options.add("Organisation");
        options.add("Year");
        options.add("Domain");
        options.add("Specialisation");
        return Response.ok().entity(options).build();
    }

}