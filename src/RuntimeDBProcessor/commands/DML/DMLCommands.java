package RuntimeDBProcessor.commands.DML;

import RuntimeDBProcessor.commands.DDL.DDLCommands;
import urSQL.Constants.Constants;
import StoredDataManager.TableOperations;
import urSQL.tipos.*;

/**
 * @author Aaron Elizondo
 */
public class DMLCommands {
    
    private final TableOperations _tableOp;
    private final DDLCommands _ddl = new DDLCommands();
    
    public DMLCommands(){
        _tableOp = new TableOperations();
    }

    /**
     * Inserta un registro en de la tabla indicada, ademas crea el plan de ejecucion, e inserta en el 
     * catalogo de historia
     * @param pTable Table en la que se va a insertar el registro
     * @param pColumns String[] en la que vienen las columanas a insertar
     * @param pValues String[] con los valores de las columnas a insertar
     * @return 0 -> proceso satisfactorio
              -1 -> Error en la IR, el dato que se va a insertar no esta en la columna referenciada FALTA
              -2 -> no se encontro la tabla en la que se va a insertar
              -3 -> Error de la llave primaria el dato esta repetido
              -4 -> Error el dato no es del tipo correspondiente 1232->SQL
              -5 -> Error el dato no admite nulos 1048->SQL
              -6 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
     */
    public int insert(String pTable, String[] pColumns, String[] pValues){ 
        System.out.println(_ddl.getSchema());
        int proceso = _tableOp.insertINTO(_ddl.getSchema(), pTable, pColumns, pValues);
        if(proceso==0){
            typeData[] r1 = {new VARCHAR("INSERT_INTO"), new VARCHAR(pTable), new VARCHAR("Correct"), new NULL()};
            _tableOp.insert(Constants.HISTORY_CATALOG, r1, false);
        }
        else{
            typeData[] r_a = {new NULL(), new INTEGER(Integer.toString(proceso)), new VARCHAR("INSERT_INTO"), 
                new VARCHAR("Revisar la descripcion del error en la documentacion")};
            _tableOp.insert(Constants.LOG_ERRORS, r_a, true);
            typeData[] r1 = {new VARCHAR("INSERT_INTO"), new VARCHAR(pTable), 
                new VARCHAR("Error"), new VARCHAR(Integer.toString(_tableOp.getTail()))};
            _tableOp.insert(Constants.HISTORY_CATALOG, r1, false);
        }
        
        int largo = pColumns.length;
        for(int i=0; i<largo; i++){
            typeData[] r2 = {new VARCHAR("COL"), new VARCHAR(pColumns[i]+"="+pValues[i]), new NULL(), new NULL()};
            _tableOp.insert(Constants.HISTORY_CATALOG, r2, false);
        }
        return proceso;
        
        
    }
    
    /**
     * Actualiza todos los registros que cumplan con las condiciones, y si cumple
     * realiza la actualizacion
     * @param pCol Columna a setear
     * @param pValor Nuevo valor a setear
     * @param pTable Tabla en la que se va a trabajar
     * @param pColumnasCondiciones Columnas que se van a comparar
     * @param pDatosCondiciones Datos que se van a comparar con los del registro
     * @param pOpes operadores con los que se van a comparar los dato
     * @param pTipoCondiciones condiciones un 1 es un AND, un 2 un OR
     * @return Mayor a 0 -> Cantidad de registros actualizados
     *         -1 -> Error en la IR, el dato que se va a actualizar no esta en la columna referenciada
     *         -2 -> Error de la llave primaria el dato esta repetido
     *         -3 -> Error la col a actualizar es referenciada en otra tabla
     *         -4 -> Error el dato no admite nulos 1048->SQL
     *         -5 -> Error el dato no es del tipo correspondiente 1232->SQL
     *         -6 -> No esta la columna
     *         -7 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
     *         -8 -> no se encontro la tabla en la que se va a insertar
     */
    public int updateTable(String pCol, String pValor, String pTable, String[] pColumnasCondiciones,
            String[] pDatosCondiciones,String[] pOpes, int[] pTipoCondiciones){
        
        int salida = _tableOp.update(pCol, pValor, _ddl.getSchema(), pTable, pColumnasCondiciones, pDatosCondiciones, pOpes, pTipoCondiciones);
        if (salida>0){
            typeData[] r1 = {new VARCHAR("UPDATE"), new VARCHAR(pTable), new VARCHAR("Correct"), new NULL()};
             _tableOp.insert(Constants.HISTORY_CATALOG, r1, false);
        }
        else{
            typeData[] r_a = {new NULL(), new INTEGER(Integer.toString(salida)), new VARCHAR("UPDATE"), 
                new VARCHAR("Revisar la descripcion del error en la documentacion")};
            _tableOp.insert(Constants.LOG_ERRORS, r_a, true);//new VARCHAR(Integer.toString(t.getTail()))
            typeData[] r1 = {new VARCHAR("UPDATE"), new VARCHAR(pTable), 
            new VARCHAR("Error"), new VARCHAR(Integer.toString(_tableOp.getTail()))};
            _tableOp.insert(Constants.HISTORY_CATALOG, r1, false);
        }
        typeData[] r2 = {new VARCHAR("SET"), new VARCHAR(pCol+"="+pValor), new NULL(), new NULL()};
        _tableOp.insert(Constants.HISTORY_CATALOG, r2, false);
        updateWhere(pColumnasCondiciones, pDatosCondiciones, pOpes, pTipoCondiciones);
        return salida;
    }
    
    /**
     * Borra todos los registros que cumplan con las condiciones
     * @param pTable tabla en la que se va a trabajar
     * @param pColumnasCondiciones Columnas que se van a comparar
     * @param pDatosCondiciones Datos que se van a comparar con los del registro
     * @param pOpes operadores con los que se van a comparar los dato
     * @param pTipoCondiciones condiciones un 1 es un AND, un 2 un OR
     * @return  Mayor a 0 -> Cantidad de registros borrados
     *          -1 -> Error en la IR,posee columnas referenciadas
     *          -2 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
     *          -3 -> no se encontro la tabla en la que se va a borrar
     */
    public int deleteFrom(String pTable, String[] pColumnasCondiciones,
            String[] pDatosCondiciones,String[] pOpes, int[] pTipoCondiciones){
        
        int salida = _tableOp.delete(_ddl.getSchema(), pTable, pColumnasCondiciones, pDatosCondiciones, pOpes, pTipoCondiciones);
        if (salida>0){
            typeData[] r1 = {new VARCHAR("DELETE"), new NULL(), new VARCHAR("Correct"), new NULL()};
             _tableOp.insert(Constants.HISTORY_CATALOG, r1, false);
        }
        else{
            typeData[] r_a = {new NULL(), new INTEGER(Integer.toString(salida)), new VARCHAR("DELETE"), 
                new VARCHAR("Revisar la descripcion del error en la documentacion")};
            _tableOp.insert(Constants.LOG_ERRORS, r_a, true);
            typeData[] r1 = {new VARCHAR("DELETE"), new NULL(), 
            new VARCHAR("Error"), new VARCHAR(Integer.toString(_tableOp.getTail()))};
            _tableOp.insert(Constants.HISTORY_CATALOG, r1, false);
        }
        
        typeData[] r2 = {new VARCHAR("FROM"), new VARCHAR(pTable)};
        _tableOp.insert(Constants.HISTORY_CATALOG, r2, false);
        updateWhere(pColumnasCondiciones, pDatosCondiciones, pOpes, pTipoCondiciones);
        return salida;
    }
    
    /**
     * Actualiza el catalogo de historia
     * @param pColumnasCondiciones Columnas que se van a comparar
     * @param pDatosCondiciones Datos que se van a comparar con los del registro
     * @param pOpes operadores con los que se van a comparar los dato
     * @param pTipoCondiciones condiciones un 1 es un AND, un 2 un OR
     */
    private void updateWhere(String[] pColumnasCondiciones, String[] pDatosCondiciones,
            String[] pOpes, int[] pTipoCondiciones) {
        
        int largo = pColumnasCondiciones.length;
        if (largo>0){
            typeData[] r1 = {new VARCHAR("WHERE"), new VARCHAR(pColumnasCondiciones[0]+pOpes[0]+pDatosCondiciones[0]), new NULL(), new NULL()};
            _tableOp.insert(Constants.HISTORY_CATALOG, r1, false);
            for (int i=1;i<largo;i++){
                if (pTipoCondiciones[i-1]==1){
                    typeData[] r2 = {new VARCHAR("AND"), new VARCHAR(pColumnasCondiciones[i]+pOpes[i]+pDatosCondiciones[i]), new NULL(), new NULL()};
                    _tableOp.insert(Constants.HISTORY_CATALOG, r2, false);
                }
                else{
                   typeData[] r2 = {new VARCHAR("OR"), new VARCHAR(pColumnasCondiciones[i]+pOpes[i]+pDatosCondiciones[i]), new NULL(), new NULL()};
                    _tableOp.insert(Constants.HISTORY_CATALOG, r2, false); 
                }
            }
                
        }
    }
    
    
}
