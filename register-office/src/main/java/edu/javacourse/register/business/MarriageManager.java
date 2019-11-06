package edu.javacourse.register.business;

import edu.javacourse.register.dao.MarriageDao;
import edu.javacourse.register.dao.PersonDao;
import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.domain.Person;
import edu.javacourse.register.domain.PersonMale;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/***
 * That class receive correct ReST-request from {@link edu.javacourse.register.rest.MarriageController} and
 * process them
 */

@Service(value = "marriageService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MarriageManager {
    public static final Logger logger = LoggerFactory.getLogger(MarriageManager.class);

    //Examples of location of @Autowired in code.
    // All that annotations added together is excessive
    //Necessary dao objects for that Manager
    @Autowired
    private  MarriageDao marriageDao;
    @Autowired
    private PersonDao personDao;


    @Autowired
    private void setMarriageDao(MarriageDao marriageDao){
        this.marriageDao = marriageDao;
    }

//Unnecessary Setter when field marriageDao is @autowired
//    public void setMarriageDao(MarriageDao marriageDao) {
//        this.marriageDao = marriageDao;
//    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public MarriageResponse findMarriageCertificate(MarriageRequest request){
        logger.info("findMarriageCertificate called");
        MarriageCertificate certificate = marriageDao.findMarriageCertificate(request);

        personDao.findPersons();

        //Add test person into DB using springContext.xml
        personDao.addPerson(getPerson());
        personDao.addPerson(getPerson());
        personDao.addPerson(getPerson());

        // TODO: 11/1/2019  Return normal MarriageResponse based on founded marriage certificate
        return new MarriageResponse();
    }

    private Person getPerson() {
        Person p = new PersonMale();
        p.setFirstName("1");
        p.setLastName("2");
        p.setPatronymic("3");
        p.setDateOfBirth(LocalDate.of(1991, 3, 12));
        return p;
    }
}
