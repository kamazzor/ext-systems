package edu.javaproject.cityregister.web;

import edu.javaproject.cityregister.domain.PersonRequest;
import edu.javaproject.cityregister.domain.PersonResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/***
 * That class realize HTTP method using Jersey Servlet (JAX-RS realization)
 */
@Path("/check")
public class CheckPersonService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(PersonRequest personRequest){
        System.out.println(personRequest.toString());
        return new PersonResponse();
    }
}
