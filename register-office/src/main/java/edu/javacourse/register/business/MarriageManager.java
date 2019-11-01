package edu.javacourse.register.business;

import edu.javacourse.register.dao.MarriageDao;
import edu.javacourse.register.view.MarriageRequest;
import edu.javacourse.register.view.MarriageResponse;

public class MarriageManager {

    //Manager setting(-s)
    private String setting;
    //Necessary dao's for that Manager
    private  MarriageDao dao;

    public MarriageResponse findMarriageCertificate(MarriageRequest request){
        throw new UnsupportedOperationException("Unsupported");
    }
}
