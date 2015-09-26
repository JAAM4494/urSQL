/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryProcessor.HLLAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Objeto utilizado para ejecutar declaraciones estaticas urSQL y retornar los
 * resultados de los procedimientos.
 * @author jaam
 * @version 1.0
 */
public class urStatement {

    private Socket socket;
    private PrintWriter output;
    private BufferedReader input;

    private String DBName;
    private String host;
    private int port;

    /**
     * Ejecuta la declaracion urSQL dada, la cual retorna un objeto urResultSet.
     *
     * @param pUrSQL Corresponde a la declaracion urSQL a ejecutar.
     * @return Retorna un nuevo objeto urResultSet.
     * @throws java.io.IOException Captura la excepcion en la comunicacion con
     * urSQL, si la conexion no se realiza bien se reporta dicha excepcion.
     */
    public urResultSet executeQuery(String pUrSQL) throws IOException {

        urResultSet newResultSet = null;

        newResultSet = new urResultSet();
        newResultSet.setServerResponse(this.sendMessage(pUrSQL));

        return newResultSet;
    }

    /**
     * Ejecuta la declaracion urSQL dada, ya sea insertado, actualizacion 
     * o borrado.
     *
     * @param pUrSQL Corresponde a la declaracion urSQL a ejecutar.
     * @return Retorna el numero de filas que fueron afectadas.
     * @throws java.io.IOException Captura la excepcion en la comunicacion con
     * urSQL, si la conexion no se realiza bien se reporta dicha excepcion.
     */
    public int executeUpdate(String pUrSQL) throws IOException {

        int responseNumb = Integer.parseInt(this.sendMessage(pUrSQL));

        return responseNumb;
    }

    /**
     * Establece la conexion interna con urSQL Server.
     *
     * @param pMessage Corresponde al mensaje a enviar a urSQL.
     * @return Retorna la respuesta de urSQL.
     * @throws java.io.IOException Captura la excepcion en la comunicacion con
     * urSQL.
     */
    private String sendMessage(String pMessage) throws IOException {
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

    protected String getHost() {
        return host;
    }

    protected void setHost(String host) {
        this.host = host;
    }

    protected int getPort() {
        return port;
    }

    protected void setPort(int port) {
        this.port = port;
    }

    protected String getDBName() {
        return DBName;
    }

    protected void setDBName(String DBName) {
        this.DBName = DBName;
    }

}
