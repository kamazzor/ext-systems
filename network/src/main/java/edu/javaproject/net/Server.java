package edu.javaproject.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/***
 * That Server class receive and process outer requests
 */
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(25225, 1000);
        System.out.println("Server is started");

        //Start listen port of socket while you need
        while (true){
            Socket client = server.accept();
            new SimpleServer(client).start();
        }


    }
    //Method handling requests received by server socket on port 25225
}

class SimpleServer extends Thread {

    private Socket client = new Socket();

    SimpleServer(Socket client){
        this.client = client;
    }

    @Override
    public void run() {
        handleRequest();
    }

    private void handleRequest() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String request = br.readLine();
            String[] strings = request.split("\\s+");
            String command = strings[0];
            String username = strings[1];
            System.out.println("Server got command: " + command);
            System.out.println("Server got username: " + username);
//            Thread.sleep(2000);

            String response = buildResponse(command, username);
            bw.write(response);
            bw.newLine();               //пустая строка
            bw.flush();

            br.close();
            bw.close();
            client.close();

        } catch (Exception e){
            e.printStackTrace(System.out);
        }
    }

    private String buildResponse(String command, String userName){
        switch (command) {
            case "HELLO" : return "Hello " + userName;
            case "MORNING" : return "Good morning " + userName;
            case "DAY" : return "Good day " + userName;
            case "EVENING" : return "Good evening " + userName;
            default: return "Bad command. Try once again";
        }
    }
}
