package RuntimeDBProcessor;

import Runtime.Server.CommunicationProtocol;
import RuntimeDBProcessor.commands.CLP.CLPCommands;
import RuntimeDBProcessor.commands.DDL.DDLCommands;
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
    private static String _json;
    
             
    public static String getJson(){
        return _json;
    }
    
    
    public void CreateDB(String pDBName){
        int i = (_clp.createDatabase(pDBName)); 
        CommunicationProtocol respuesta = new CommunicationProtocol();
        if(i==0){
            respuesta.setStatus("0", "0");
        }
        else{
            respuesta.setStatus(Integer.toString(Math.abs(i)), "0");
        }
        _json =  respuesta.getReturnObj();
        System.out.println(_json);
    }
        
    public void DisplayDB(String pDBName){
        _jsonResponse=_clp.DisplayDB(pDBName);
    }
    
    public void DropDB(String pDBName){
        int i = _clp.DropDatabase(pDBName);
        CommunicationProtocol respuesta = new CommunicationProtocol();
        if(i==0){
            respuesta.setStatus("0", "0");
        }
        else{
            respuesta.setStatus(Integer.toString(Math.abs(i)), "0");
        }
        _json =  respuesta.getReturnObj();
        System.out.println(_json);
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
        _json = _ddlP.parserSetDatabase(pSchema);
        System.out.println(_json);
        
    }

    public void createTable(ArrayList<String> pCreateTable){

        String nombre = pCreateTable.get(0);
        String pk = pCreateTable.get(pCreateTable.size()-1);
        pCreateTable.remove(0);
        pCreateTable.remove(pCreateTable.size()-1);
        _json = _ddlP.parserCreateTable(nombre, pk, pCreateTable);
        System.out.println(_json);

    }

    public void alterTable(ArrayList<String> pAlterTable){
        System.out.println("Alter");
        _json = _ddlP.parserAlterTable(pAlterTable); 
        System.out.println(_json);
    }
        
    public void dropTable(String pTable){
        _json = _ddlP.parserDropTable(pTable);
        System.out.println(_json);
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
        _json = _dmlP.parserUpdate(table, col, val, pUpdateData);
        System.out.println(_json);
        
    }
        
    public void delete (ArrayList<String> pDelete){
        String tabla = pDelete.get(0);
        pDelete.remove(0);     
        _json = _dmlP.parserDelete(tabla, pDelete);
        System.out.println(_json);
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
            _json = _dmlP.parserInsertInto(table, datos, cols);
            System.out.println(_json);
        }
        else{
            System.out.println("Error diferentes cantidades del cols y datos");
            //ERROR no viene bien el arroz
        }
        
    }
         
     public void select (ArrayList<String> pSelect){
            ArrayList<String> tablesJoin= new ArrayList<>();
            ArrayList<String> columnasCondiciones=new ArrayList<>();
            ArrayList<String> datosCondiciones=new ArrayList<>();
            ArrayList<String> operadorCondiciones=new ArrayList<>();
            
            
            TableOperations newOperation = new TableOperations();
            
            //newOperation.selecJoin("");
            Boolean inJoin = false;
            int joinIndex = 0;
            String table1 = "";
            String table2 = "";
            ArrayList<String> columnsJoin = new ArrayList<>();
            ArrayList<String> ColumnsToSelect1 = new ArrayList<>();
            ArrayList<String> ColumnsToSelect2 = new ArrayList<>();

            
            Boolean inWhere=false;     
            int whereIndex=0;
            ArrayList<Integer> condisLog = new ArrayList<>();

           for (int i = 0; i < pSelect.size(); i++) {
                  System.out.println(" El:" +pSelect.get(i));
                  if(pSelect.get(i).equals("Join")){
                      inJoin=true;
                      joinIndex++;       
                  }
                  else if(pSelect.get(i).equals("WHERE") ||  pSelect.get(i).equals("WHERE AUX") ){
                         inWhere=true;
                  }
                  else if(pSelect.get(i).equals("OR") ){
                        condisLog.add(2);
                  }
                  else if(pSelect.get(i).equals("AND") ){
                        condisLog.add(1);
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
                          tablesJoin.add(pSelect.get(i-1));      
                      }
                  }
                  else if(inWhere){
                      columnasCondiciones.add(pSelect.get(i));
                      operadorCondiciones.add(pSelect.get(i+1));
                      datosCondiciones.add(pSelect.get(i+2));
                      inWhere=false; 
                      whereIndex++;
                  } 
           }
           if(whereIndex==1){
                condisLog.add(-1);
           }
           
           //System.out.println("Condis Log"+condisLog.get(0));
           
           //System.out.println("Where index"+whereIndex);
           
           
           //System.out.println("Columnas condiciones"+columnasCondiciones.get(0));
           
           //System.out.println("Operador Condiciones"+operadorCondiciones.get(0));
           
          // System.out.println("Datos Condiciones"+datosCondiciones.get(0));

           
          // System.out.println("tables Join"+tablesJoin.get(0));
           
          // System.out.println("tables Join"+tablesJoin.get(1));
           
          
           
           //System.out.println("Primer elemento"+columnsJoinArr[0]);
           
           //System.out.println("Segundo elemento"+columnsJoinArr[1]);      
           
           
           
           for (int i = 0; i < pSelect.size(); i++) {
                 if(pSelect.get(i).equals(".")){
                     //System.out.println("Antes del punto"+pSelect.get(i-1));
                     //System.out.println("Después del punto"+pSelect.get(i+1));            
                     
                     if (pSelect.get(i-1).equals(table1)){
                         ColumnsToSelect1.add(pSelect.get(i+1));
                     }
                     else if (pSelect.get(i-1).equals(table2)){
                         ColumnsToSelect2.add(pSelect.get(i+1));
                     }
                 }
             }
            
            
             
           // System.out.println("Columns to Select 1:"+ColumnsToSelect1.get(0));
             
            //System.out.println("Columns to Select 1:"+ColumnsToSelect1.get(1));

             
            //System.out.println("Tables Join 1:"+table1); 
            

           // System.out.println("Tables Join 2:"+table2); 
            
            
           // System.out.println("Columns Join 1:"+columnsJoin.get(0));
            
          //  System.out.println("Columns Join 2:"+columnsJoin.get(1));
            
           //  System.out.println("Columns to Select from table 1 :"+ColumnsToSelect1.get(0));
            
           // System.out.println("Columns to Select from table 2:"+ColumnsToSelect2.get(0));
             
            
            newOperation = new TableOperations();
            
            String[] columnsToSelectArr1 = ColumnsToSelect1.toArray(new String[ColumnsToSelect1.size()]);
            
            String[] columnsToSelectArr2 = ColumnsToSelect2.toArray(new String[ColumnsToSelect2.size()]);
            DDLCommands ddl = new DDLCommands();
            
            //System.out.println( "Set DB"+ ddl.setDatabase("TEC_DB")  );
            
            
            //Funciones.recorrerArchivo2("TEC_DB");
            
            
            if(tablesJoin.isEmpty()==true ){
                String[] pColCondToSend;
                String[] pDatosToSend;
                String[] pOpToSend;
                
                if(columnasCondiciones.isEmpty()!=true){
                    pColCondToSend = new String[columnasCondiciones.size()];
                    pColCondToSend = columnasCondiciones.toArray(pColCondToSend);
                }
                else {
                    pColCondToSend=new String[]{};
                }
                
                if(columnasCondiciones.isEmpty()!=true){
                
                    pDatosToSend = new String[datosCondiciones.size()];

                    pDatosToSend = datosCondiciones.toArray(pDatosToSend);
                    
                }
                else{
                      pDatosToSend=new String[]{};
                }
                
                if(operadorCondiciones.isEmpty()!=true){
                      pOpToSend = new String[operadorCondiciones.size()];
                      pOpToSend = operadorCondiciones.toArray(pOpToSend);
                     
                     
                }
                else{
                    pOpToSend = new String[]{};
                }   

                int[] condisLogicArr;
                
                if(condisLog.isEmpty()!=true){
                    if(condisLog.get(0)==-1){
                        condisLogicArr= new int[]{};

                    }
                    else {
                        condisLogicArr=TableOperations.convertIntegers(condisLog);
                    }
                }
                else{
                    condisLogicArr=new int[]{};
                }
                
                ArrayList<String> coltoSelect= new ArrayList<>();
                
                inWhere=false;

                for (int i = 0; i < pSelect.size(); i++) {
                    if(pSelect.get(i).equals("*")){
                        String[] all={"="} ;
                        System.out.println( "Printing"+newOperation.select(all,
                                "TEC_DB",table1,pColCondToSend,pDatosToSend,pOpToSend,condisLogicArr));
                        break;
                    }
                    else{
                        if(pSelect.get(i).equals("FROM")==false && pSelect.get(i).equals("WHERE")==false ){
                            coltoSelect.add(pSelect.get(i)); 
                        }
                        else if(pSelect.get(i).equals("WHERE")){
                            i+=3;
                        }
                        else {
                            String[] coltoSelecttoSend = new String[coltoSelect.size()];
                            coltoSelecttoSend= coltoSelect.toArray(coltoSelecttoSend); 
                            
                            System.out.println("Columns to Select"+coltoSelecttoSend[0]);
                            
                            //System.out.println("Columns to Select"+table1);
                            
                            
                            //System.out.println("Cold Cond"+pColCondToSend[0]);


                            System.out.println(
                                    newOperation.select(coltoSelecttoSend,"TEC_DB",table1,
                                            pColCondToSend,pDatosToSend,pOpToSend,condisLogicArr).get(0)[0]);
                            
                            //newOperation.select(
                            
                            break;
                        }
                    }
                }
            }
            else{
                String[] columnsJoinArr = new String[2];
                if (tablesJoin.get(0).equals(table2)) {
                    columnsJoinArr[0] = columnsJoin.get(1);
                    columnsJoinArr[1] = columnsJoin.get(0);
                } else {
                    columnsJoinArr[0] = columnsJoin.get(0);
                    columnsJoinArr[1] = columnsJoin.get(1);
                }
                
                newOperation.selectJoin(columnsToSelectArr1, columnsToSelectArr2,
                 "TEC_DB", table1, table2, columnsJoinArr, columnasCondiciones, operadorCondiciones, 
                 datosCondiciones, condisLog, "");
                
            }
        }
     
     public void reportedError(String pError){
      
            
    }
     
     
           
}