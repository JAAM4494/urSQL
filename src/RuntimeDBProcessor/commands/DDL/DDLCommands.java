/*
 * Copyright 2015 Aaron Elizondo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package RuntimeDBProcessor.commands.DDL;

import StoredDataManager.Register;
import SystemCatalog.Metadata;
import java.io.File;
import org.mapdb.BTreeKeySerializer;
import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

/**
 *
 * @author Aaron Elizondo
 */
public class DDLCommands {
    
    public static boolean createPEsetDatabase(String pSchemaName){
        return createPE_aux(pSchemaName, "SET_DATABASE");
    }
    
    public static boolean createPEDropTable(String pTable){
        return createPE_aux(pTable, "DROP_TABLE");
    }
            
    public static boolean createPEConstrait(String pTable, String pFKColum, String pTableColumn){
        File file = new File(Constants.DATABASE+Constants.HISTORY_CATALOG);
        try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
            
            BTreeMap <Integer,Register> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            
            int tail = primary.size()-1;
            int planID=1;
            
            if(tail!=-1){
                String[] regiter = primary.ceilingEntry(tail).getValue()._register;
                planID = Integer.parseInt(regiter[0])+1;                
            }
            
            String [] r1 = {Integer.toString(planID), "ALTER_TABLE", pTable,"no"};
            primary.put(tail+1, new Register(r1));
            String [] r2 = {Integer.toString(planID), "ADD_CONSTRAINT", pFKColum,"no"};
            primary.put(tail+2, new Register(r2));
            String [] r3 = {Integer.toString(planID), "REFERENCES", pTableColumn,"no"};
            primary.put(tail+3, new Register(r3));
            
            thedb.commit();
            return true;
        }
        
        catch(Exception e){
            return false;
        }
    } 
    
    public static boolean createPEINDEX(String pTable, String pTableColumn){
        File file = new File(Constants.DATABASE+Constants.HISTORY_CATALOG);
        try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
            
            BTreeMap <Integer,Register> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            
            int tail = primary.size()-1;
            int planID=1;
            
            if(tail!=-1){
                String[] regiter = primary.ceilingEntry(tail).getValue()._register;
                planID = Integer.parseInt(regiter[0])+1;                
            }
            
            String [] r1 = {Integer.toString(planID), "CREATE_INDEX", pTable,"no"};
            primary.put(tail+1, new Register(r1));
            String [] r2 = {Integer.toString(planID), "ON", pTableColumn,"no"};
            primary.put(tail+2, new Register(r2));
            
            thedb.commit();
            return true;
        }
        
        catch(Exception e){
            return false;
        }
    } 
    
    public static boolean createTableMD(String pTable, String[] pColumnas, String pPrimary){
        
        File file = new File(Constants.DATABASE+Constants.HISTORY_CATALOG);
        try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
            
            BTreeMap <Integer,Register> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            
            int tail = primary.size()-1;
            int planID=1;
            
            if(tail!=-1){
                String[] regiter = primary.ceilingEntry(tail).getValue()._register;
                planID = Integer.parseInt(regiter[0])+1;                
            }
  
            String [] r = {Integer.toString(planID), "CREATE_TABLE", pTable,"si"};
            primary.put(tail+1, new Register(r));
            int largo = pColumnas.length;
            String [] r3 = {Integer.toString(planID), "PRIMARY_KEY", pPrimary,"si"};
            primary.put(tail+2, new Register(r3));
            thedb.commit();
            String[] r2 = {Integer.toString(planID),"COLUMN", "" ,"si"};
            for(int i=0;i<largo;i++){
                r2[2] = pColumnas[i];
                primary.put(tail+3+i, new Register(r2));
                thedb.commit();
            } 
            
            
            return true;
        }
        
        catch(Exception e){
            return false;
        }
    }
    
    public static boolean updateMETADATA(String pSchema, String pTable, String[] pColumnas, String pPrimary){
        File file = new File(Constants.DATABASE+pSchema);
        try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
            
            BTreeMap <Integer, Metadata> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            
            int tail = primary.size();
            int planID=1;
            
            if(tail>0){
                String regiter = primary.ceilingEntry(tail-1).getValue()._id;
                planID = Integer.parseInt(regiter)+1;                
            }
            
            String id = Integer.toString(planID);
                   
            primary.put(tail, new Metadata(id, "TABLE", pTable, "", ""));
            thedb.commit();
            
            
            int largo = pColumnas.length;
            for(int i=0;i<largo;i++){
                String col = pColumnas[i];
                String[] data = col.split("-");
                if(data[0].equals(pPrimary)){
                    primary.put(tail+i+1, new Metadata(id, "PK", data[0], data[1], data[2]));
                }
                else{
                    primary.put(tail+i+1, new Metadata(id, "COL", data[0], data[1], data[2]));
                }
                thedb.commit();
            }

            
            
            return true;
        } 
            
        catch(Exception e){
            return false;
        }
    }
    
    private static boolean createPE_aux(String pName, String pCommand){

        File file = new File(Constants.DATABASE+Constants.HISTORY_CATALOG);
        try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
            BTreeMap <Integer,Register> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            int tail = primary.size()-1;
            int planID=1;
            if(tail!=-1){
                String[] regiter = primary.ceilingEntry(tail).getValue()._register;
                planID = Integer.parseInt(regiter[0])+1;                
            }
            String [] r = {Integer.toString(planID), pCommand, pName,"no"};
            primary.put(tail+1, new Register(r));
            thedb.commit();
            return true;
        }
        
        catch(Exception e){
            return false;
        }
    }
    
}
