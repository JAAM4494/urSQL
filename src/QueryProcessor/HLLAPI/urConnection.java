/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryProcessor.HLLAPI;

/**
 * Crea una sesion de conexion con urSQL.
 * @author jaam
 * @version 1.0
 */
public class urConnection {

    private String DBName;
    private String host;
    private int port;

    /**
     * Crea una declaracion de la conexion actual con urSQL.
     *
     * @return Retorna un nuevo objeto de declaracion.
     */
    public urStatement createStatement() {

        urStatement newStatement = new urStatement();
        newStatement.setHost(this.getHost());
        newStatement.setPort(this.getPort());
        newStatement.setDBName(this.getDBName());

        return newStatement;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDBName() {
        return DBName;
    }

    public void setDBName(String DBName) {
        this.DBName = DBName;
    }

}
