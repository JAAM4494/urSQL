/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runtime.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author jaam
 */
public class CommProtocol {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JSONException {
        
        
        
        CommunicationProtocol respuesta = new CommunicationProtocol();
        
        JSONArray array1 = new JSONArray();
        array1.put("Pedro");
        array1.put("Mario");
        array1.put("Pablo");
        
        JSONArray array2 = new JSONArray();
        array2.put("Ramirez");
        array2.put("Castro");
        array2.put("Perez");
        
        // en esta linea se agrega el status del query sea error o si es un cero en el primer argumento
        // es que no hubo error de lo contrario hay un error asociado. El segundo argumento es la cantidad
        // de columnas modificadas
        respuesta.setStatus("1044", "0");
        // para agregar datos a la respuesta se agregan por jsonArrays con el nombre de la columna 
        // de esa coleccion de datos
        respuesta.accumulateData("Nombre",array1);
        respuesta.accumulateData("Apellido",array2);
        
        System.out.println(respuesta.getReturnObj());
    }

}
