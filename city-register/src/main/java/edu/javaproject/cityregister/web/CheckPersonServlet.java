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
import java.time.format.DateTimeFormatter;

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

        //Get PersonRequest values from browser fields inputed by Person
        PersonRequest pReq = new PersonRequest();
        pReq.setSurName(req.getParameter("surName"));
        pReq.setGivenName(req.getParameter("givenName"));
        pReq.setPatronymic(req.getParameter("patronymic"));
        LocalDate dateOfbirth = LocalDate.parse(req.getParameter("dateOfBirth"),
                                                DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        pReq.setDateOfBirth(dateOfbirth);
        pReq.setStreetCode(Integer.parseInt(req.getParameter("streetCode")));
        pReq.setBuilding(req.getParameter("building"));
        pReq.setExtension(req.getParameter("extension"));
        pReq.setApartment(req.getParameter("apartment"));

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


