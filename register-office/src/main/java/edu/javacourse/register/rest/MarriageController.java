package edu.javacourse.register.rest;

import edu.javacourse.register.business.MarriageManager;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/***
 * That class receive ReST-request, check them for correctness and
 * send them to {@link edu.javacourse.register.business.MarriageManager} service class
 */

@Service(value = "controller")
public class MarriageController {
    public static final Logger logger = LoggerFactory.getLogger(MarriageController.class);

    @Autowired
    private MarriageManager marriageManager;

//    public void setMarriageManager(MarriageManager marriageManager) {
//        this.marriageManager = marriageManager;
//    }

    public MarriageResponse findMarriageCertificate(MarriageRequest request){
        logger.info("findMarriageCertificate called");
        return marriageManager.findMarriageCertificate(request);
    }
}
