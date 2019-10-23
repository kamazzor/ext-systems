package edu.javaproject.net;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

/***
 * Create Client class to receive and process outer requests
 */
public class Client {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 8; i++) {
            SimpleClient sc = new SimpleClient(i);
            sc.start();
        }
    }

}

class SimpleClient extends Thread {

    public static final String[] COMMAND = {
            "HELLO", "MORNING", "DAY", "EVENING"
    };

    private int cmdNumber;

    public SimpleClient(int cmdNumber){
        this.cmdNumber = cmdNumber;
    }
    @Override
    public void run() {
        try {
//            System.out.println("Started: " + LocalDateTime.now());
            Socket client = new Socket("127.0.0.1", 25225);

            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String command = COMMAND[cmdNumber % COMMAND.length];
            String username = "Mikhail";
            bw.write(" " + command + " " + username);
            bw.newLine();
            bw.flush();

            String answer = br.readLine();
            System.out.println("Client got string: " + answer);

            br.close();
            bw.close();

            client.close();
//            System.out.println("Finished: " + LocalDateTime.now());
        } catch (IOException e){
            e.printStackTrace(System.out);
        }
    }
}