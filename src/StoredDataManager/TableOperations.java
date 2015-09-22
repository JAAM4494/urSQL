package StoredDataManager;

import java.io.File;
import java.util.ArrayList;
import org.mapdb.BTreeKeySerializer;
import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import urSQL.Constants.Constants;
import RuntimeDBProcessor.commands.DDL.Metadata;
import urSQL.tipos.*;

/**
 * @author Aaron Elizondo
 */
public class TableOperations {
    
    private int _tail;
    
    public int getTail(){
        return _tail;
    }
    
    /**
     * Inserta un registro en una determinada tabla
     * @param pTable Tabla a insertar el registro
     * @param pValues Registro que se desea insertar
     * @param pFlag
     * @return boolean true: si el proceso se ejecuto satisfactoriamente, false en caso contrario
     */
    public boolean insert(String pTable, typeData[] pValues, boolean pFlag){
        File file = new File(Constants.DATABASE+pTable);
        try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
            BTreeMap <Integer,typeData[]> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            int tail = primary.size();
            _tail = tail;
            if(pFlag){
                pValues[0] = new VARCHAR(Integer.toString(tail));
            }
            primary.put(tail, pValues);
            thedb.commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    /**
     * Inserta un registro en de la tabla indicada
     * @param pSchema Esquema de la table en que se va insertar
     * @param pTable Table en la que se va a insertar el registro
     * @param pColumns String[] en la que vienen las columanas a insertar
     * @param pValues String[] con los valores de las columnas a insertar
     * @return 0 -> proceso satisfactorio
              -1 -> Error en la IR, el dato que se va a insertar no esta en la columna referenciada
              -2 -> no se encontro la tabla en la que se va a insertar
              -3 -> Error de la llave primaria el dato esta repetido
              -4 -> Error el dato no es del tipo correspondiente 1232->SQL
              -5 -> Error el dato no admite nulos 1048->SQL
              -6 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
     */
    public int insertINTO(String pSchema, String pTable, String[] pColumns, String[] pValues){
        
        //Verifica la IR
        if(!verificarFK(pSchema, pTable, pColumns, pValues)){
            return -1; //-1 -> Error en la IR, el dato que se va a insertar no esta en la columna referenciada
        }
        
        //Obtiene la metadata de la tabla
        String[][] metadata = getMetaDataTable(pSchema, pTable);
        
        if (metadata==null){
            return -2;//-2 -> no se encontro la tabla en la que se va a insertar
        }
        
        int largoC = pColumns.length;
        int largoDatos = metadata[0].length;
        typeData[] salida = new typeData[largoDatos];
        for (int i=0; i<largoDatos; i++){
            int j;
            for (j=0; j<largoC; j++){
                
                //Si es la columna en la que se va a insertar
                if (pColumns[j].equals(metadata[0][i])){        
                    
                    // si i es igual a 0, se trata de la PK por lo que se valida
                    if(i==0){
                        
                        String [] col = {pColumns[j]};
                        String [] datos = {pValues[j]};
                        String [] ope = {"="};
                        int [] condi = {};
                        //Se hace un select para verificar que no se repitan los datos
                        ArrayList<String[]> ar = select(col, pSchema, pTable, col, datos, ope, condi);
                        
                        if(!ar.isEmpty()){
                            return -3;//-3 -> Error de la llave primaria el dato esta repetido
                        }
                    }
                    
                    if(metadata[1][i].equals("INTEGER")){
                        salida[i] = new INTEGER(pValues[j]);
                    }
                    if(metadata[1][i].equals("VARCHAR")){
                        salida[i] = new VARCHAR(pValues[j]);
                    }
                    
                    //agregar los otros tipos
                    
                    if(salida[i].verificarTipo()){
                        break;
                    }
                    else{
                        return -4;//-4 -> Error el dato no es del tipo correspondiente 1232->SQL
                    }
                }
                
            }
            
            //Verifica que el dato acepte nulos, sino lanza un error
            if (j==largoC){
               
                if(metadata[2][i].equals("NULL")){
                    salida[i] = new NULL();
                }
                else{
                    return -5;//-5 -> Error el dato no admite nulos 1048->SQL
                }
                
            }
            
        }
        if(insert(pTable,salida,false)){
             return 0;//0 -> proceso satisfactorio
        }
        else{
            return -6;//-6 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
        }
       
        
        
    }
    
    /**
     * Verifica que un determinado registro cumpla con las condiciones a seleccionar
     * @param pRegistroDatos Registro que se va a comparar para ver si cumple con las condiciones
     * @param pRegistroCols Todas las columanas de la table
     * @param pColumnasCondiciones Columnas que se van a comparar
     * @param pDatosCondiciones Datos que se van a comparar con los del registro
     * @param pOpes operadores con los que se van a comparar los dato
     * @param pTipoCondiciones condiciones un 1 es un AND, un 2 un OR
     * @return un boolean true en caso de cumplir las condicones, false en caso contrario
     */
    public boolean where(typeData[] pRegistroDatos, String[] pRegistroCols, String[] pColumnasCondiciones,
            String[] pDatosCondiciones,String[] pOpes, int[] pTipoCondiciones){

    int nColumnas = pRegistroDatos.length;
    int nColumnasCondiciones = pColumnasCondiciones.length;

    //Si no hay datos para buscar
    if (nColumnasCondiciones == 0){
        return true;
    }

    boolean salida = true;
    boolean primeraIteracion = true;
    boolean condicionAnterior = false;
    boolean condicionActual = false;
    int k = 0;

    for (int i=0; (i<nColumnasCondiciones && salida); i++){

        for (int j=0; j<nColumnas; j++){
            //Si el nombre de la columnas es igual
            if(pRegistroCols[j].equals(pColumnasCondiciones[i])){
                //Si es la primera iteracion
                if (primeraIteracion){

                    //Si los datos cumplen con la condicion ya sea = <> > >= < <= la condicion es verdadera
                    boolean a = pRegistroDatos[j].verificarTipo(pDatosCondiciones[i]);
                    if (a && pRegistroDatos[j].comparar(pDatosCondiciones[i], pOpes[i])){
                        condicionAnterior = true;

                        //Si no hay mas condiciones, retorna true, ya que se cumplio
                        if (pTipoCondiciones.length==0){
                            salida = true;
                            break;
                        }

                    }
                    // Si los datos don diferentes
                    else{
                        condicionAnterior = false;

                        //Si solo hay una condicion, retorna false, ya que no se cumplio
                        if (pTipoCondiciones.length==0){
                            salida = false;
                            break;
                        }
                    }
                }

                //Si no es la primera iteracion
                else{
                    //Si los datos cumplen con la condicion ya sea = <> > >= < <= la condicion actual es verdadera
                    boolean a = pRegistroDatos[j].verificarTipo(pDatosCondiciones[i]);
                    condicionActual = (a && pRegistroDatos[j].comparar(pDatosCondiciones[i], pOpes[i]));

                    //Si la condicion es un AND
                    if (pTipoCondiciones[k++] == 1){

                        //si alguno de las dos condiciones es falsa, retorna false
                        if (!condicionAnterior){
                            salida = false;
                            break;
                        }
                        if(!condicionActual){
                            salida = false;
                            break;
                        }

                        //Sigue evaluando la demas condiciones
                        salida = true;
                        condicionAnterior = true;
                        continue;
                    }
                    //Si la condicion es un OR
                    else{

                        //Si alguna de las dos condiciones es verdadera, se sigue evaluando
                        if (condicionAnterior || condicionActual){
                            salida = true;
                            condicionAnterior = true;
                            continue;
                        }
                        //Si no el registro no cumple con las condiciones
                        salida = false;
                        break;
                    }
                }
                primeraIteracion = false;
            }
        }
    }
    return salida;
}
    
    public ArrayList<String[]> select(String[] pColSelect, String pSchema, String pTable, String[] pColumnasCondiciones,
            String[] pDatosCondiciones, String[] pOpes, int[] pTipoCondiciones){
        
        String[][] md = getMetaDataTable(pSchema, pTable);
        ArrayList<String[]> salida = new ArrayList<>();
        if (md!=null){
            File file = new File(Constants.DATABASE+pTable);
            try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
                BTreeMap <Integer,typeData[]> primary = thedb.treeMapCreate("pri")
                        .keySerializer(BTreeKeySerializer.INTEGER)
                        .makeOrGet();

                int tail = primary.size();
                
                if(pColSelect[0].equals("=")){
                    pColSelect = md[0];
                }

                for (int i=0; i<tail; i++){
                    typeData[] register = primary.ceilingEntry(i).getValue();
                    boolean w = where(register, md[0], pColumnasCondiciones, pDatosCondiciones, pOpes, pTipoCondiciones);
                    if(w){
 
                        int larDates = md[0].length;
                        int larCols = pColSelect.length;
                        String[] sal = new String[larCols];
                        for (int j=0; j<larCols; j++){    
                            int k;
                            for (k=0; k<larDates; k++){

                                if (pColSelect[j].equals(md[0][k])){
                                   sal[j] = register[k].getDate();
                                   break;
                                }

                            }
                            if (k==larDates){
                                sal[j] = "NULL";
                                //Aqui es que no se encuentra la col a seleccionar
                            }
                        }

                        salida.add(sal);
                    }

                }
                
                
                return salida;



            }
            catch(Exception e){
                System.out.println("n1");
                return salida;
            }
        }
        System.out.println("n2");
        return salida;
        
    }
    
    /**
     * Actualiza todos los registros que cumplan con las condiciones
     * @param pCol Columna a setear
     * @param pValor Nuevo valor a setear
     * @param pSchema Esquema en el que se va a trabajar
     * @param pTable Tabla en la que se va a trabajar
     * @param pColumnasCondiciones Columnas que se van a comparar
     * @param pDatosCondiciones Datos que se van a comparar con los del registro
     * @param pOpes operadores con los que se van a comparar los dato
     * @param pTipoCondiciones condiciones un 1 es un AND, un 2 un OR
     * @return Mayor a 0 -> Cantidad de registros actualizados
     *         -1 -> Error en la IR, el dato que se va a insertar no esta en la columna referenciada
     *         -2 -> Error de la llave primaria el dato esta repetido
     *         -3 -> Error la col a actualizar es referenciada en otra tabla
     *         -4 -> Error el dato no admite nulos 1048->SQL
     *         -5 -> Error el dato no es del tipo correspondiente 1232->SQL
     *         -6 -> No esta la columna
     *         -7 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
     *         -8 -> no se encontro la tabla en la que se va a insertar
     */
    public int update(String pCol, String pValor, String pSchema, String pTable, String[] pColumnasCondiciones,
            String[] pDatosCondiciones,String[] pOpes, int[] pTipoCondiciones){
        
        //Verifica la IR
        String[] pColumns = { pCol };
        String[] pValues = { pValor };
        if(!verificarFK(pSchema, pTable, pColumns, pValues)){
            return -1;//-1 -> Error en la IR, el dato que se va a insertar no esta en la columna referenciada
        }
        
        //obtiene la metadata de la tabla
        String[][] md = getMetaDataTable(pSchema, pTable);
           
        if (md!=null){
            
            //Verifica que la llave no se repita
            if(pCol.equals(md[0][0])){
                String [] col = {pCol};
                String [] datos = {pValor};
                String [] ope = {"="};
                int [] condi = {};
                if(!select(col, pSchema, pTable, col, datos, ope, condi).isEmpty()){
                    return -2;//-2 -> Error de la llave primaria el dato esta repetido
                }                           
            }
            
            if(!verificarREF(pSchema, pTable, pColumns)){
                System.out.println("Error FK");
                return -3; //-3 -> Error la col a actualizar es referenciada en otra tabla
            }
            
            File file = new File(Constants.DATABASE+pTable);
            try(DB thedb = DBMaker.fileDB(file).closeOnJvmShutdown().make()){
                BTreeMap <Integer,typeData[]> primary = thedb.treeMapCreate("pri")
                        .keySerializer(BTreeKeySerializer.INTEGER)
                        .makeOrGet();

                int tail = primary.size();
                
                int larDates = md[0].length;
                int j;
                for (j=0; j<larDates; j++){    
                    if(pCol.equals(md[0][j])){  
                        break;
                    }
                }
                int nR = 0;
                if (j!=larDates){

                    for (int i=0; i<tail; i++){
                        typeData[] register = primary.ceilingEntry(i).getValue();

                        boolean w = where(register, md[0], pColumnasCondiciones, pDatosCondiciones, pOpes, pTipoCondiciones);
                        if(w){

                            if(register[j].verificarTipo(pValor)){
                                if(pValor.equals("NULL")){
                                    if (md[2][j].equals("NOT NULL")){
                                        return -4;//-4 -> Error el dato no admite nulos 1048->SQL
                                    }
                                }
                                
                                register[j].setDate(pValor);
                                primary.replace(i, register);
                                thedb.commit();
                                nR++;
                            }
                            else{
                                return -5;//-5 -> Error el dato no es del tipo correspondiente 1232->SQL
                            }
                            
                        }

                    }
                    return nR;
                }
                else{
                    return -6;//-6 -> No esta la columna
                }

            }
            catch(Exception e){
                return -7;//-7 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
            }
        }
        return -8;//-8 -> no se encontro la tabla en la que se va a insertar
    }
    
    /**
     * Borra todos los registros que cumplan con las condiciones
     * @param pSchema esquema de la tabla a trabajar
     * @param pTable tabla en la que se va a trabajar
     * @param pColumnasCondiciones Columnas que se van a comparar
     * @param pDatosCondiciones Datos que se van a comparar con los del registro
     * @param pOpes operadores con los que se van a comparar los dato
     * @param pTipoCondiciones condiciones un 1 es un AND, un 2 un OR
     * @return  Mayor a 0 -> Cantidad de registros borrados
     *          -1 -> Error en la IR, el dato que se va a insertar no esta en la columna referenciada
     *          -2 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
     *          -3 -> no se encontro la tabla en la que se va a insertar
     */
    public int delete(String pSchema, String pTable, String[] pColumnasCondiciones,
            String[] pDatosCondiciones, String[] pOpes, int[] pTipoCondiciones){
        
        String[][] md = getMetaDataTable(pSchema, pTable);
        int nR=0;
        if (md!=null){

            if(!verificarREF(pSchema, pTable, md[0])){
                System.out.println("Error ref");
                return -1;//-1 -> Error en la IR, el dato que se va a insertar no esta en la columna referenciada
            }
            
            File file = new File(Constants.DATABASE+pTable);
            try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
                BTreeMap <Integer,typeData[]> primary = thedb.treeMapCreate("pri")
                        .keySerializer(BTreeKeySerializer.INTEGER)
                        .makeOrGet();

                int tail = primary.size();
                
                int larDates = md[0].length;
                typeData[] registerVacio = new typeData[larDates];
                for (int j=0; j<larDates; j++){    
                    registerVacio[j] = new NULL();
                }

                for (int i=0; i<tail; i++){
                    typeData[] dates = primary.ceilingEntry(i).getValue();
                    boolean w = where(dates, md[0], pColumnasCondiciones, pDatosCondiciones,pOpes, pTipoCondiciones);
                    if(w){
                        primary.replace(i, registerVacio);
                        thedb.commit();
                        nR++;
                    }
                }
                return nR;
                
            }
            catch(Exception e){
                return -2;//-2 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
            }
        }
        return -3;//-3 -> no se encontro la tabla en la que se va a insertar
    
    
    
    }
    
    private boolean verificarFK(String pSchema, String pTabla, String[] pColumnas, String[] pValores){
        
        String[] colSELECT = {"tableREF", "colREF"};
        String[] colCondis = {"tableFK", "colFK"};
        String[] datos = {pTabla, ""};
        String[] opes = {"=","="};
        int[] condis = {1};
   
        int largo =  pColumnas.length;
        for (int i=0; i<largo; i++){
            datos[1] = pColumnas[i];
            ArrayList<String[]> s = select(colSELECT, pSchema, Constants.CONSTRAIT_CATALOG, colCondis, datos, opes, condis);
            if(s.size()>0){

                String[] col = {s.get(0)[1]};
                String[] dato = {pValores[i]};
                String[] ope = {"="};
                int[] condi = {};
                ArrayList<String[]> s2 = select(col, pSchema, s.get(0)[0], col, dato, ope, condi);
                if(s2.isEmpty()){
                    return false;
                }
            }
        }
        return true;
        
    }
    
    private boolean verificarREF(String pSchema, String pTabla, String[] pColumnas){
        
        String[] colCondis = {"tableREF", "colREF"};
        String[] colSELECT = {"tableFK", "colFK"};
        String[] datos = {pTabla, ""};
        String[] opes = {"=","="};
        int[] condis = {1};
   
        int largo =  pColumnas.length;
        for (int i=0; i<largo; i++){
            datos[1] = pColumnas[i];
            ArrayList<String[]> s = select(colSELECT, pSchema, Constants.CONSTRAIT_CATALOG, colCondis, datos, opes, condis);
            if(!s.isEmpty()){
                return false;
            }
        }
        return true;
        
    }
    
    private String[][] getMetaDataTable(String pSchema, String pTable){
        
        ArrayList<Metadata> m = getMetaDataTable2(pSchema, pTable);
      
        if(m!=null){
            int l = m.size();
            String[][] salida = new String[3][l];
            for(int i=0; i<l ;i++){
                if(m.get(i)._typeData.equals("PK")){
           
                    salida[0][i] = salida[0][0];
                    salida[1][i] = salida[1][0];
                    salida[2][i] = salida[2][0];
                    salida[0][0] = m.get(i)._name;
                    salida[1][0] = m.get(i)._type;
                    salida[2][0] = m.get(i)._nullability;
                    continue;
                    
                }
                salida[0][i] = m.get(i)._name;
                salida[1][i] = m.get(i)._type;
                salida[2][i] = m.get(i)._nullability;
            } 
            return salida;
        }
        return null;
    }
    
    private ArrayList<Metadata> getMetaDataTable2(String pSchema, String pTable){
        File file = new File(Constants.DATABASE+pSchema);
        try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
            BTreeMap <Integer,Metadata> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            int tail = primary.size();
            for(int i=0;i<tail;i++){
                Metadata m = primary.ceilingEntry(i).getValue();
                if (m._typeData.equals("TABLE")){
                    if(m._name.equals(pTable)){
                        ArrayList<Metadata> cols = new ArrayList<>();
                        int j;
                        for(j=i+1;j<tail; j++){
                            Metadata m2 = primary.ceilingEntry(j).getValue();
                            if(m._id.equals(m2._id)){
                                cols.add(m2);
                            }
                            else{
                                return cols;
                            }
                        }
                        if(j==tail){
                            return cols;
                        }
                    }
                }
            }
            return null;
            //AQUI VA UN ERROR O MENSAJE DE QUE NO SE ENCONTRO LA TABLA 
            
        }
        catch(Exception e){
            return null;
            //AQUI VA UN ERROR O MENSAJE DE QUE NO SE ENCONTRO LA DATABASE
        }
    }

}

