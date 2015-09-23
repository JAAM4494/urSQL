/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RuntimeDBProcessor;

import RuntimeDBProcessor.commands.CLP.CLPCommands;
import RuntimeDBProcessor.commands.DDL.DDLCommands;
import RuntimeDBProcessor.commands.DML.DMLCommands;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author Aaron Elizondo
 */
public class RuntimeDB {
    
    private DDLCommands _ddl = new DDLCommands();
    private DMLCommands _dml = new DMLCommands();
    private CLPCommands _clp = new CLPCommands();
    JSONObject _jsonResponse ;
    
    
     public  void  CreateDB(String pDBName){
            System.out.println("DBName" +pDBName);
            _jsonResponse=_clp.CreateDB(pDBName);
            
        }
        
        public  void DisplayDB(String pDBName){
            _jsonResponse=_clp.DisplayDB(pDBName);
        }
        
        public  void  DropDB(String pDBName){
            _jsonResponse=_clp.DisplayDB(pDBName);

            
            
        }
        public void  GetStatus(){
            _jsonResponse=_clp.GetStatus();
        }
        
        public  void ListDB(){
            
            _jsonResponse=_clp.ListDB();
        }
        
        public void Start(){
            
            _jsonResponse=_clp.Start();
        }
        
        public void Stop(){
            _jsonResponse=_clp.Stop();
            
        }
        
        public void setDB(String pSchema){
           // _jsonResponse=_clp.Stop();
            
            
        }
        
        public void createTable(ArrayList<String> pCreateTable){
           // _jsonResponse=_clp.Stop();
            
            for (int i = 0; i < pCreateTable.size(); i++) {
                  System.out.println(" El:" +pCreateTable.get(i));  
                }
            
        }
        
        
        public void alterTable(ArrayList<String> pAlterTable){
           // _jsonResponse=_clp.Stop();
            
            //for (int i = 0; i < pAlterTable.size(); i++) {
             //     System.out.println(" El:" +pAlterTable.get(i));  
              //  }
            
        }
        
        public void createIndex(ArrayList<String> pCreateIndex){
           // _jsonResponse=_clp.Stop();
            
           // for (int i = 0; i < pCreateIndex.size(); i++) {
           //       System.out.println(" El:" +pCreateIndex.get(i));  
            //    }
            
        }
        
        public void update (ArrayList<String> pUpdateData){
            
            //for (int i = 0; i < pUpdateData.size(); i++) {
             //     System.out.println(" El:" +pUpdateData.get(i));  
            //}
            
            
        }
        
        public void delete (ArrayList<String> pDelete){
            
            for (int i = 0; i < pDelete.size(); i++) {
                  System.out.println(" El:" +pDelete.get(i));  
            }
            
        }
        
         public void insertInto (ArrayList<String> pDelete){
            
            for (int i = 0; i < pDelete.size(); i++) {
                  System.out.println(" El:" +pDelete.get(i));  
            }
            
        }
        
        
    
    
    
    
}
