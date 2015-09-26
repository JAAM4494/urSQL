/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryProcessor.CLI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author jaam
 */
public class Connector {

    private Socket socket;
    private String host;
    private int port;

    private PrintWriter output;
    private BufferedReader input;

    public Connector(int pPort) {
        //host = "127.0.0.1";
        host = "192.168.1.106";
        output = null;
        input = null;
        port = pPort;
    }

    public String sendMessage(String pMessage) throws IOException{
        String serverResponse = "";

        socket = new Socket();

        try {
            socket.connect(new InetSocketAddress(host, port));
            //System.out.println("Connected");

            //writer
            output = new PrintWriter(socket.getOutputStream(), true);
            //reader
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } //Host not found
        catch (UnknownHostException e) {
            System.out.println("Error 1184: Connecting to urSQL, verify connection.");
            System.exit(1);
        }

        //Send message to server
        output.println(pMessage);

        //Get response from server
        serverResponse = input.readLine();

        //close the i/o streams
        output.close();
        input.close();
        //close the socket
        socket.close();

        return serverResponse;
    }

}

