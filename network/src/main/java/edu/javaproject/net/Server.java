package edu.javaproject.net;

import java.io.*;
import java.lang.reflect.Constructor;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/***
 * That Server class receive and process outer requests
 */
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket server = new ServerSocket(25225, 1000);
        System.out.println("Server is started");

        // Map with command name <-> handler class association
        Map<String, Greetable> handlers = loadHandlers();

        //Start listen port of socket while you need
        while (true){
            Socket client = server.accept();
            new SimpleServer(client, handlers).start();
        }


    }

    /**
     * Method create map with "command name -> handler class" association
     * using reflection to create entities of handler classes by its full name
     */
    private static Map<String, Greetable> loadHandlers() {
        Map<String, Greetable> result = new HashMap<>();

        try (InputStream is = Server.class.getClassLoader()
                .getResourceAsStream("server.properties")){

            Properties properties = new Properties();
            properties.load(is);

            //Get full name of handler class by associated map key
            for (Object command : properties.keySet()) {
                String className = properties.getProperty(command.toString());
                //Get link on class realizzation
                Class<Greetable> cl = (Class<Greetable>) Class.forName(className);
                //Get class entity
                Greetable handler = cl.getConstructor().newInstance();
                result.put(command.toString(), handler);

            }

        } catch (Exception e){
            e.printStackTrace(System.out);
        }


        return result;
    }
}

class SimpleServer extends Thread {

    private Socket client = new Socket();
    private Map<String, Greetable> handlers;

    SimpleServer(Socket client, Map<String, Greetable> handlers){
        this.client = client;
        this.handlers = handlers;
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
            String[] strings = request.trim().split("\\s+");
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
        Greetable handler = handlers.get(command);
        if (handler != null){
            return handler.buildResponse(userName);
        }
        return "Bad command. Please, try again";
    }
}
