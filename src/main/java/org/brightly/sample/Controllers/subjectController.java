package org.brightly.sample.Controllers;

import org.brightly.sample.Entities.Subject;
import org.brightly.sample.Services.subjectServices;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/student")
public class subjectController {

    @Inject
    subjectServices subjectServ ;

    @Path("/createSubject")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSubject(Subject sub){
        Subject s = subjectServ.createSubject(sub) ;
        return Response.ok(s).build() ;
    }

}
