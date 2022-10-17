package org.brightly.sample.Controllers;


import org.brightly.sample.Entities.Student;
import org.brightly.sample.Entities.Subject;
import org.brightly.sample.Services.studentServices;
import org.jboss.resteasy.reactive.RestResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/api/student")

public class studentController {

    @Inject
    studentServices studentServ ;

    @Path("/createStudent")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createStudent(Student s){
        Student stud = studentServ.createStudent(s) ;
        return Response.ok(stud).build() ;
    }

    @Path("/assignSubject/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignSubject(@PathParam("id") Long id, Student dummy) {
        try{
            Student s = studentServ.findById(id) ;
            Long ID = s.getId() ;
            s = studentServ.assignSubjects(id,dummy);
            return Response.ok(s).build() ;
        }
        catch (Exception e){
            e.printStackTrace();
            return Response.status(NOT_FOUND).build() ;
        }

    }

    @Path("/viewDetails/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
   // @ApplicationScoped
    @Transactional
    public Response viewDetails(@PathParam("id") Long id){
        try{
            Student s = studentServ.findById(id) ;
            Long ID = s.getId() ;
            return Response.ok(s.getSubjects()).build() ;
        }
        catch (Exception e){
            System.out.println("Invalid Student ID!!!!...Please try again.");
            e.printStackTrace();
            return Response.status(NOT_FOUND).build() ;
        }
    }


}
