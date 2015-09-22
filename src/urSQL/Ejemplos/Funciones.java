package urSQL.Ejemplos;

import java.io.File;
import org.mapdb.BTreeKeySerializer;
import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import urSQL.Constants.Constants;
import RuntimeDBProcessor.commands.DDL.Metadata;
import urSQL.tipos.typeData;

/**
 * @author Aaron Elizondo
 */
public class Funciones {
    
    
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
    
    static public void recorrerArchivo(String pName){
        File file = new File(Constants.DATABASE+pName);
        try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
            BTreeMap <Integer,typeData[]> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            
            int tail = primary.size();
         
            for(int i=0; i<tail; i++){
                typeData[] r = primary.ceilingEntry(i).getValue();
                int l = r.length;
                for(int j=0;j<l;j++){
                    System.out.print(r[j].getDate());
                    System.out.print(" | ");
                }
                System.out.println("");
            }
        }
            
            
    }
    
}
