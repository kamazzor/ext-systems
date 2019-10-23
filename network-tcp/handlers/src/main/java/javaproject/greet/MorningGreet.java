package javaproject.greet;

import javaproject.net.Greetable;

public class MorningGreet extends Greetable {
    @Override
    public String buildResponse(String userName) {
        return "Good morning, " + userName;
    }
}
