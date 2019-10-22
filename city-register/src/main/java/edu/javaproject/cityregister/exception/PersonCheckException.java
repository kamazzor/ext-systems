package edu.javaproject.cityregister.exception;

/***
 * Class are Person check exception caused by problems with getting response
 * to {@link edu.javaproject.cityregister.domain.PersonRequest}
 * about Person from cr_register database (GRN)
 */
public class PersonCheckException extends Exception {
    public PersonCheckException() {
    }

    public PersonCheckException(String message) {
        super(message);
    }

    public PersonCheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonCheckException(Throwable cause) {
        super(cause);
    }

    public PersonCheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
