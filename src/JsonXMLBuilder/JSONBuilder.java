package JsonXMLBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jaam
 */


public class JSONBuilder {
    private final JSONObject root;
    private final String rootName;
    private Boolean flag;
    
    
    public JSONBuilder(String pRoot) {
        root = new JSONObject();
        rootName = pRoot;
        flag = false;
    }
    
    public void addElement(JSONObject pElem, String pHeader) {
        if(flag == false) {
            try {
                JSONObject elemAux = new JSONObject();
                elemAux.put(pHeader, pElem);
                root.put(rootName, elemAux);
            } catch (JSONException ex) {
                Logger.getLogger(JSONBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
            flag = true;
        } else {
            try {
                JSONObject elemAux = new JSONObject();
                elemAux.put(pHeader, pElem);
                root.accumulate(rootName,elemAux);
            } catch (JSONException ex) {
                Logger.getLogger(JSONBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String getStringJSON() {
        String rValue = null;
        try {
            rValue = root.toString(4);
        } catch (JSONException ex) {
            Logger.getLogger(JSONBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rValue;
    }
    
    
    
}
