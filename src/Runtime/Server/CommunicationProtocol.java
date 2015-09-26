/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Runtime.Server;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jaam
 */
public class CommunicationProtocol {
    
    private JSONObject returnObj;
    
    public CommunicationProtocol()
    {
        returnObj = new JSONObject();
        
        JSONArray columnNames = new JSONArray();
        try {
            returnObj.put("columnNames", columnNames);
        } catch (JSONException ex) {
            Logger.getLogger(CommunicationProtocol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void accumulateData(String pColumnName, JSONArray pColumnValues)
    {
        try {
            returnObj.accumulate("columnNames", pColumnName);
            returnObj.put(pColumnName, pColumnValues);
        } catch (JSONException ex) {
            Logger.getLogger(CommunicationProtocol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setFormat(String pFormat) {
        try {
            returnObj.put("format", pFormat);
        } catch (JSONException ex) {
            Logger.getLogger(CommunicationProtocol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setStatus(String pCodeStatus, String pRowsModified)
    {
        try {
            returnObj.put("codeStatus", pCodeStatus);
            returnObj.put("rowsModif", pRowsModified);
        } catch (JSONException ex) {
            Logger.getLogger(CommunicationProtocol.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getReturnObj() {
        return returnObj.toString();
    }
    
}
