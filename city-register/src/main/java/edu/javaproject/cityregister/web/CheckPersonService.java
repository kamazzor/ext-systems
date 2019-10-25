package edu.javaproject.cityregister.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/check")
public class CheckPersonService {
    @GET
    public String checkPerson(){
        // TODO: 10/26/2019 fix return
        return "Simple string";
    }
}
