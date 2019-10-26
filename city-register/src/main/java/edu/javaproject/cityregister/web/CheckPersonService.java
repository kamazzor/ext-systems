package edu.javaproject.cityregister.web;

import edu.javaproject.cityregister.dao.PersonCheckDao;
import edu.javaproject.cityregister.dao.PoolConnectionBuilder;
import edu.javaproject.cityregister.domain.PersonRequest;
import edu.javaproject.cityregister.domain.PersonResponse;
import edu.javaproject.cityregister.exception.PersonCheckException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/***
 * That class realize HTTP method using Jersey Servlet (JAX-RS realization)
 */
@Path("/check")
@Singleton
public class CheckPersonService {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonService.class);

    private PersonCheckDao dao;


    @PostConstruct
    public void init(){
        logger.info("Servlet is created");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

//    @GET
//    public String testGetOutput(){
//        return "Answer on GET";
//    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PersonResponse checkPerson(PersonRequest personRequest) throws PersonCheckException {
        logger.info(personRequest.toString());
        return dao.checkPerson(personRequest);
    }
}
