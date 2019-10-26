package edu.javaproject.cityregister.web;

import edu.javaproject.cityregister.domain.PersonResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/***
 * That class realize HTTP method using  Jersey Servlet (JAX-RS realization)
 */
@Path("/check")
public class CheckPersonService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(@PathParam("id") int simpleId,
                                       @QueryParam("name") String simpleName){
        return new PersonResponse();
    }
}
