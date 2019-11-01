package edu.javacourse.register.rest;

import edu.javacourse.register.business.MarriageManager;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * That class receive ReST-request, check them for correctness and
 * send them to {@link edu.javacourse.register.business.MarriageManager} service class
 */
public class MarriageController {
    public static final Logger logger = LoggerFactory.getLogger(MarriageController.class);

    private MarriageManager marriageManager;

    public void setMarriageManager(MarriageManager marriageManager) {
        this.marriageManager = marriageManager;
    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request){
        logger.info("findMarriageCertificate called");
        return marriageManager.findMarriageCertificate(request);
    }
}
