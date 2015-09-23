/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryProcessor.HLLAPI;

/**
 * Servicio básico que maneja el set de drivers de urSQL.
 * @author jaam
 * @version 1.0
 */
public class urDriverManager {

    /**
     * Crea una conexion con urSQL.
     *
     * @param pPort Corresponde al numero de puerto donde escuha urSQL.
     * @param pDBName Corresponde al nombre de la base de datos almacenada
     * en urSQL.
     * @return Retorna un nuevo objeto de conexion.
     */
    public static urConnection getConnection(int pPort, String pDBName) {

        urConnection newConn = new urConnection();
        newConn.setHost("127.0.0.1");
        newConn.setPort(pPort);
        newConn.setDBName(pDBName);

        return newConn;
    }

}
