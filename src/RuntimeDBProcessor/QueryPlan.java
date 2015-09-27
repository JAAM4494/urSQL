/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RuntimeDBProcessor;

import Runtime.Server.CommunicationProtocol;
import org.json.JSONArray;


/**
 *
 * @author Aaron Elizondo
 */
public class QueryPlan {
    
    private static String _queryPlan="N";
    
    public static String getQueryPlan(){
        if(_queryPlan.equals("N")){
            CommunicationProtocol respuesta = new CommunicationProtocol();
            respuesta.setFormat("default");
            respuesta.setStatus("0", "0");
            return respuesta.getReturnObj();
        }
        return  _queryPlan;
    }
    
    public void querySetDatabase(){
        
        CommunicationProtocol respuesta = new CommunicationProtocol();
        JSONArray array1 =  new JSONArray();
        JSONArray array2 =  new JSONArray();
        array1.put("Find");
        array1.put("Set");
        array2.put("database");
        array2.put("Variable of schema");
        respuesta.accumulateData("Action", array1);
        respuesta.accumulateData("Description", array2);
        respuesta.setStatus("0", "0");
        respuesta.setFormat("default");
        _queryPlan = respuesta.getReturnObj();
        
    }
    
    public void queryCreateDatabase(){
        
        CommunicationProtocol respuesta = new CommunicationProtocol();
        JSONArray array1 =  new JSONArray();
        JSONArray array2 =  new JSONArray();
        array1.put("Verify");
        array1.put("Create");
        array2.put("Database does not exist");
        array2.put("Database");
        respuesta.accumulateData("Action", array1);
        respuesta.accumulateData("Description", array2);
        respuesta.setStatus("0", "0");
        respuesta.setFormat("default");
        _queryPlan = respuesta.getReturnObj();
    }
    
    public void queryDropDatabase(){
        
        CommunicationProtocol respuesta = new CommunicationProtocol();
        JSONArray array1 =  new JSONArray();
        JSONArray array2 =  new JSONArray();
        array1.put("Verify");
        array1.put("Drop");
        array2.put("If database exist");
        array2.put("Database");
        respuesta.accumulateData("Action", array1);
        respuesta.accumulateData("Description", array2);
        respuesta.setStatus("0", "0");
        respuesta.setFormat("default");
        _queryPlan = respuesta.getReturnObj();
        
    }
    
    public void queryCreateTable(){
        
        CommunicationProtocol respuesta = new CommunicationProtocol();
        JSONArray array1 =  new JSONArray();
        JSONArray array2 =  new JSONArray();
        array1.put("Verify");
        array1.put("Create");
        array2.put("Name of table");
        array2.put("table");
        respuesta.accumulateData("Action", array1);
        respuesta.accumulateData("Description", array2);
        respuesta.setStatus("0", "0");
        respuesta.setFormat("default");
        _queryPlan = respuesta.getReturnObj();
    }
    
    public void queryDropTable(){
        
        CommunicationProtocol respuesta = new CommunicationProtocol();
        JSONArray array1 =  new JSONArray();
        JSONArray array2 =  new JSONArray();
        array1.put("Verify");
        array1.put("Drop");
        array2.put("If table exist");
        array2.put("Table");
        respuesta.accumulateData("Action", array1);
        respuesta.accumulateData("Description", array2);
        respuesta.setStatus("0", "0");
        respuesta.setFormat("default");
        _queryPlan = respuesta.getReturnObj();
        
    }
    
    public void queryAlterTable(){
        
        CommunicationProtocol respuesta = new CommunicationProtocol();
        JSONArray array1 =  new JSONArray();
        JSONArray array2 =  new JSONArray();
        array1.put("Select");
        array1.put("Select");
        array1.put("Verify");
        array1.put("Create");
        array2.put("Data of colum FK");
        array2.put("Data of colum REF");
        array2.put("All register of colum FK include in colum REF");
        array2.put("Constrait");
        respuesta.accumulateData("Action", array1);
        respuesta.accumulateData("Description", array2);
        respuesta.setStatus("0", "0");
        respuesta.setFormat("default");
        _queryPlan = respuesta.getReturnObj();
        
    }
    
    public void queryInsert(){
        
        CommunicationProtocol respuesta = new CommunicationProtocol();
        JSONArray array1 =  new JSONArray();
        JSONArray array2 =  new JSONArray();
        array1.put("Verify");
        array1.put("Get");
        array1.put("Verify");
        array1.put("Verify");
        array1.put("Verify");
        array1.put("Insert");
        array2.put("IR");
        array2.put("Metadata table");
        array2.put("Primary key can not repeat");
        array2.put("Types");
        array2.put("Nullability");
        array2.put("Register");
        respuesta.accumulateData("Action", array1);
        respuesta.accumulateData("Description", array2);
        respuesta.setStatus("0", "0");
        respuesta.setFormat("default");
        _queryPlan = respuesta.getReturnObj();
        
    }
    
    public void queryUpdate(){
        
        CommunicationProtocol respuesta = new CommunicationProtocol();
        JSONArray array1 =  new JSONArray();
        JSONArray array2 =  new JSONArray();
        array1.put("Verify");array2.put("IR");
        array1.put("Get");array2.put("Metadata of table");
        array1.put("Verify");array2.put("Constraint in a table");
        array1.put("Find");array2.put("Valid records");
        array1.put("Verify");array2.put("Types and nullability");
        array1.put("Update");array2.put("Valid records");
        respuesta.accumulateData("Action", array1);
        respuesta.accumulateData("Description", array2);
        respuesta.setStatus("0", "0");
        respuesta.setFormat("default");
        _queryPlan = respuesta.getReturnObj();
        
    }
    
    public void queryDelete(){
        
        CommunicationProtocol respuesta = new CommunicationProtocol();
        JSONArray array1 =  new JSONArray();
        JSONArray array2 =  new JSONArray();
        array1.put("Get");array2.put("Metadata of table");
        array1.put("Verify");array2.put("Constraint in a table");
        array1.put("Find");array2.put("Valid records");
        array1.put("Delete");array2.put("Valid records");
        respuesta.accumulateData("Action", array1);
        respuesta.accumulateData("Description", array2);
        respuesta.setStatus("0", "0");
        respuesta.setFormat("default");
        _queryPlan = respuesta.getReturnObj();
        
    }

}
