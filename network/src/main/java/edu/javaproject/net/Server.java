package edu.javaproject.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/***
 * Create Server class to receive and process outer requests
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(25225);
        System.out.println("Server is started");

        //Start listen port of socket while you need
        while (true){
            Socket client = server.accept();
            handleRequest(client);
        }


    }
    //Method handling requests received by server socket on port 25225
    private static void handleRequest(Socket client) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        StringBuilder sb = new StringBuilder("Hello, ");
        String username = br.readLine();
        System.out.println("Server got string: " + username);

        sb.append(username);
        bw.write(sb.toString());
        bw.newLine();               //пустая строчка
        bw.flush();

        br.close();
        bw.close();

        client.close();
    }
}
