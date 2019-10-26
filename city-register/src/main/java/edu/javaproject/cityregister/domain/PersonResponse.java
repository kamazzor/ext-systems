package edu.javaproject.cityregister.domain;

/***
 * That domain class get response on {@link PersonRequest}
 * about Person from city_register database (GRN)
 */
public class PersonResponse {
    private boolean registered;
    private boolean temporal;

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public boolean isTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    @Override
    public String toString() {
        return "PersonResponse{" +
                "registered=" + registered +
                ", temporal=" + temporal +
                '}';
    }
}
