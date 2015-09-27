/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runtime.Server;
 // Configurar un servidor que reciba una conexión de un cliente, envíe
// una cadena al cliente y cierre la conexión.

import RuntimeDBProcessor.*;
import StoredDataManager.TableOperations;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.runtime.RecognitionException;
import org.json.JSONArray;

public class EngineServer {

    public static void main(String args[]) {
        ServerSocket s = null;
        Socket conn = null;
        
        try {
            s = new ServerSocket(8080, 10);
            
            
            //2. Wait for an incoming connection
            echo("Server socket created.Waiting for connection...");

            while (true) {
                //get the connection socket
                conn = s.accept();

                //print the hostname and port number of the connection
                echo("Connection received from " + conn.getInetAddress().getHostName() + " : " + conn.getPort());

                //create new thread to handle client
                new client_handler(conn).start();
            }
        } catch (IOException e) {
            System.err.println("IOException");
        }
        //5. close the connections and stream
        try {
            s.close();
        } 
        catch (IOException ioException) {
            System.err.println("Unable to close. IOexception");
        }
    }

    public static void echo(String msg) {
        System.out.println(msg);
    }
}

class client_handler extends Thread {

    private Socket conn;

    client_handler(Socket conn) {
        this.conn = conn;
    }

    @Override
    public void run() {
        String line, input = "";
        
        
        try {
            //get socket writing and reading streams
            DataInputStream in = new DataInputStream(conn.getInputStream());
            PrintStream out = new PrintStream(conn.getOutputStream());
            //Send welcome message to client
            //out.println("Welcome to the Server");
            //Now start reading input from client
            while ((line = in.readLine()) != null && !line.equals(".")) {
                //reply with the same message, adding some text
                if(line.equals("")){
                    continue;
                }
                RuntimePreParser prueba = new RuntimePreParser();
                try {
                    
                    if(line.equals("metadata")){
                        TableOperations tp = new TableOperations();
                        out.println(tp.getArbolMetadata());
                        continue;
                    }
                    if(line.equals("plan")){
                        System.out.println("PLAN "+QueryPlan.getQueryPlan());
                        out.println(QueryPlan.getQueryPlan());
                        continue;
                    }
                    if(line.equals("START")){
                        RuntimeDB.setStart();
                        CommunicationProtocol respuesta = new CommunicationProtocol();
                        JSONArray array1 = new JSONArray();
                        JSONArray array2 = new JSONArray();
                        array1.put("Runtime");
                        array1.put("System Catalog");
                        array1.put("Store Data Maneger");
                        array2.put("Running");
                        array2.put("Running");
                        array2.put("Running");
                        respuesta.accumulateData("Component", array1);
                        respuesta.accumulateData("Status", array2);
                        respuesta.setStatus("0", "0");
                        respuesta.setFormat("default");
                        out.println(respuesta.getReturnObj());
                        continue;
                    }
                    if(RuntimeDB.getStart()){
                        prueba.recievemsg(line);
                        System.out.println("SERVER "+RuntimeDB.getJson());
                        out.println(RuntimeDB.getJson());
                    }
                    else{
                        CommunicationProtocol respuesta = new CommunicationProtocol();
                        respuesta.setStatus("902", "0");
                        respuesta.setFormat("default");
                        out.println(respuesta.getReturnObj());
                    }
                } catch (RecognitionException ex) {
                    Logger.getLogger(client_handler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //client disconnected, so close socket
            conn.close();
        } catch (IOException e) {
            System.out.println("IOException on socket : " + e);
            e.printStackTrace();
        } 
    }
}
