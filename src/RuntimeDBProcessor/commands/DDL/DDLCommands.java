//2 NOTAS
package RuntimeDBProcessor.commands.DDL;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.mapdb.BTreeKeySerializer;
import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import urSQL.Constants.Constants;
import StoredDataManager.TableOperations;
import urSQL.tipos.NULL;
import urSQL.tipos.VARCHAR;
import urSQL.tipos.typeData;

/**
 * @author Aaron Elizondo
 */
public class DDLCommands {
    
    private String _schema;
    
    /**
     * Establece el esquema en el que se van a ejecutar los comandos DDL
     * @param pSchemaName Esquema en el que se van a realizar los cambios
     * @return INT 0 cuando el proceso se efectua correcto, -1 cuando es incorrecto
     */
    public int setDatabase(String pSchemaName){
        
        //NOTA: VERIFICAR QUE EL ESQUEMA EXISTE
        _schema = pSchemaName;
        TableOperations t = new TableOperations();
        typeData[] r1 = {new VARCHAR("SET_DATABASE"), new VARCHAR(pSchemaName), new VARCHAR("Correct"), new NULL()};
        t.insert(Constants.HISTORY_CATALOG, r1, false);
        return 0;//0 -> proceso correcto
        
    }
    
    public void createDatabase(){
        
        /* ESTE METODO VA EN LOS DE EDWIN */
        String[] cols = {"tableFK-VARCHAR-NOT NULL", "colFK-VARCHAR-NOT NULL", "tableREF-VARCHAR-NOT NULL", "colREF-VARCHAR-NOT NULL"};
        String[] cols2 = {"Comando-VARCHAR-NOT NULL", "Argumento-VARCHAR-NOT NULL", "Estado-VARCHAR-NOT NULL", "Error-VARCHAR-NULL"};
        updateMETADATA(Constants.CONSTRAIT_CATALOG, cols, ""); 
        updateMETADATA(Constants.HISTORY_CATALOG, cols2, ""); 
        //Agregar la de index
        
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
        boolean bool = updateMETADATA(pTable, pColumnas, pPrimary);
        int salida = 0;
        TableOperations t = new TableOperations();
        
        //Si la tabla se inserta correctamente en la metadata
        if(bool){
            typeData[] r1 = {new VARCHAR("CREATE_TABLE"), new VARCHAR(pTable), new VARCHAR("Correct"), new NULL()};
            t.insert(Constants.HISTORY_CATALOG, r1, false);
        }
        //Sino existe es un error
        else{
            //PONER ERROR QUE ES EN VERDAD
            typeData[] r1 = {new VARCHAR("CREATE_TABLE"), new VARCHAR(pTable), new VARCHAR("Error"), new VARCHAR("# Error")};
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
        
        boolean bool = deleteTableMetadata(pTable);
        TableOperations t = new TableOperations();
        if(bool){
            typeData[] r = {new VARCHAR("DROP_TABLE"), new VARCHAR(pTable), new VARCHAR("Correct"), new NULL()};
            t.insert(Constants.HISTORY_CATALOG, r, false);
            return 0;//0 -> proceso satisfactorio
        }
        else{
                        typeData[] r = {new VARCHAR("DROP_TABLE"), new VARCHAR(pTable), new VARCHAR("Error"), new VARCHAR("# Error")};
            t.insert(Constants.HISTORY_CATALOG, r, false);
            return -1;//-1 -> No estaba la tabla en la metadata
        }

    }
       
    /**
     * Crea una nueva restricion(FK) en la tabla y columna seleccionada
     * @param pTable Tabla en la que se va hacer la FK
     * @param pFKColum Columna en la que se va a hacer un FK
     * @param pTableColumn Tabla y columna que van a ser referenciadas
     * @return 0 -> proceso satisfactorio
     *        -1 -> Existen datos en la columna FK que en la referenciada no
     *        -2 -> Nombre de tabla o columa no existen de la tabla de REF
     *        -3 -> Nombre de tabla o columa no existen de la tabla de FK
     *        -4 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
     */
    public int createAlterTable(String pTable, String pFKColum, String pTableColumn){
        
        int salida = 0;
        TableOperations t = new TableOperations(); 
        String[] ptc = pTableColumn.split("_");
        
        //Verifica la IR
        String[] str= {};int[] in = {};String[] col = {pFKColum};
        ArrayList<String[]> a1 = t.select(col, _schema, pTable, str, str, str, in);
        String[] col2 = {ptc[1]};
        ArrayList<String[]> a2 = t.select(col2, _schema, ptc[0], str, str, str, in);
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
                        salida = -1;//-1 -> Existen datos en la columna FK que en la referenciada no
                        break;
                    }
                }
            }
            else{
                salida = -2;//-2 -> Nombre de tabla o columa no existen de la tabla de REF
            }
        }
        else{
            salida = -3;//-3 -> Nombre de tabla o columa no existen de la tabla de FK
        }
        
        if (salida==0){       
            typeData[] r1 = {new VARCHAR("ALTER_TABLE"), new VARCHAR(pTable), new VARCHAR("Correct"), new NULL()};
            t.insert(Constants.HISTORY_CATALOG, r1, false);       
        }
        else{
            typeData[] r1 = {new VARCHAR("ALTER_TABLE"), new VARCHAR(pTable), new VARCHAR("Error"), new VARCHAR(Integer.toString(salida))};
            t.insert(Constants.HISTORY_CATALOG, r1, false);    
        }
        
        typeData[] r2 = {new VARCHAR("ADD_CONSTRAINT"), new VARCHAR(pFKColum), new NULL(), new NULL()};
        t.insert(Constants.HISTORY_CATALOG, r2, false);        
        typeData[] r3 = {new VARCHAR("REFERENCES"), new VARCHAR(pTableColumn), new NULL(), new NULL()};
        t.insert(Constants.HISTORY_CATALOG, r3, false);                  

        typeData[] value = {new VARCHAR(pTable), new VARCHAR(pFKColum), new VARCHAR(ptc[0]),new VARCHAR(ptc[1])};
        if (!t.insert(Constants.CONSTRAIT_CATALOG, value, false)){
            salida = -4;//-4 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
        }
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
    
    /**
     * Inserta una nueva tabla en la metadata de la base
     * @param pTable nombre de la tablas
     * @param pColumnas Cnombres de las columnas de la tabla
     * @param pPrimary nombre de la columna que es PK
     * @return true si se inserta de forma satisfactoria, false en caso contrario
     */
    private boolean updateMETADATA(String pTable, String[] pColumnas, String pPrimary){
        
        File file = new File(Constants.DATABASE+_schema);
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
     
    /**
     * Borra una tabla de la metadata del esquema en el cual se trabaja
     * @param pTable tabla que se desea borrar
     * @return true si se borra de forma satisfactoria, false en caso contrario
     */
    public boolean deleteTableMetadata(String pTable){
        
        File file = new File(Constants.DATABASE+_schema);
        try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
            
            BTreeMap <Integer, Metadata> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            
            String plan = "NULO";
            int tail = primary.size();
            int i;
            for(i=0;i<tail;i++){
                if(primary.ceilingEntry(i).getValue()._name.equals(pTable)){
                    plan = primary.ceilingEntry(i).getValue()._id;
                    break;
                }
            }
            //NOTA: QUE NO SE PUEDAN BORRAR LOS PRIMEROS CUATRO QUE SON DE LOS CATALOGOS
            if (!plan.equals("NULO")){
                
                String planActual=plan;
                for(int j=i;j<tail;j++){
                    
                    plan = primary.ceilingEntry(j).getValue()._id;
                    if(plan.equals(planActual)){
                        primary.remove(j);
                        thedb.commit();
                    }
                    else{
                        break;
                    }
                }
                
            }
            else{
                return false;
            }
            
        
        }
        
        return true;
    
    }
    
}
