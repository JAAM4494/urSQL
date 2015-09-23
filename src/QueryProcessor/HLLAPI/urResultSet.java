/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryProcessor.HLLAPI;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Tabla de informacion que representa el resultado de la base de datos, el cual
 * usualmente es generado al ejecutar consultas urSQL a la base de datos.
 *
 * @author jaam
 * @version 1.0
 */
public class urResultSet {

    private String serverResponse;

    private int index;

    public urResultSet() {
        index = -1;
    }

    /**
     * Funciona como iterador, permite obtener las filas creadas por la consulta.
     *
     * @return true si existen mas filas,
     *         false si no existen mas filas.
     */
    public Boolean next() {
        Boolean rValue = false;
        try {
            JSONObject json = new JSONObject(serverResponse);
            JSONArray jArray1 = json.getJSONArray("columnNames");
            JSONArray jArray2 = json.getJSONArray(jArray1.getString(0));

            if (index < (jArray2.length() - 1) & index != -1) {
                index += 1;
                rValue = true;
            } else if (index == -1 | index == 0) {
                index = 0;
                rValue = true;
            } else {
                rValue = false;
            }
        } catch (JSONException ex) {
            Logger.getLogger(urResultSet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rValue;
    }
    
    /**
     * Permite obtener el valor de una fila en determinada columna creada por la
     * consulta.
     *
     * @param pKey Corresponde al nombre de la columna a obtener.
     * @return Retorna el valor de la fila especificada.
     * @see next()
     */
    public String getString(String pKey) {
        String rValue = null;

        try {
            JSONObject json = new JSONObject(serverResponse);
            JSONArray jArray1 = json.getJSONArray(pKey);

            rValue = jArray1.getString(index);
        } catch (JSONException ex) {
            //Logger.getLogger(CommProtocol.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + pKey + " column not found");
        }

        return rValue;
    }

    /**
     * Permite obtener todos las filas de una columna asociada.
     *
     * @param pKey Corresponde al nombre de la columna a obtener.
     * @return Retorna en un objecto ArrayList las filas de la columna 
     * especificada.
     */
    public ArrayList getArray(String pKey) {
        ArrayList rValue = new ArrayList();

        try {
            JSONObject json = new JSONObject(serverResponse);
            JSONArray jArray1 = json.getJSONArray(pKey);
            for (int i = 0; i < jArray1.length(); i++) {
                rValue.add(jArray1.getString(i));
            }
        } catch (JSONException ex) {
            //Logger.getLogger(CommProtocol.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + pKey + " column not found");
        }

        return rValue;
    }
    
    /**
     * Permite obtener todos las filas de una columna asociada.
     *
     * @param pKeyIndex Corresponde al indice de la columna a obtener.
     * @return Retorna en un objecto ArrayList las filas de la columna 
     * especificada por medio del indice.
     */
    public ArrayList getArray(int pKeyIndex) {
        ArrayList rValue = new ArrayList();

        try {
            JSONObject json = new JSONObject(serverResponse);
            JSONArray jArray = json.getJSONArray("columnNames");
            String colName = jArray.getString(pKeyIndex);
            JSONArray jsonArrAux = json.getJSONArray(colName);
            for (int i = 0; i < jsonArrAux.length(); i++) {
                rValue.add(jsonArrAux.getString(i));
            }
        } catch (JSONException ex) {
            //Logger.getLogger(CommProtocol.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + pKeyIndex + " index bound exception");
        }

        return rValue;
    }

    /**
     * Permite obtener el codigo de status de la operacion realizada.
     *
     * @return Retorna un código de error asociado.
     */
    public int getStatusCode() {
        int rValue = 0;

        try {
            JSONObject json = new JSONObject(serverResponse);
            rValue = Integer.parseInt(json.getString("codeStatus"));
        } catch (JSONException ex) {
            Logger.getLogger(urResultSet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rValue;
    }

    /**
     * Permite obtener la cantidad de filas modificadas.
     *
     * @return Retorna el numero de la cantidad de filas modificadas.
     */
    public int getRows() {
        int rValue = 0;

        try {
            JSONObject json = new JSONObject(serverResponse);
            rValue = Integer.parseInt(json.getString("rowsModif"));
        } catch (JSONException ex) {
            Logger.getLogger(urResultSet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rValue;
    }
    
    /**
     * Asigna respuesta de urSQL (Recomend. NO USAR).
     *
     * @param serverResponse Corresponde a la respuesta de urSQL.
     */
    public void setServerResponse(String serverResponse) {
        this.serverResponse = serverResponse;
    }
}
