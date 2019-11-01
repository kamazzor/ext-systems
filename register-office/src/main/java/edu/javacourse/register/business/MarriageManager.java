package edu.javacourse.register.business;

import edu.javacourse.register.dao.MarriageDao;
import edu.javacourse.register.domain.MarriageCertificate;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * That class receive correct ReST-request from {@link edu.javacourse.register.rest.MarriageController} and
 * process them
 */
public class MarriageManager {
    public static final Logger logger = LoggerFactory.getLogger(MarriageManager.class);

    //Necessary dao's for that Manager
    private  MarriageDao marriageDao;

    public void setMarriageDao(MarriageDao marriageDao) {
        this.marriageDao = marriageDao;
    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request){
        logger.info("findMarriageCertificate called");
        MarriageCertificate certificate = marriageDao.findMarriageCertificate(request);
        // TODO: 11/1/2019  Return normal MarriageResponse based on founded marriage certificate
        return new MarriageResponse();
    }
}
