/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryProcessor.GUI;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jaam
 */
public class ResultSetManager {
    
    //{"Nombre":["Pedro","Mario","Pablo"],"columnNames":["Nombre","Apellido"],"rowsModif":"22","Apellido":["Ramirez","Castro","Perez"],"codeStatus":"1044"}
    
    
    // jTable1.getColumnModel().getColumn(0).setHeaderValue("Ariel");
    
    public DefaultTableModel displayColumns(String pResponse) {
        DefaultTableModel newModel = new DefaultTableModel();
        newModel.addColumn("#");
        
        JSONObject json = null;
        JSONArray jArray = null;
        
        try {
            json = new JSONObject(pResponse);
            jArray = json.getJSONArray("columnNames");
        } catch (JSONException ex) {
            Logger.getLogger(ResultSetManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(jArray.length() == 0) {
            // cuando no se realizan consultas con valores de retorno
        } else {
            for (int i = 0; i < jArray.length(); i++) {
                try {
                    JSONArray jArrayAux = json.getJSONArray(jArray.getString(i));
                    newModel.addColumn(jArray.getString(i));
                    newModel.setRowCount(jArrayAux.length());
                    for (int j = 0; j < jArrayAux.length(); j++) {
                        newModel.setValueAt(jArrayAux.get(j), j, i+1);
                        newModel.setValueAt(j, j, 0);
                        //newModel.setValueAt(Integer.toString(j), j, 0);
                    }
                } catch (JSONException ex) {
                    Logger.getLogger(ResultSetManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return newModel;
    }
    
    public String displayStatus(String pResponse) {
        String rValue = null;
        
        JSONObject json = null;
        
        try {
            json = new JSONObject(pResponse);
            rValue = "Code: " + json.getString("codeStatus") + " : " + json.getString("rowsModif") + " rows modified.";
        } catch (JSONException ex) {
            Logger.getLogger(ResultSetManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rValue;
    }
    
}
