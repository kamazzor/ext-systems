package edu.javaproject.cityregister.web;

import edu.javaproject.cityregister.dao.PersonCheckDao;
import edu.javaproject.cityregister.dao.PoolConnectionBuilder;
import edu.javaproject.cityregister.domain.PersonRequest;
import edu.javaproject.cityregister.domain.PersonResponse;
import edu.javaproject.cityregister.exception.PersonCheckException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "CheckPersonServlet", urlPatterns = {"/checkPerson"})
public class CheckPersonServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CheckPersonServlet.class);

    private PersonCheckDao dao;

    @Override
    public void init() throws ServletException {
        logger.info("Servlet is created");
        dao = new PersonCheckDao();
        dao.setConnectionBuilder(new PoolConnectionBuilder());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        //Get value from "surname" browser field
        String surname = req.getParameter("surname");

        PersonRequest pReq = new PersonRequest();
        pReq.setSurName(surname);
        pReq.setGivenName("Павел");
        pReq.setPatronymic("Николаевич");
        pReq.setDateOfBirth(LocalDate.of(1995, 3, 18));
        pReq.setStreetCode(1);
        pReq.setBuilding("10");
        pReq.setExtension("2");
        pReq.setApartment("121");

        try {
            PersonResponse pResp = dao.checkPerson(pReq);
            if (pResp.isRegistered()) {
                resp.getWriter().write("Registered");
            } else {
                resp.getWriter().write("Not registered");
            }
        } catch (PersonCheckException e) {
            e.printStackTrace();
        }

    }
}


