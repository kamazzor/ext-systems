package edu.javacourse.register.business;

import edu.javacourse.register.dao.MarriageDao;
import edu.javacourse.register.dao.PersonDao;
import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.domain.Person;
import edu.javacourse.register.rest.MarriageController;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * That class receive correct ReST-request from {@link edu.javacourse.register.rest.MarriageController} and
 * process them
 */

@Service(value = "manager")
public class MarriageManager {
    public static final Logger logger = LoggerFactory.getLogger(MarriageManager.class);

    //Examples of location of @Autowired in code.
    // All that annotations added together is excessive
    //Necessary dao objects for that Manager
    @Autowired
    private  MarriageDao marriageDao;
    private PersonDao personDao;

//    @Autowired
    public MarriageManager(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Autowired
    public MarriageManager(MarriageDao marriageDao) {
        this.marriageDao = marriageDao;
    }

    @Autowired
    private void setMarriageDao(MarriageDao marriageDao){
        this.marriageDao = marriageDao;
    }

//Unnecessary Setter when field marriageDao is @autowired
//    public void setMarriageDao(MarriageDao marriageDao) {
//        this.marriageDao = marriageDao;
//    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request){
        logger.info("findMarriageCertificate called");
        MarriageCertificate certificate = marriageDao.findMarriageCertificate(request);
        // TODO: 11/1/2019  Return normal MarriageResponse based on founded marriage certificate
        return new MarriageResponse();
    }
}
