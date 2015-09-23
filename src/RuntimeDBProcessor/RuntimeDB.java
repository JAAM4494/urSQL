/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RuntimeDBProcessor;

import RuntimeDBProcessor.commands.CLP.CLPCommands;
import RuntimeDBProcessor.commands.DDL.DDLParser;
import RuntimeDBProcessor.commands.DML.DMLParser;
import StoredDataManager.TableOperations;
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
    
    TableOperations newOperation = new TableOperations();
    //newOperation.selecJoin("");
    Boolean inJoin = false;
    int joinIndex = 0;
    String table1 = "";
    String table2 = "";
    ArrayList<String> tablesJoin = new ArrayList<>();
    ArrayList<String> columnsJoin = new ArrayList<>();
    ArrayList<String> ColumnsToSelect1 = new ArrayList<>();
    ArrayList<String> ColumnsToSelect2 = new ArrayList<>();
             

    
    
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
         
     public void select (ArrayList<String> pSelect){
           for (int i = 0; i < pSelect.size(); i++) {
                  System.out.println(" El:" +pSelect.get(i));
                  if(pSelect.get(i).equals("Join")){
                      inJoin=true;
                      joinIndex++;       
                  }
                  else if(pSelect.get(i).equals("Join Finish")){
                      joinIndex=0;
                      inJoin=false;
                  }
                  
                  else if(pSelect.get(i).equals("FROM")){
                      table1=pSelect.get(i+1);
                  }
                  
                  else if(inJoin){
                      if(joinIndex==1){
                          table2=pSelect.get(i);
                          joinIndex++;
                      }
                      else if(joinIndex==2 || joinIndex==4 ){
                          tablesJoin.add(pSelect.get(i));
                          joinIndex++;
                      }
                      else if(joinIndex==3 || joinIndex==5 ){
                          columnsJoin.add(pSelect.get(i));
                          joinIndex++;
                      }
                  }
             }
             
             for (int i = 0; i < pSelect.size(); i++) {
                 if(pSelect.get(i).equals(".")){
                     System.out.println("Antes del punto"+pSelect.get(i-1));
                     System.out.println("Después del punto"+pSelect.get(i+1));
                     
                     if (pSelect.get(i-1).equals(table1)){
                         ColumnsToSelect1.add(pSelect.get(i+1));
                     }
                     else if (pSelect.get(i-1).equals(table2)){
                         ColumnsToSelect2.add(pSelect.get(i+1));
                     }
                 }
             }
             
            //System.out.println("Columns to Select 1:"+ColumnsToSelect1.get(0));
             
            //System.out.println("Columns to Select 1:"+ColumnsToSelect1.get(1));

             
            //System.out.println("Tables Join 1:"+table1); 
            

            //System.out.println("Tables Join 2:"+table2); 
            
            
            //System.out.println("Columns Join 1:"+columnsJoin.get(0));
            
            //System.out.println("Columns Join 2:"+columnsJoin.get(1));
            
          //   System.out.println("Columns to Select from table 1 :"+ColumnsToSelect1.get(0));
            
          //  System.out.println("Columns to Select from table 2:"+ColumnsToSelect2.get(1));
             
            
            
            
        
            
        }
           
}
