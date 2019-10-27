package edu.javaproject.cityregister.dao;

import edu.javaproject.cityregister.domain.PersonRequest;
import edu.javaproject.cityregister.domain.PersonResponse;
import edu.javaproject.cityregister.exception.PersonCheckException;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

/***
 * That is Unit-tests class for {@link PersonCheckDao} class
 */
public class PersonCheckDaoTest {

    @Test
    public void checkPerson() throws PersonCheckException {

        //Create example PersonRequest
        PersonRequest pReq = new PersonRequest();
        pReq.setSurName("Васильев");
        pReq.setGivenName("Павел");
        pReq.setPatronymic("Николаевич");
        pReq.setDateOfBirth(LocalDate.of(1995, 3, 18));
        pReq.setStreetCode(1);
        pReq.setBuilding("10");
        pReq.setExtension("2");
        pReq.setApartment("121");

        //Create example of PersonResponse to PersonRequest
        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse pRes = dao.checkPerson(pReq);
        Assert.assertFalse(pRes.isTemporal());

    }

    @Test
    public void checkPerson2() throws PersonCheckException {

        //Create example PersonRequest
        PersonRequest pReq = new PersonRequest();
        pReq.setSurName("Васильева");
        pReq.setGivenName("Ирина");
        pReq.setPatronymic("Петровна");
        pReq.setDateOfBirth(LocalDate.of(1997, 8, 21));
        pReq.setStreetCode(1);
        pReq.setBuilding("10");
        pReq.setExtension("2");
        pReq.setApartment("121");

        //Create example of PersonResponse to PersonRequest
        PersonCheckDao dao = new PersonCheckDao();
        dao.setConnectionBuilder(new DirectConnectionBuilder());
        PersonResponse pResp = dao.checkPerson(pReq);
        Assert.assertTrue(pResp.isRegistered());
        Assert.assertFalse(pResp.isTemporal());

    }
}