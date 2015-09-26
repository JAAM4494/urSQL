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
    
    private static String _schema = "NULA";
    private static String _schemaName = "NULA";
    /**
     * Establece el esquema en el que se van a ejecutar los comandos DDL
     * @param pSchemaName Esquema en el que se van a realizar los cambios
     * @return INT 0 cuando el proceso se efectua correcto, -1 cuando es incorrecto
     *            -1 cuando no existe el esquema 
     */
    public int setDatabase(String pSchemaName){
        
        TableOperations t = new TableOperations();
        if(!t.verificarDBRepetidas(pSchemaName)){
            _schemaName = pSchemaName;
            _schema = Constants.DATABASE+pSchemaName+"\\";
            typeData[] r1 = {new VARCHAR("SET_DATABASE"), new VARCHAR(pSchemaName), new VARCHAR("Correct")};
            t.insert(_schema+Constants.HISTORY_CATALOG, r1, false);
            return 0;//0 -> proceso correcto
        }
        else{
            typeData[] r = {new NULL(), new INTEGER("1008"), new VARCHAR("SET_DATABASE"), new VARCHAR("No existe la base de datos")};
            t.insert(Constants.LOG_ERRORS, r, true);
            return -1008;
        }
        
    }
    
    /**
     * 
     * @return el esquema con el cual se trabaja 
     */
    public static String getSchema(){
        return _schema;
    }

    /**
     * Crea una nueva tabla
     * @param pTable nombre de la nueva tabla
     * @param pColumnas columnas de la nueva tabla
     * @param pPrimary llave primaria de la nueva tabla
     * @return 0 -> proceso satisfactorio
     *        -1050 -> La tabla ya existe
     *        -1046 -> No ha seleccionado ninguna base de datos
     */
    public int createTable(String pTable, String[] pColumnas, String pPrimary){
        
        TableOperations t = new TableOperations();

        if (_schema.equals("NULA")){
            typeData[] r = {new NULL(), new INTEGER("-1046"), new VARCHAR("CREATE_TABLE"), 
                new VARCHAR("No ha seleccionado ninguna base de datos")};
            t.insert(Constants.DATABASE+Constants.LOG_ERRORS, r, true);//new VARCHAR(Integer.toString(t.getTail()))
            return -1046;
        }
        
        //se inserta en la metadata
        boolean bool = t.updateMETADATA(pTable, _schema, pColumnas, pPrimary);
        int salida = 0;
        
        //Si la tabla se inserta correctamente en la metadata
        if(bool){
            typeData[] r1 = {new VARCHAR("CREATE_TABLE"), new VARCHAR(pTable), new VARCHAR("Correct")};
            t.insert(_schema+Constants.HISTORY_CATALOG, r1, false);
        }
        
        //Sino existe es un error
        else{
            //PONER ERROR QUE ES EN VERDAD
            typeData[] r = {new NULL(), new INTEGER("-1050"), new VARCHAR("CREATE_TABLE"), new VARCHAR("La tabla ya existe")};
            t.insert(Constants.DATABASE+Constants.LOG_ERRORS, r, true);//new VARCHAR(Integer.toString(t.getTail()))
            typeData[] r1 = {new VARCHAR("CREATE_TABLE"), new VARCHAR(pTable), new VARCHAR("Error "+Integer.toString(TableOperations.getTail()))};
            t.insert(_schema+Constants.HISTORY_CATALOG, r1, false);
            salida = -1050;
        }
        //Inserta en el catalogo de historia
        typeData[] r2 = {new VARCHAR("PRIMARY_KEY"), new VARCHAR(pPrimary), new NULL()};
        t.insert(_schema+Constants.HISTORY_CATALOG, r2, false);
        typeData[] r3 = {new VARCHAR("COL"), new NULL(), new NULL()};
        int largo = pColumnas.length; 
        for(int i=0;i<largo;i++){
            r3[1] = new VARCHAR(pColumnas[i]);
            t.insert(_schema+Constants.HISTORY_CATALOG, r3, false);
        }
        return salida;
    }
    
    /**
     * Elimina una tabla de la metadata
     * @param pTable nombre de la tabla a eliminar
     * @return 0 -> proceso satisfactorio
     *        -1146 -> No estaba la tabla en la metadata
     *        -1046 -> No ha seleccionado ninguna base de datos
     */
    public int dropTable(String pTable){
        
        TableOperations t = new TableOperations();
        
        if (_schema.equals("NULA")){
            typeData[] r = {new NULL(), new INTEGER("-1046"), new VARCHAR("DROP_TABLE"), 
                new VARCHAR("No ha seleccionado ninguna base de datos")};
            t.insert(Constants.DATABASE+Constants.LOG_ERRORS, r, true);//new VARCHAR(Integer.toString(t.getTail()))
            return -1046;
        }
        
        boolean bool = t.deleteTableMetadata(pTable, _schema);
        if(bool){
            typeData[] r = {new VARCHAR("DROP_TABLE"), new VARCHAR(pTable), new VARCHAR("Correct")};
            t.insert(_schema+Constants.HISTORY_CATALOG, r, false);
            return 0;//0 -> proceso satisfactorio
        }
        else{
            typeData[] r_a = {new NULL(), new INTEGER("-1"), new VARCHAR("DROP_TABLE"), new VARCHAR("La tabla no estaba en la tabla de la metadata")};
            t.insert(Constants.DATABASE+Constants.LOG_ERRORS, r_a, true);//new VARCHAR(Integer.toString(t.getTail()))
            typeData[] r = {new VARCHAR("DROP_TABLE"), new VARCHAR(pTable), new VARCHAR("Error "+Integer.toString(TableOperations.getTail()))};
            t.insert(_schema+Constants.HISTORY_CATALOG, r, false);
            return -1146;//-1 -> No estaba la tabla en la metadata
        }

    }
       
    /**
     * Crea una nueva restricion(FK) en la tabla y columna seleccionada
     * @param pTable Tabla en la que se va hacer la FK
     * @param pFKColum Columna en la que se va a hacer un FK
     * @param pTableREF tabla a ser referenciada
     * @param pREFColum Columna referenciada
     * @return 0 -> proceso satisfactorio
     *        -1215 -> Existen datos en la columna FK que en la referenciada no
     *        -1072 -> Nombre de tabla o columa no existen de la tabla de REF
     *        -1046 -> No ha seleccionado ninguna base de datos
     */
    public int createAlterTable(String pTable, String pFKColum, String pTableREF, String pREFColum){
        
        int salida = 0;
        TableOperations t = new TableOperations(); 
         
        if (_schema.equals("NULA")){
            typeData[] r = {new NULL(), new INTEGER("-1046"), new VARCHAR("ALTER_TABLE"), 
                new VARCHAR("No ha seleccionado ninguna base de datos")};
            t.insert(Constants.DATABASE+Constants.LOG_ERRORS, r, true);
            return -1046;
        }
        
        int fk = t.findTableCol(pTable, pFKColum, _schema);
        int ref = t.findTableCol(pTableREF, pREFColum, _schema);
        
        if (fk==-1 || ref==-1){
            salida = -1146 ;//-3 -> Nombre de tabla o columa no existen de la tabla de FK
            typeData[] r_a = {new NULL(), new INTEGER("-1146 "), new VARCHAR("ALTER_TABLE"), 
            new VARCHAR("No existe la tabla")};
            t.insert(Constants.DATABASE+Constants.LOG_ERRORS, r_a, true);
        }
        
        if (fk==-2 || ref==-2){
            salida = -1072;//-3 -> Nombre de tabla o columa no existen de la tabla de FK
            typeData[] r_a = {new NULL(), new INTEGER("-1072"), new VARCHAR("ALTER_TABLE"), 
            new VARCHAR("No existe la columna")};
            t.insert(Constants.DATABASE+Constants.LOG_ERRORS, r_a, true);
        }
        if (fk==0 && ref==0){
            //Verifica la IR
            String[] str= {};int[] in = {};String[] col = {pFKColum};
            ArrayList<String[]> a1 = t.select(col, _schema, pTable, str, str, str, in);
            String[] col2 = {pREFColum};
            if(!a1.isEmpty()){
                ArrayList<String[]> a2 = t.select(col2, _schema, pTableREF, str, str, str, in);
                if(!a2.isEmpty()){
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
                            typeData[] r_a = {new NULL(), new INTEGER("-1215"), new VARCHAR("ALTER_TABLE"), 
                                new VARCHAR("No se puede crear la integridad referencial")};
                            t.insert(Constants.DATABASE+Constants.LOG_ERRORS, r_a, true);
                            salida = -1215;//-1 -> Existen datos en la columna FK que en la referenciada no
                            break;
                        }
                    }
                }
                else{

                    typeData[] r_a = {new NULL(), new INTEGER("-1215"), new VARCHAR("ALTER_TABLE"), 
                        new VARCHAR("No se puede crear la integridad referencial")};
                    t.insert(Constants.DATABASE+Constants.LOG_ERRORS, r_a, true);
                    salida = -1215;


                }
            }
        }
        if (salida==0){       
            typeData[] r1 = {new VARCHAR("ALTER_TABLE"), new VARCHAR(pTable), new VARCHAR("Correct")};
            t.insert(_schema+Constants.HISTORY_CATALOG, r1, false);     
            typeData[] value = {new VARCHAR(pTable), new VARCHAR(pFKColum), new VARCHAR(pTableREF),new VARCHAR(pREFColum)};
            t.insert(_schema+Constants.CONSTRAIT_CATALOG, value, false);
        }
        else{
            typeData[] r1 = {new VARCHAR("ALTER_TABLE"), new VARCHAR(pTable), new VARCHAR("Error "+Integer.toString(TableOperations.getTail()))};
            t.insert(_schema+Constants.HISTORY_CATALOG, r1, false);
            
        }
        
        typeData[] r2 = {new VARCHAR("ADD_CONSTRAINT"), new VARCHAR(pFKColum), new NULL()};
        t.insert(_schema+Constants.HISTORY_CATALOG, r2, false);        
        typeData[] r3 = {new VARCHAR("REFERENCES"), new VARCHAR(pTableREF+"."+pREFColum), new NULL()};
        t.insert(_schema+Constants.HISTORY_CATALOG, r3, false);                  
        
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
