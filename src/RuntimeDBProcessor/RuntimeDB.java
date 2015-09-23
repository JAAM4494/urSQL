/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RuntimeDBProcessor;

import RuntimeDBProcessor.commands.CLP.CLPCommands;
import RuntimeDBProcessor.commands.DDL.DDLParser;
import RuntimeDBProcessor.commands.DML.DMLParser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/**
 *
 * @author Aaron Elizondo
 */
public class RuntimeDB {
    
    private final DDLParser _ddlP = new DDLParser();
    private final DMLParser _dmlP = new DMLParser();
    private final CLPCommands _clp = new CLPCommands();
    JSONObject _jsonResponse ;
    
    
    public void CreateDB(String pDBName){
        System.out.println(_clp.createDatabase(pDBName));    
    }
        
    public void DisplayDB(String pDBName){
        _jsonResponse=_clp.DisplayDB(pDBName);
    }
    
    public void DropDB(String pDBName){
        _ddlP.parserDropTable(pDBName);
    }
    
    public void GetStatus(){
                _jsonResponse=_clp.GetStatus();
    }

    public void ListDB(){

                _jsonResponse=_clp.ListDB();
    }

    public void Start(){

                _jsonResponse=_clp.Start();
    }

    public void Stop(){
                _jsonResponse=_clp.Stop();

    }

    public void setDB(String pSchema){
        System.out.println("pSchema" +pSchema);
        _ddlP.parserSetDatabase(pSchema);
    }

    public void createTable(ArrayList<String> pCreateTable){

        if(pCreateTable.size()>5){
            String nombre = pCreateTable.get(0);
            String pk = pCreateTable.get(pCreateTable.size()-1);
            pCreateTable.remove(0);
            pCreateTable.remove(pCreateTable.size()-1);
            _ddlP.parserCreateTable(nombre, pk, pCreateTable);
        }

    }

    public void alterTable(ArrayList<String> pAlterTable){
        _ddlP.parserAlterTable(pAlterTable); 
    }
        
    public void dropTable(String pTable){
        _ddlP.parserDropTable(pTable);
    }
    
    public void createIndex(ArrayList<String> pCreateIndex){
           // _jsonResponse=_clp.Stop();
            
           //for (int i = 0; i < pCreateIndex.size(); i++) {
           //       System.out.println(" El:" +pCreateIndex.get(i));  
            //    }
            
    }
    
    public void update (ArrayList<String> pUpdateData){
            
            String table = pUpdateData.get(0);
            String col = pUpdateData.get(1);
            String val = pUpdateData.get(2);
            pUpdateData.remove(0);
            pUpdateData.remove(0);
            pUpdateData.remove(0);
            _dmlP.parserUpdate(table, col, val, pUpdateData);
        
    }
        
    public void delete (ArrayList<String> pDelete){
        String tabla = pDelete.get(0);
        pDelete.remove(0);     
        _dmlP.parserDelete(tabla, pDelete);
    }
        
    public void insertInto(ArrayList<String> pDelete){
        String table = pDelete.get(0);
        pDelete.remove(0);
        int largo = pDelete.size(), i;
        for(i=0; i<largo; i++){
            if (pDelete.get(i).equals("VALUES")){
                break;
            }
        }
        List<String> cols = pDelete.subList(0, i);
        List<String> datos  = pDelete.subList(i+1, largo);
        
        if ( cols.size() == datos.size()){
            _dmlP.parserInsertInto(table, datos, cols);
        }
        else{
            System.out.println("Error diferentes cantidades del cols y datos");
            //ERROR no viene bien el arroz
        }
        
    }
         
    public void select (ArrayList<String> pDelete){
            for (int i = 0; i < pDelete.size(); i++) {
                  System.out.println(" El:" +pDelete.get(i));  
            }
            
    }
           
}
