/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RuntimeDBProcessor.commands.DDL;

import java.util.ArrayList;

/**
 *
 * @author Aaron Elizondo
 */
public class DDLParser {
    
    DDLCommands _ddl = new DDLCommands();
    private final int nCreateT = 4;
    
    public void parserSetDatabase(String pSchema){
        int i = _ddl.setDatabase(pSchema);
    }
    
    public void parserCreateTable(String pTable, String pPK, ArrayList<String> pCols){
        
        int largo = pCols.size();
        if(largo%nCreateT==0){
            int nCols = largo/nCreateT;
            String[] cols = new String[nCols];
            for(int i=0; i<nCols; i++){
                String col = pCols.get(i*nCreateT+1)+"-"+pCols.get(i*nCreateT+2)+"-"+pCols.get(i*nCreateT+3);
                cols[i] = col;
            }  
            int sal = _ddl.createTable(pTable, cols, pPK);
            System.out.println(sal);
        }
    }
    
    public void parserAlterTable(ArrayList<String> pDatos){
        int largo = pDatos.size();
        if(largo==nCreateT){
            int sal = _ddl.createAlterTable(pDatos.get(0), pDatos.get(1), pDatos.get(2), pDatos.get(3));
            System.out.println("sal");
        }
    }
    
    public void parserDropTable(String pTable){
        int sal = _ddl.dropTable(pTable);
        System.out.println(sal);
    }
    
}
