package RuntimeDBProcessor;

import Runtime.Server.CommunicationProtocol;
import RuntimeDBProcessor.commands.CLP.CLPCommands;
import RuntimeDBProcessor.commands.DDL.DDLCommands;
import RuntimeDBProcessor.commands.DDL.DDLParser;
import RuntimeDBProcessor.commands.DML.DMLParser;
import StoredDataManager.TableOperations;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import urSQL.tipos.typeData;
import JsonXMLBuilder.*;

/**
 *
 * @author Aaron Elizondo
 */
public class RuntimeDB {
    
    private final DDLParser _ddlP = new DDLParser();
    private final DMLParser _dmlP = new DMLParser();
    private final CLPCommands _clp = new CLPCommands();
    private final QueryPlan _queryPlan = new QueryPlan();
    private static boolean _flagStart=false;
    private static String _json;
    
    public static boolean getStart(){
        return _flagStart;
    }
    
    public static void setStart(){
        _flagStart=true;
    }      
    
    public static String getJson(){
        return _json;
    }
     
    public void CreateDB(String pDBName){
        
        _queryPlan.queryCreateDatabase();
        int i = (_clp.createDatabase(pDBName)); 
        CommunicationProtocol respuesta = new CommunicationProtocol();
        if(i==0){
            respuesta.setStatus("0", "0");
        }
        else{
            respuesta.setStatus(Integer.toString(Math.abs(i)), "0");
        }
        respuesta.setFormat("default");
        _json =  respuesta.getReturnObj();
        System.out.println("JSON CREATE DB "+_json);
    }
        
    public void DisplayDB(String pDBName){
        _json = _clp.DisplayDB(pDBName);
        System.out.println("JSON DISPLAY DB "+_json);
    }
    
    public void DropDB(String pDBName){
        _queryPlan.queryDropDatabase();
        int i = _clp.DropDatabase(pDBName);
        CommunicationProtocol respuesta = new CommunicationProtocol();
        if(i==0){
            respuesta.setStatus("0", "0");
        }
        else{
            respuesta.setStatus(Integer.toString(Math.abs(i)), "0");
        }
        respuesta.setFormat("default");
        _json =  respuesta.getReturnObj();
        System.out.println("JSON DROP DB "+_json);
    }
    
    public void GetStatus(){
        _json=_clp.GetStatus(_flagStart);
        System.out.println("JSON GET STATUS "+_json);
    }

    public void ListDB(){
        _json = _clp.ListDB();
        System.out.println("JSON LISTDB "+_json);
    }

    public void Start(){
        _flagStart = true;
        CommunicationProtocol respuesta = new CommunicationProtocol();
        respuesta.setStatus("0", "0");
        respuesta.setFormat("default");
        _json = respuesta.getReturnObj();
        System.out.println("JSON START" + _json);
    }

    public void Stop(){
        _flagStart = false;
        CommunicationProtocol respuesta = new CommunicationProtocol();
        respuesta.setStatus("0", "0");
        respuesta.setFormat("default");
        _json = respuesta.getReturnObj();
        System.out.println("JSON STOP" + _json);
    }

    public void setDB(String pSchema){
        _queryPlan.querySetDatabase();
        _json = _ddlP.parserSetDatabase(pSchema);
        System.out.println("JSON SET DB "+_json);
        
    }

    public void createTable(ArrayList<String> pCreateTable){
        _queryPlan.queryCreateTable();
        String nombre = pCreateTable.get(0);
        String pk = pCreateTable.get(pCreateTable.size()-1);
        pCreateTable.remove(0);
        pCreateTable.remove(pCreateTable.size()-1);
        _json = _ddlP.parserCreateTable(nombre, pk, pCreateTable);
        System.out.println("JSON CREATE TABLE "+_json);

    }

    public void alterTable(ArrayList<String> pAlterTable){
        _queryPlan.queryAlterTable();
        _json = _ddlP.parserAlterTable(pAlterTable); 
        System.out.println("JSON ALTER "+_json);
    }
        
    public void dropTable(String pTable){
        _queryPlan.queryDropTable();
        _json = _ddlP.parserDropTable(pTable);
        System.out.println("JSON DROP TABLE "+_json);
    }
    
    public void createIndex(ArrayList<String> pCreateIndex){
        _queryPlan.queryIndex();
        _json = _ddlP.parserCreateIndex(pCreateIndex.get(0), pCreateIndex.get(0), pCreateIndex.get(0));
        System.out.println("JSON INDEX "+_json);
            
    }
    
    public void update (ArrayList<String> pUpdateData){
        _queryPlan.queryUpdate();
        String table = pUpdateData.get(0);
        String col = pUpdateData.get(1);
        String val = pUpdateData.get(2);
        pUpdateData.remove(0);
        pUpdateData.remove(0);
        pUpdateData.remove(0);
        _json = _dmlP.parserUpdate(table, col, val, pUpdateData);
        System.out.println("JSON UPDATE "+_json);
        
    }
        
    public void delete (ArrayList<String> pDelete){
        _queryPlan.queryDelete();
        String tabla = pDelete.get(0);
        pDelete.remove(0);     
        _json = _dmlP.parserDelete(tabla, pDelete);
        System.out.println("JSON DELETE "+_json);
    }
        
    public void insertInto(ArrayList<String> pDelete){
        
        _queryPlan.queryInsert();
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
            System.out.println("JSON INSERT " +_json);
        }
        else{
            CommunicationProtocol respuesta = new CommunicationProtocol();
            respuesta.setStatus("903", "0");
            respuesta.setFormat("default");
            _json = respuesta.getReturnObj();
            System.out.println("JSON INSERT " + _json);
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
            
            ArrayList<String> forJSONXml = new ArrayList<>();

            
            Boolean inWhere=false;     
            int whereIndex=0;
            Boolean inAggregate=false;
            ArrayList<Integer> condisLog = new ArrayList<>();
            ArrayList<String> aggregateFunction= new ArrayList<>();
            
            
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
                  
                   else if(pSelect.get(i).equals("FOR JSON")|| pSelect.get(i).equals("FOR XML")){
                        forJSONXml.add(pSelect.get(i));
                        
                  }
                  
                  else if(pSelect.get(i).equals("Aggregate Function")){
                      inAggregate=true;
                      
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
                  
                  
                  else if (inAggregate){
                      String aggregateFunctionStr=pSelect.get(i);
                      String[] splittedStr = aggregateFunctionStr.split("\\(");

                      aggregateFunction.add(splittedStr[0]);

                      String[] splittedStr2=splittedStr[1].split("\\)");
                      aggregateFunction.add(splittedStr2[0]);
                      
                      

                      inAggregate=false;
                      
                      
                  }
           }
           if(whereIndex==1){
                condisLog.add(-1);
           }
           if(aggregateFunction.isEmpty()!=true){
                
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
                
                if(datosCondiciones.isEmpty()!=true){
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
                
                newOperation = new TableOperations();
                String schema = DDLCommands.getSchema();
                CommunicationProtocol respuesta = new CommunicationProtocol();

                if(schema.equals("NULL")){
                    respuesta.setStatus("1046", "0");
                    respuesta.setFormat("default");
                    _json= respuesta.getReturnObj();
                    System.out.println(respuesta.getReturnObj());
                    return ;
                }
                int result = newOperation.selectAggregateFunction(schema, table1,
                        aggregateFunction, pColCondToSend,
                        pDatosToSend, pOpToSend, condisLogicArr);

                if(result==-1){
                    respuesta.setStatus("1072", "0");
                    respuesta.setFormat("default");
                    _json= respuesta.getReturnObj();
                    System.out.println(respuesta.getReturnObj());

                    return ;
                }
                
                if(forJSONXml.isEmpty()!=false){
                    if (forJSONXml.equals("FOR JSON")){
                        JSONBuilder newJBuilder= new JSONBuilder(aggregateFunction.get(0));
                       // newJBuilder.addElement(aggregateFunction.get(0), table2);
                        
                        
                    }
                    else{
                        
                        
                    }
                    
                    
                }
                

                JSONArray tmpArr = new JSONArray();
                tmpArr.put(Integer.toString(result));
                respuesta.accumulateData(aggregateFunction.get(0), tmpArr);
                
                System.out.println(respuesta.getReturnObj());
                respuesta.setStatus("0", "0");
                respuesta.setFormat("default");
                _json= respuesta.getReturnObj();
               
               
               
           }
           
             
 
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

             
            
            newOperation = new TableOperations();
            
            String[] columnsToSelectArr1 = ColumnsToSelect1.toArray(new String[ColumnsToSelect1.size()]);
            
            String[] columnsToSelectArr2 = ColumnsToSelect2.toArray(new String[ColumnsToSelect2.size()]);
            
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
                
                if(datosCondiciones.isEmpty()!=true){
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
                        //System.out.println( "Printing"+newOperation.select(all,
                        //        "TEC_DB",table1,pColCondToSend,pDatosToSend,pOpToSend,condisLogicArr).get(0)[1]);
                         String schema = DDLCommands.getSchema();
                         CommunicationProtocol respuesta = new CommunicationProtocol();

                         if(schema.equals("NULL")){
                             respuesta.setStatus("1046", "0");
                             respuesta.setFormat("default");
                             _json = respuesta.getReturnObj();
                             System.out.println(respuesta.getReturnObj());

                             return;
                         }
                        String[][] metadataVerif= newOperation.getMetaDataTable(schema,table1);
                         
                        ArrayList<String> verification= verifyColumn(metadataVerif, pColCondToSend);
                        
                        if (verification!= null) {
                            System.out.println("Entra");
                            respuesta.setStatus(verification.get(0), "0");
                             respuesta.setFormat("default");
                             _json = respuesta.getReturnObj();
                             System.out.println(respuesta.getReturnObj());
                             return;
                        }
                         

                        ArrayList<String[]> selected =newOperation.select(all,schema,table1,pColCondToSend,pDatosToSend,pOpToSend,condisLogicArr);

                        String[][] md = newOperation.getMetaDataTable(schema, table1);
                        
                        for (int j = 0; j < md[0].length; j++) {
                            System.out.println("Metadata"+md[0][j]);
                        }
                        
                        ArrayList<JSONArray> toSendJson = new ArrayList();
                        JSONArray array1 = new JSONArray();
                        for (int j = 0; j < md[0].length ; j++) { 
                            array1 = new JSONArray();
                            for (int k = 0; k < selected.size(); k++) {
                                array1.put(selected.get(k)[j]);
                                System.out.println("Selected " + selected.get(k)[j]);
                            }
                            toSendJson.add(array1);

                        }
                        

                        for (int j = 0; j < md[0].length; j++) {
                        respuesta.accumulateData(md[0][j] , toSendJson.get(j) ); 
                        }
                        respuesta.setStatus("0", "0");
                        respuesta.setFormat("default");
                        _json=respuesta.getReturnObj();
                        
                        
                        
                       
                        
                        return ;

                        
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
                            
                            
                            //System.out.println("Columns to Select"+pColCondToSend[0]);
                            String schema = DDLCommands.getSchema();
                            if (schema.equals("NULL")) {

                            }
                            String[][] metaDataVerification = newOperation.getMetaDataTable(schema, table1);
                            ArrayList<String> verifying=verifyColumn(metaDataVerification, coltoSelecttoSend);
                            if(verifying!=null){
                                CommunicationProtocol respuesta = new CommunicationProtocol();

                                respuesta.setStatus(verifying.get(0), "0");
                                respuesta.setFormat("default");
                                _json=respuesta.getReturnObj();
                                System.out.println(respuesta.getReturnObj());
                                return ;
                                
                            }  
                            if (pColCondToSend.length != 0) {
                                String[][] metadataToVerify = newOperation.getMetaDataTable(schema, table1);
                                ArrayList<String> verifyingColumns = verifyColumn(metadataToVerify, pColCondToSend);
                                System.out.println("Entra");       
                                
                                if (verifyingColumns != null) {
                                    CommunicationProtocol respuesta = new CommunicationProtocol();
                                    System.out.println("Verif");
                                    respuesta.setStatus(verifyingColumns.get(0), "0");
                                    respuesta.setFormat("default");
                                    _json = respuesta.getReturnObj();
                                    System.out.println(respuesta.getReturnObj());
                                    return;
                                }
                            }
                             System.out.println("Revisando EL"+
                                    newOperation.select(coltoSelecttoSend,schema,table1,
                                            pColCondToSend,pDatosToSend,pOpToSend,condisLogicArr).get(0)[0]);
                             
                             
                             ArrayList<String[]> ArrayListSelected=  newOperation.select(coltoSelecttoSend,schema,table1,
                                            pColCondToSend,pDatosToSend,pOpToSend,condisLogicArr);
                            String [][] md;
                            md=newOperation.getMetaDataTable(schema, table1);
                            
                            ArrayList<JSONArray> toSendJson = new ArrayList();
                            JSONArray array1 = new JSONArray();
                            for (int j = 0; j < ArrayListSelected.get(0).length ; j++) {
                                array1 = new JSONArray();
                                for (int k = 0; k < ArrayListSelected.size(); k++) {
                                    array1.put(ArrayListSelected.get(k)[j]);
                                    System.out.println("Selected " + ArrayListSelected.get(k)[j]);
                                    
                                }
                                toSendJson.add(array1);

                            }
                            CommunicationProtocol respuesta = new CommunicationProtocol();

                       // System.out.println("Printing size"+ toSendJson.size());
                            // System.out.println("Printing size 2"+ md[0].length);
                            for (int j = 0; j < coltoSelecttoSend.length; j++) {
                                respuesta.accumulateData(coltoSelecttoSend[j], toSendJson.get(j) ) ;
                            }
                            System.out.println(respuesta.getReturnObj());
                            
                            respuesta.setStatus("0", "0");
                            respuesta.setFormat("default");
                            _json=respuesta.getReturnObj();
                            
                            return ;
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
                
                

                //System.out.println("Columns to select2"+columnsToSelectArr2[0]);
                
                //System.out.println("Join El"+newOperation.selectJoin(columnsToSelectArr1, columnsToSelectArr2,
                // "TEC_DB", table1, table2, columnsJoinArr, columnasCondiciones, operadorCondiciones, 
                // datosCondiciones, condisLog, "").get(0)[0].getDate() );
                
                String schema = DDLCommands.getSchema();
                if (schema.equals("NULL")) {
                    CommunicationProtocol respuesta = new CommunicationProtocol();

                    respuesta.setStatus("1046", "0");
                    respuesta.setFormat("default");
                    _json = respuesta.getReturnObj();
                    return;
                }
                
                String[][] mDataTable1= newOperation.getMetaDataTable(schema, table1);
                
                String[][] mDataTable2= newOperation.getMetaDataTable(schema, table2);
                
                ArrayList<String> resultVerify1= verifyColumn(mDataTable1, columnsToSelectArr1);
                ArrayList<String> resultVerify2= verifyColumn(mDataTable2, columnsToSelectArr2);
                
                if(resultVerify1!=null){
                    CommunicationProtocol respuesta = new CommunicationProtocol();
                    respuesta.setStatus(resultVerify1.get(0), "0");
                    respuesta.setFormat("default");
                    _json = respuesta.getReturnObj();
                    System.out.println(respuesta.getReturnObj());
                    return ;
                }
                
                if(resultVerify2!=null){
                    
                    CommunicationProtocol respuesta = new CommunicationProtocol();
                    respuesta.setStatus(resultVerify2.get(0), "0");
                    respuesta.setFormat("default");
                    _json = respuesta.getReturnObj();
                    System.out.println(respuesta.getReturnObj());
                    return ;
                }
                
                System.out.println("Column to Select Array1"+columnsToSelectArr1[0]);
                
                System.out.println("Column to Select Array2"+columnsToSelectArr2.length);
                
                System.out.println("table 1"+table1);
                
                System.out.println("table 2"+table2);
                
                System.out.println("Columns Conditions" +columnasCondiciones.get(0));
                
                
                
                ArrayList<typeData[]> selectedJoin=newOperation.selectJoin(columnsToSelectArr1, columnsToSelectArr2,
                 schema, table1, table2, columnsJoinArr, columnasCondiciones, operadorCondiciones, 
                 datosCondiciones, condisLog, "");
                
                if(selectedJoin.size()==0||selectedJoin==null){
                    CommunicationProtocol respuesta = new CommunicationProtocol();
                    respuesta.setStatus("1072", "0");
                    respuesta.setFormat("default");
                    _json = respuesta.getReturnObj();
                    return ;
                }
                
                
                //System.out.println("Result"+ selectedJoin.get(0)[0].getDate());
                ArrayList<String[]> metadataTableSel= newOperation.metadataTableSelected;
                //array1.put("Pedro");
                CommunicationProtocol respuesta = new CommunicationProtocol();

                
                ArrayList<JSONArray> toSendJson= new ArrayList();
                JSONArray array1 = new JSONArray();
                
                
                for (int i = 0; i < metadataTableSel.get(0).length; i++) {
                    array1 = new JSONArray();

                    for (int j = 0; j < selectedJoin.size(); j++) {
                        array1.put(selectedJoin.get(j)[i].getDate());
                        System.out.println("Selected join"+selectedJoin.get(j)[i].getDate());              
                    }
                    toSendJson.add(array1);
                }
  
                    // System.out.println("Metadata"+metadataTableSel.get(0)[0]);
                    //System.out.println("Data to send"+toSendJson.get(0));
                /*for (int i = 0; i < toSendJson.get(0).length(); i++) {
                    try {
                        System.out.println("Printind data"+toSendJson.get(1).get(0).toString());
                    } catch (JSONException ex) {
                        Logger.getLogger(RuntimeDB.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }*/
                
                
                
                
                    for (int j = 0; j < metadataTableSel.get(0).length; j++) {
                        respuesta.accumulateData(metadataTableSel.get(0)[j], toSendJson.get(j) );

                    }
                    
                    System.out.println(respuesta.getReturnObj());
                    respuesta.setStatus("0", "0");
                    respuesta.setFormat("default");
                    _json= respuesta.getReturnObj();
                    
                    return ;
                    
              

                
                
            }
        }
     
    private  ArrayList<String> verifyColumn(String[][] metadata,String [] pColumntoCompare){
         if(metadata==null){
            ArrayList<String> errorDetected= new ArrayList<>();
            errorDetected.add("1146");
            
            return errorDetected;
        }
         
        if(pColumntoCompare.length==0){
             return null;
        }
         
        ArrayList<Boolean> verifyColumns = new ArrayList<>();
        for (int i = 0; i < pColumntoCompare.length; i++) {
            for (int j = 0; j < metadata[0].length; j++) {
                if (metadata[0][j].equals(pColumntoCompare[i])) {
                    verifyColumns.add(true);
                }
            }
        }
        
        if (verifyColumns.size()!= pColumntoCompare.length ){
            ArrayList<String[]> result = new ArrayList<>();
            ArrayList<String> errorDetected= new ArrayList<>();
            errorDetected.add("1072");
            return errorDetected;
            
        }
        return null;
         
     }
     
    public void reportedError(String pError,String type){
        CommunicationProtocol respuesta = new CommunicationProtocol();

        if(type.equals("lexer")){  
            System.out.println("lexer");
            respuesta.setStatus("900", "0");
            respuesta.setFormat("default");
            _json=respuesta.getReturnObj();

        }
        else {
            type.equals("parser");
            String[] verif=pError.split("\\(");
            
            if(verif[0].equals("MismatchedTokenException")){
                respuesta.setStatus("900", "0");
                respuesta.setFormat("default");
                _json=respuesta.getReturnObj();
                return ;
                
            }
            respuesta.setStatus("901", "0");
            respuesta.setFormat("default");
            _json=respuesta.getReturnObj();
            return ;
            
            
        }
            
    }
                
}
