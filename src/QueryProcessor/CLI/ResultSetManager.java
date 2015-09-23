/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryProcessor.CLI;

import dnl.utils.text.table.TextTable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jaam
 */
public class ResultSetManager {
    
    public ResultSetManager()
    {
        
    }
    
    public void displayStatus(String pResponse) {
        String rValue = null;
        
        JSONObject json = null;
        
        try {
            json = new JSONObject(pResponse);
            rValue = "Code: " + json.getString("codeStatus") + " : " + json.getString("rowsModif") + " rows modified.";
        } catch (JSONException ex) {
            Logger.getLogger(ResultSetManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("------------------------------");
        System.out.println(rValue);
        System.out.println("------------------------------");
    }
    
    public void displayResult(String pResponse) {
        
        TextTable rTabValue = null;
        String[] columnNames = null;
        Object[][] data = null;
        
        JSONObject json = null;
        JSONArray jArray = null;
        JSONArray jArrayAux = null;
        
        try {
            json = new JSONObject(pResponse);
            jArray = json.getJSONArray("columnNames");
        } catch (JSONException ex) {
            Logger.getLogger(ResultSetManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(jArray.length() == 0) {
            // cuando no se realizan consultas con valores de retorno
        } else {
            columnNames = new String[jArray.length()];
            try {
                jArrayAux = json.getJSONArray(jArray.getString(0));
            } catch (JSONException ex) {
                Logger.getLogger(ResultSetManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            data = new Object[jArrayAux.length()][jArray.length()];
            for (int i = 0; i < jArray.length(); i++) {
                try {
                    jArrayAux = json.getJSONArray(jArray.getString(i));
                        
                    columnNames[i] = jArray.getString(i);
                    
                    for (int j = 0; j < jArrayAux.length(); j++) {
                        //System.out.println("Data: " + jArrayAux.getString(j));
                        data[j][i] = jArrayAux.getString(j);
                    }
                } catch (JSONException ex) {
                    Logger.getLogger(ResultSetManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        rTabValue = new TextTable(columnNames, data);
        rTabValue.setAddRowNumbering(true);
        //rTabValue.setSort(0);
        rTabValue.printTable();
    }
    
}
