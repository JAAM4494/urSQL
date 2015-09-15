

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
package StoredDataManager;

import RuntimeDBProcessor.commands.DDL.Constants;
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
public class Funciones {
    
    static public void recorrerArchivo(String pName){
        File file = new File(Constants.DATABASE+pName);
        try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
            BTreeMap <Integer,Register> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            int tail = primary.size();
         
            for(int i=0; i<tail; i++){
                String[] r = primary.ceilingEntry(i).getValue()._register;
                int l = r.length;
                for(int j=0;j<l;j++){
                    System.out.print(r[j]);
                    System.out.print("|||");
                }
                System.out.println("");
            }
        }
            
            
    }
    
    static public void recorrerArchivo2(String pName){
        File file = new File(Constants.DATABASE+pName);
        try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
            BTreeMap <Integer,Metadata> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            int tail = primary.size();
         
            for(int i=0; i<tail; i++){
                Metadata r = primary.ceilingEntry(i).getValue();
                System.out.println(r._id+"|"+r._typeData+"|"+r._name+"|"+r._type+"|"+r._nullability+"|");
            }
        }
            
            
    }
}
