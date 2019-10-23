package edu.javaproject.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/***
 * Create Server class to receive and process outer requests
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

            StringBuilder sb = new StringBuilder("Hello, ");
            String username = br.readLine();
            System.out.println("Server got string: " + username);
            Thread.sleep(2000);

            sb.append(username);
            bw.write(sb.toString());
            bw.newLine();               //пустая строчка
            bw.flush();

            br.close();
            bw.close();

            client.close();
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
    }
}
