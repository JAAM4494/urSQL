package RuntimeDBProcessor.commands.DDL;

import java.util.ArrayList;
import java.util.Arrays;
import urSQL.Constants.Constants;
import StoredDataManager.TableOperations;
import urSQL.tipos.INTEGER;
import urSQL.tipos.NULL;
import urSQL.tipos.VARCHAR;
import urSQL.tipos.typeData;

/**
 * @author Aaron Elizondo
 */
public class DDLCommands {
    
    private static String _schema;
    
    /**
     * Establece el esquema en el que se van a ejecutar los comandos DDL
     * @param pSchemaName Esquema en el que se van a realizar los cambios
     * @return INT 0 cuando el proceso se efectua correcto, -1 cuando es incorrecto
     *            -1 cuando no existe el esquema 
     */
    public int setDatabase(String pSchemaName){
        
        TableOperations t = new TableOperations();
        if(!t.verificarDBRepetidas(pSchemaName)){
            _schema = pSchemaName;
            typeData[] r1 = {new VARCHAR("SET_DATABASE"), new VARCHAR(pSchemaName), new VARCHAR("Correct"), new NULL()};
            t.insert(Constants.HISTORY_CATALOG, r1, false);
            return 0;//0 -> proceso correcto
        }
        else{
            typeData[] r = {new NULL(), new INTEGER("-1"), new VARCHAR("SET_DATABASE"), new VARCHAR("No existe la base de datos")};
            t.insert(Constants.LOG_ERRORS, r, true);
            typeData[] r1 = {new VARCHAR("SET_DATABASE"), new VARCHAR(pSchemaName), new VARCHAR("Error"), new VARCHAR(Integer.toString(t.getTail()))};
            t.insert(Constants.HISTORY_CATALOG, r1, false);
            return -1;
        }
        
    }
    
    public String getSchema(){
        return _schema;
    }
    
    public void createDatabase(String pSchemaName){
        
        _schema = pSchemaName;
        String[] cols1 = {"tableFK-VARCHAR-NOT NULL", "colFK-VARCHAR-NOT NULL", "tableREF-VARCHAR-NOT NULL", "colREF-VARCHAR-NOT NULL"};
        String[] cols2 = {"Comando-VARCHAR-NOT NULL", "Argumento-VARCHAR-NOT NULL", "Estado-VARCHAR-NOT NULL", "Error-VARCHAR-NULL"};
        String[] cols3 = {"Id-INTEGER-NOT NULL", "Error-VARCHAR-NOT NULL", "Comando-VARCHAR-NOT NULL", "Descrip-VARCHAR-NULL"};
        TableOperations t = new TableOperations();
        t.updateMETADATA(Constants.CONSTRAIT_CATALOG, _schema, cols1, ""); 
        t.updateMETADATA(Constants.HISTORY_CATALOG, _schema, cols2, "");
        t.updateMETADATA(Constants.LOG_ERRORS, _schema, cols3, ""); 
        
    }
    
    /**
     * Crea una nueva tabla
     * @param pTable nombre de la nueva tabla
     * @param pColumnas columnas de la nueva tabla
     * @param pPrimary llave primaria de la nueva tabla
     * @return 0 -> proceso satisfactorio
     *        -1 -> no se cumplio con el formato para las columanas
     */
    public int createTable(String pTable, String[] pColumnas, String pPrimary){
        
        //se inserta en la metadata
        TableOperations t = new TableOperations();
        boolean bool = t.updateMETADATA(pTable, _schema, pColumnas, pPrimary);
        int salida = 0;
        
        //Si la tabla se inserta correctamente en la metadata
        if(bool){
            typeData[] r1 = {new VARCHAR("CREATE_TABLE"), new VARCHAR(pTable), new VARCHAR("Correct"), new NULL()};
            t.insert(Constants.HISTORY_CATALOG, r1, false);
        }
        //Sino existe es un error
        else{
            //PONER ERROR QUE ES EN VERDAD
            typeData[] r = {new NULL(), new INTEGER("-1"), new VARCHAR("CREATE_TABLE"), new VARCHAR("No se actualizo la metadata")};
            t.insert(Constants.LOG_ERRORS, r, true);//new VARCHAR(Integer.toString(t.getTail()))
            typeData[] r1 = {new VARCHAR("CREATE_TABLE"), new VARCHAR(pTable), new VARCHAR("Error"), new VARCHAR(Integer.toString(t.getTail()))};
            t.insert(Constants.HISTORY_CATALOG, r1, false);
            salida = -1;
        }
        //Inserta en el catalogo de historia
        typeData[] r2 = {new VARCHAR("PRIMARY_KEY"), new VARCHAR(pPrimary), new NULL(), new NULL()};
        t.insert(Constants.HISTORY_CATALOG, r2, false);
        typeData[] r3 = {new VARCHAR("COL"), new NULL(), new NULL(), new NULL()};
        int largo = pColumnas.length; 
        for(int i=0;i<largo;i++){
            r3[1] = new VARCHAR(pColumnas[i]);
            t.insert(Constants.HISTORY_CATALOG, r3, false);
        }
        return salida;
    }
    
    /**
     * Elimina una tabla de la metadata
     * @param pTable nombre de la tabla a eliminar
     * @return 0 -> proceso satisfactorio
     *        -1 -> No estaba la tabla en la metadata
     */
    public int dropTable(String pTable){
        
        TableOperations t = new TableOperations();
        boolean bool = t.deleteTableMetadata(pTable, _schema);
        if(bool){
            typeData[] r = {new VARCHAR("DROP_TABLE"), new VARCHAR(pTable), new VARCHAR("Correct"), new NULL()};
            t.insert(Constants.HISTORY_CATALOG, r, false);
            return 0;//0 -> proceso satisfactorio
        }
        else{
            typeData[] r_a = {new NULL(), new INTEGER("-1"), new VARCHAR("DROP_TABLE"), new VARCHAR("La tabla no estaba en la tabla de la metadata")};
            t.insert(Constants.LOG_ERRORS, r_a, true);//new VARCHAR(Integer.toString(t.getTail()))
            typeData[] r = {new VARCHAR("DROP_TABLE"), new VARCHAR(pTable), new VARCHAR("Error"), new VARCHAR(Integer.toString(t.getTail()))};
            t.insert(Constants.HISTORY_CATALOG, r, false);
            return -1;//-1 -> No estaba la tabla en la metadata
        }

    }
       
    /**
     * Crea una nueva restricion(FK) en la tabla y columna seleccionada
     * @param pTable Tabla en la que se va hacer la FK
     * @param pFKColum Columna en la que se va a hacer un FK
     * @param pTableREF tabla a ser referenciada
     * @param pREFColum Columna referenciada
     * @return 0 -> proceso satisfactorio
     *        -1 -> Existen datos en la columna FK que en la referenciada no
     *        -2 -> Nombre de tabla o columa no existen de la tabla de REF
     *        -3 -> Nombre de tabla o columa no existen de la tabla de FK
     */
    public int createAlterTable(String pTable, String pFKColum, String pTableREF, String pREFColum){
        
        int salida = 0;
        TableOperations t = new TableOperations(); 
        
        //Verifica la IR
        String[] str= {};int[] in = {};String[] col = {pFKColum};
        ArrayList<String[]> a1 = t.select(col, _schema, pTable, str, str, str, in);
        String[] col2 = {pREFColum};
        ArrayList<String[]> a2 = t.select(col2, _schema, pTableREF, str, str, str, in);
        if(!a1.isEmpty() && a1.size()>0 && a1.get(0).length == 1){
            if(!a2.isEmpty() && a2.size()>0 && a2.get(0).length == 1){
                int sizeA1 = a1.size();
                int sizeA2 = a2.size();
                for (int i=0;i<sizeA1;i++){
                    int j;
                    for (j=0;j<sizeA2;j++){
                        if(Arrays.equals(a1.get(i), a2.get(j))){
                            break;
                        }
                    }
                    if(j==sizeA2){
                        typeData[] r_a = {new NULL(), new INTEGER("-1"), new VARCHAR("ALTER_TABLE"), 
                            new VARCHAR("Existen datos en la columna "+pFKColum+", que en la referenciada no")};
                        t.insert(Constants.LOG_ERRORS, r_a, true);
                        salida = -1;//-1 -> Existen datos en la columna FK que en la referenciada no
                        break;
                    }
                }
            }
            else{
                salida = -2;//-2 -> Nombre de tabla o columa no existen de la tabla de REF
                typeData[] r_a = {new NULL(), new INTEGER("-3"), new VARCHAR("ALTER_TABLE"), 
                    new VARCHAR("Nombre de tabla o columa no existen de la tabla a referenciar")};
                t.insert(Constants.LOG_ERRORS, r_a, true);
            }
        }
        else{
            salida = -3;//-3 -> Nombre de tabla o columa no existen de la tabla de FK
            typeData[] r_a = {new NULL(), new INTEGER("-3"), new VARCHAR("ALTER_TABLE"), 
                new VARCHAR("Nombre de tabla o columa no existen de la tabla de en la la restriccion")};
            t.insert(Constants.LOG_ERRORS, r_a, true);
        }
        
        if (salida==0){       
            typeData[] r1 = {new VARCHAR("ALTER_TABLE"), new VARCHAR(pTable), new VARCHAR("Correct"), new NULL()};
            t.insert(Constants.HISTORY_CATALOG, r1, false);     
            typeData[] value = {new VARCHAR(pTable), new VARCHAR(pFKColum), new VARCHAR(pTableREF),new VARCHAR(pREFColum)};
            t.insert(Constants.CONSTRAIT_CATALOG, value, false);
        }
        else{
            typeData[] r1 = {new VARCHAR("ALTER_TABLE"), new VARCHAR(pTable), new VARCHAR("Error"), new VARCHAR(Integer.toString(t.getTail()))};
            t.insert(Constants.HISTORY_CATALOG, r1, false);
            
        }
        
        typeData[] r2 = {new VARCHAR("ADD_CONSTRAINT"), new VARCHAR(pFKColum), new NULL(), new NULL()};
        t.insert(Constants.HISTORY_CATALOG, r2, false);        
        typeData[] r3 = {new VARCHAR("REFERENCES"), new VARCHAR(pTableREF+"."+pREFColum), new NULL(), new NULL()};
        t.insert(Constants.HISTORY_CATALOG, r3, false);                  
        
        return salida;
          
    } 
    
    public boolean createIndex(String pTable, String pTableColumn){
        
        TableOperations t = new TableOperations();
        typeData[] r1 = {new VARCHAR("CREATE_INDEX"), new VARCHAR(pTable)};
        t.insert(Constants.INDEX_CATALOG, r1, false);
        typeData[] r2 = {new VARCHAR("ON"), new VARCHAR(pTableColumn)};
        t.insert(Constants.INDEX_CATALOG, r2, false);   
        return false;
        //Falta meterla en la tabla de index        
    } 
    
    
    
}
