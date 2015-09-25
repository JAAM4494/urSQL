package RuntimeDBProcessor.commands.CLP;
import StoredDataManager.TableOperations;
import java.io.File;
import org.json.*;
import urSQL.Constants.Constants;
import urSQL.tipos.INTEGER;
import urSQL.tipos.NULL;
import urSQL.tipos.VARCHAR;
import urSQL.tipos.typeData;


/**
 *
 * @author macbook
 */
public class CLPCommands {
    
    /**
     * Crea una nueva base de datos
     * @param pDBName
     * @return 0 si el proceso es satisfactorio
     */
    public int createDatabase(String pDBName){
        TableOperations t = new TableOperations();
        if(t.verificarDBRepetidas(pDBName)){
            //File theDir = new File(Constants.DATABASE+pDBName);
            //theDir.mkdir();
            typeData[] tp = {new VARCHAR(pDBName)};
            t.insert(Constants.DB, tp, false);
            typeData[] r1 = {new VARCHAR("CREATE_DATABASE"), new VARCHAR(pDBName), 
                    new VARCHAR("Correct")};
            t.insert(Constants.HISTORY_CATALOG, r1, false);
            String[] cols1 = {"tableFK-VARCHAR-NOT NULL", "colFK-VARCHAR-NOT NULL", "tableREF-VARCHAR-NOT NULL", "colREF-VARCHAR-NOT NULL"};
            String[] cols2 = {"Comando-VARCHAR-NOT NULL", "Argumento-VARCHAR-NOT NULL", "Estado-VARCHAR-NOT NULL"};
            String[] cols3 = {"Id-INTEGER-NOT NULL", "Error-VARCHAR-NOT NULL", "Comando-VARCHAR-NOT NULL", "Descrip-VARCHAR-NULL"};
            t.updateMETADATA(Constants.CONSTRAIT_CATALOG, pDBName, cols1, ""); 
            t.updateMETADATA(Constants.HISTORY_CATALOG, pDBName, cols2, "");
            t.updateMETADATA(Constants.LOG_ERRORS, pDBName, cols3, ""); 
            return 0;
        }
        
        typeData[] r_a = {new NULL(), new INTEGER("-1"), new VARCHAR("CREATE_DATABASE"), 
                new VARCHAR("La base de datos ya existe")};
        t.insert(Constants.LOG_ERRORS, r_a, true);
        typeData[] r1 = {new VARCHAR("CREATE_DATABASE"), new VARCHAR(pDBName), 
                new VARCHAR("Error "+Integer.toString(TableOperations.getTail()))};
        t.insert(Constants.HISTORY_CATALOG, r1, false);
        return -1007;
        
    }
        
    public JSONObject DisplayDB(String pDBName){
            return null;
        }
        
    public int DropDatabase(String pDBName){
        
        TableOperations t = new TableOperations();
        if(t.borrarDatabase(pDBName)){
            typeData[] r1 = {new VARCHAR("DROP_DATABASE"), new VARCHAR(pDBName), 
                    new VARCHAR("Correct")};
            t.insert(Constants.HISTORY_CATALOG, r1, false);
            return 0;
        }
        typeData[] r_a = {new NULL(), new INTEGER("-1008"), new VARCHAR("CREATE_DATABASE"), 
                new VARCHAR("La base de datos no existe")};
        t.insert(Constants.LOG_ERRORS, r_a, true);
        typeData[] r1 = {new VARCHAR("CREATE_DATABASE"), new VARCHAR(pDBName), 
                new VARCHAR("Error "+Integer.toString(TableOperations.getTail()))};
        t.insert(Constants.HISTORY_CATALOG, r1, false);
        return -1008;
        
    }
    
    public  JSONObject GetStatus(){
            return null;
        
        }
        
    public  JSONObject ListDB(){
            
            return null;
        }
        
    public JSONObject Start(){
            
            return null;
        }
        
    public JSONObject Stop(){
            return null;
            
        }      
   
}