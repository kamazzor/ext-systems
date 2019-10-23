package edu.javaproject.greet;

import edu.javaproject.net.Greetable;

public class DayGreet extends Greetable {
    @Override
    public String buildResponse(String userName) {
        return "Good day, " + userName;
    }
}
