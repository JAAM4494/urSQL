/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RuntimeDBProcessor.commands.DML;

import Runtime.Server.CommunicationProtocol;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aaron Elizondo
 */
public class DMLParser {
    
    DMLCommands _dml = new DMLCommands();
    
    public String parserInsertInto(String pTable, List<String> pDatos, List<String> pCols){
        
        int largo = pDatos.size();
        int i;
        String[] datos = new String[largo];
        String[] cols = new String[largo];
        for(i=0; i<largo; i++){
            datos[i] = pDatos.get(i);
            cols[i] = pCols.get(i);
        }
        int sal = _dml.insert(pTable, cols, datos);
        CommunicationProtocol respuesta = new CommunicationProtocol();
        if(sal==0){
            respuesta.setStatus("0", "1");
        }
        else{
            respuesta.setStatus(Integer.toString(Math.abs(sal)), "0");
        }
        respuesta.setFormat("default");
        return respuesta.getReturnObj();

    }
    
    public String parserUpdate(String pTabla, String pCol, String pValor, ArrayList<String> pWhere){
        
        int largo = pWhere.size();
        int nElementos = (largo+1)/5;
        
        String[] datos = new String[nElementos];
        String[] cols = new String[nElementos];
        String[] opes = new String[nElementos];
        
        int[] condis;
        if (nElementos>0){
            condis = new int[nElementos-1];
        }
        else{
            condis = new int[]{};
        }
        
        int i;
        for(i=0; i<nElementos-1; i++){
            datos[i] = pWhere.get(i*5+1);
            opes[i] = pWhere.get(i*5+2);
            cols[i] = pWhere.get(i*5+3);
            if(pWhere.get(i*5+4).equals("AND")){
                condis[i] = 1;
            }
            else{
                condis[i] = 2;
            }
            
        }
        if(nElementos>0){
            datos[i] = pWhere.get(i*5+1);
            opes[i] = pWhere.get(i*5+2);
            cols[i] = pWhere.get(i*5+3);
        }
        
        int sal = _dml.updateTable(pCol, pValor, pTabla, cols, datos, opes, condis);
        CommunicationProtocol respuesta = new CommunicationProtocol();
        if(sal>=0){
            respuesta.setStatus("0", Integer.toString(Math.abs(sal)));
        }
        else{
            respuesta.setStatus(Integer.toString(Math.abs(sal)), "0");
        }
        respuesta.setFormat("default");
        return respuesta.getReturnObj();
    }
    
    public String parserDelete(String pTabla, ArrayList<String> pWhere){
        
        int largo = pWhere.size();
        int nElementos = (largo+1)/5;
        
        String[] datos = new String[nElementos];
        String[] cols = new String[nElementos];
        String[] opes = new String[nElementos];
        int[] condis;
        if (nElementos>0){
            condis = new int[nElementos-1];
        }
        else{
            condis = new int[]{};
        }
        int i;
        for(i=0; i<nElementos-1; i++){
            datos[i] = pWhere.get(i*5+1);
            opes[i] = pWhere.get(i*5+2);
            cols[i] = pWhere.get(i*5+3);
            if(pWhere.get(i*5+4).equals("AND")){
                condis[i] = 1;
            }
            else{
                condis[i] = 2;
            }
            
        }
        if(nElementos>0){
            datos[i] = pWhere.get(i*5+1);
            opes[i] = pWhere.get(i*5+2);
            cols[i] = pWhere.get(i*5+3);
        }
        int sal = _dml.deleteFrom(pTabla, cols, datos, opes, condis);
        CommunicationProtocol respuesta = new CommunicationProtocol();
        if(sal>=0){
            respuesta.setStatus("0", Integer.toString(Math.abs(sal)));
        }
        else{
            respuesta.setStatus(Integer.toString(Math.abs(sal)), "0");
        }
        respuesta.setFormat("default");
        return respuesta.getReturnObj();
    }
   
    
}
