package RuntimeDBProcessor.commands.CLP;
import RuntimeDBProcessor.commands.DDL.DDLCommands;
import StoredDataManager.TableOperations;
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
            DDLCommands ddl = new DDLCommands();
            typeData[] tp = {new VARCHAR(pDBName)};
            t.insert(Constants.DB, tp, false);
            ddl.createDatabase(pDBName);
            typeData[] r1 = {new VARCHAR("CREATE_DATABASE"), new VARCHAR(pDBName), 
                    new VARCHAR("Correct"), new NULL()};
            t.insert(Constants.HISTORY_CATALOG, r1, false);
            return 0;
        }
        
        typeData[] r_a = {new NULL(), new INTEGER("-1"), new VARCHAR("CREATE_DATABASE"), 
                new VARCHAR("La base de datos ya existe")};
        t.insert(Constants.LOG_ERRORS, r_a, true);
        typeData[] r1 = {new VARCHAR("CREATE_DATABASE"), new VARCHAR(pDBName), 
                new VARCHAR("Error"), new VARCHAR(Integer.toString(t.getTail()))};
        t.insert(Constants.HISTORY_CATALOG, r1, false);
        return -1;
        
    }
        
    public JSONObject DisplayDB(String pDBName){
            return null;
        }
        
    public int DropDatabase(String pDBName){
        
        TableOperations t = new TableOperations();
        if(t.borrarDatabase(pDBName)){
            typeData[] r1 = {new VARCHAR("DROP_DATABASE"), new VARCHAR(pDBName), 
                    new VARCHAR("Correct"), new NULL()};
            t.insert(Constants.HISTORY_CATALOG, r1, false);
            return 0;
        }
        typeData[] r_a = {new NULL(), new INTEGER("-1"), new VARCHAR("CREATE_DATABASE"), 
                new VARCHAR("La base de datos no existe")};
        t.insert(Constants.LOG_ERRORS, r_a, true);
        typeData[] r1 = {new VARCHAR("CREATE_DATABASE"), new VARCHAR(pDBName), 
                new VARCHAR("Error"), new VARCHAR(Integer.toString(t.getTail()))};
        t.insert(Constants.HISTORY_CATALOG, r1, false);
        return -1;//no estaba
        
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