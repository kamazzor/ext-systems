package javaproject.greet;

import javaproject.net.Greetable;

public class DayGreet extends Greetable {
    @Override
    public String buildResponse(String userName) {
        return "Good day, " + userName;
    }
}
