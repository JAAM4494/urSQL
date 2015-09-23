/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RuntimeDBProcessor.parser;

import java.util.ArrayList;

/**
 *
 * @author macbook
 */
public class ParserProcessor {
    
    public ParserProcessor(String pScripts){ 
        String[] process = pScripts.split(";");
        
        ArrayList<String> mynewProcesses= new ArrayList<>() ;
        
        for (int i = 0; i < process.length; i++) {
            mynewProcesses.add(process[i]+";");
        }
        
        System.out.println("Printing process"+mynewProcesses.get(2));

        
        
        

        
        
        
        
    }
    
}
