package edu.javacourse.register.dao;

import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.view.MarriageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class MarriageDao {
    public static final Logger logger = LoggerFactory.getLogger(MarriageDao.class);

    private EntityManager entityManager;

    public MarriageCertificate findMarriageCertificate(MarriageRequest request){
        logger.info("findMarriageCertificate called");

        // TODO: 11/1/2019 Fix return
        return null;
    }
}
