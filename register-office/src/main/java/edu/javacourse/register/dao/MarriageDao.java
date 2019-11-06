package edu.javacourse.register.dao;

import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.view.MarriageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

/***
 * That class contains methods to work with register_office DB
 */
@Component
public class MarriageDao {
    public static final Logger logger = LoggerFactory.getLogger(MarriageDao.class);

    private EntityManager entityManager;
    @Value("${test.value}")
    private String test;

    public void setTest(String test) {
        this.test = test;
    }

    public MarriageCertificate findMarriageCertificate(MarriageRequest request){
        logger.info("findMarriageCertificate called: {}", test);

        // TODO: 11/1/2019 Fix return
        return null;
    }
}
