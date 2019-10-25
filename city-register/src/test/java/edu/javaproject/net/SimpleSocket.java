package edu.javaproject.net;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleSocket {
    @Test
    public void simpleSocket() throws IOException {
        Socket socket = new Socket("localhost", 8080);

        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        //Command to get connection with other program
        String command = "GET / HTTP/1.1\r\nHost:localhost\r\n\r\n";
        os.write(command.getBytes());
        os.flush();

        //Read bytes while they exists. It doesn't, is.read() return -1
        int c = 0;
        while ((c = is.read()) != -1) {
            System.out.print((char)c);
        }

        socket.close();
    }
}
