/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RuntimeDBProcessor.commands.DDL;

import Runtime.Server.*;
import java.util.ArrayList;

/**
 *
 * @author Aaron Elizondo
 */
public class DDLParser {
    
    DDLCommands _ddl = new DDLCommands();
    private final int nCreateT = 4;
    
    public String parserSetDatabase(String pSchema){
        int i = _ddl.setDatabase(pSchema);
        CommunicationProtocol respuesta = new CommunicationProtocol();
        if(i==0){
            respuesta.setStatus("0", "0");
        }
        else{
            respuesta.setStatus(Integer.toString(Math.abs(i)), "0");
        }
        return respuesta.getReturnObj();
    }
    
    public String parserCreateTable(String pTable, String pPK, ArrayList<String> pCols){
        
        int largo = pCols.size();
        if(largo%nCreateT==0){
            int nCols = largo/nCreateT;
            String[] cols = new String[nCols];
            for(int i=0; i<nCols; i++){
                String col = pCols.get(i*nCreateT+1)+"-"+pCols.get(i*nCreateT+2)+"-"+pCols.get(i*nCreateT+3);
                cols[i] = col;
            }  
            int sal = _ddl.createTable(pTable, cols, pPK);
            CommunicationProtocol respuesta = new CommunicationProtocol();
            if(sal==0){
                respuesta.setStatus("0", "0");
            }
            else{
                respuesta.setStatus(Integer.toString(Math.abs(sal)), "0");
            }
            return respuesta.getReturnObj();
        }
        return null;
    }
    
    public String parserAlterTable(ArrayList<String> pDatos){
        int largo = pDatos.size();
        if(largo==nCreateT){
            int sal = _ddl.createAlterTable(pDatos.get(0), pDatos.get(1), pDatos.get(2), pDatos.get(3));
            CommunicationProtocol respuesta = new CommunicationProtocol();
            if(sal==0){
                respuesta.setStatus("0", "0");
            }
            else{
                respuesta.setStatus(Integer.toString(Math.abs(sal)), "0");
            }
            return respuesta.getReturnObj();
        }
        return null;
    }
    
    public String parserDropTable(String pTable){
        int i = _ddl.dropTable(pTable);
        CommunicationProtocol respuesta = new CommunicationProtocol();
        if(i==0){
            respuesta.setStatus("0", "0");
        }
        else{
            respuesta.setStatus(Integer.toString(Math.abs(i)), "0");
        }
        return respuesta.getReturnObj();
    }
    
}
