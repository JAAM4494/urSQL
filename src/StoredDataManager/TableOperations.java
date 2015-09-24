package StoredDataManager;

import java.io.File;
import java.util.ArrayList;
import org.mapdb.BTreeKeySerializer;
import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import urSQL.Constants.Constants;
import SystemCatalog.Metadata;
import urSQL.tipos.*;

/**
 * @author Aaron Elizondo
 */
public class TableOperations {
    
    private static int _tail;
    
    public static int getTail(){
        return _tail;
    }
    String[][] metadataTableSelected; 
    String[][] metadataTable1;
    String[][] metadataTable2;
    /**
     * Inserta un registro en una determinada tabla
     * @param pTable Tabla a insertar el registro
     * @param pValues Registro que se desea insertar
     * @param pFlag
     * @return boolean true: si el proceso se ejecuto satisfactoriamente, false en caso contrario
     */
    public boolean insert(String pTable, typeData[] pValues, boolean pFlag){
        File file = new File(Constants.DATABASE+pTable);
        try(DB thedb = DBMaker.fileDB(file).closeOnJvmShutdown().make()){
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
              -1216 -> Error en la IR, el dato que se va a insertar no esta en la columna referenciada
              -1146 -> no se encontro la tabla en la que se va a insertar 
              -1068 -> Error de la llave primaria el dato esta repetido
              -1232 -> Error el dato no es del tipo correspondiente
              -1048 -> Error el dato no admite nulos
              -1637 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
     */
    public int insertINTO(String pSchema, String pTable, String[] pColumns, String[] pValues){
        
        //Verifica la IR
        if(!verificarFK(pSchema, pTable, pColumns, pValues)){
            typeData[] r_a = {new NULL(), new INTEGER("1216"), new VARCHAR("INSERT_INTO"), 
                new VARCHAR("Error en la IR, el dato que se va a insertar no esta en la columna referenciada")};
            insert(Constants.LOG_ERRORS, r_a, true);
            return -1216; //-1216 -> Error en la IR, el dato que se va a insertar no esta en la columna referenciada
        }
        
        //Obtiene la metadata de la tabla
        String[][] metadata = getMetaDataTable(pSchema, pTable);
        
        if (metadata==null){
            typeData[] r_a = {new NULL(), new INTEGER("1146"), new VARCHAR("INSERT_INTO"), 
                new VARCHAR("La tabla no existe")};
            insert(Constants.LOG_ERRORS, r_a, true);
            return -1146;//-1146 -> No se encontro la tabla en la que se va a insertar
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
                            typeData[] r_a = {new NULL(), new INTEGER("1068 "), new VARCHAR("INSERT_INTO"), 
                                new VARCHAR("Error de la llave primaria el dato esta repetido")};
                            insert(Constants.LOG_ERRORS, r_a, true);
                            return -1068 ;//-3 -> Error de la llave primaria el dato esta repetido
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
                        typeData[] r_a = {new NULL(), new INTEGER("1232"), new VARCHAR("INSERT_INTO"), 
                            new VARCHAR("Error el dato no es del tipo correspondiente")};
                        insert(Constants.LOG_ERRORS, r_a, true);
                        return -1232;//Error el dato no es del tipo correspondiente 1232->SQL
                    }
                }
                
            }
            
            //Verifica que el dato acepte nulos, sino lanza un error
            if (j==largoC){
               
                if(metadata[2][i].equals("NULL")){
                    salida[i] = new NULL();
                }
                else{
                    typeData[] r_a = {new NULL(), new INTEGER("1048"), new VARCHAR("INSERT_INTO"), 
                        new VARCHAR("Error el dato no admite nulos")};
                    insert(Constants.LOG_ERRORS, r_a, true);
                    return -1048;//Error el dato no admite nulos 1048->SQL
                }
                
            }
            
        }
        if(insert(pTable,salida,false)){
             return 0;//0 -> proceso satisfactorio
        }
        else{
            typeData[] r_a = {new NULL(), new INTEGER("1637"), new VARCHAR("INSERT_INTO"), 
                new VARCHAR("Error al intentar abrir el achivo, puede que este dañado o concurrencia")};
            insert(Constants.LOG_ERRORS, r_a, true);
            return -1637;//Error al intentar abrir el achivo, puede que este dañado o concurrencia
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
    
    int h;
    for(h=0; h<nColumnas; h++){
        if(!pRegistroDatos[h].getDate().equals("NULL")){
            break;
        }
    }
    if (h==nColumnas){
        return false;
    }
    
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
            try(DB thedb = DBMaker.fileDB(file).closeOnJvmShutdown().make()){
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
                                return new ArrayList<>();
                                //sal[j] = "NULL";
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
    
    
     public BTreeMap <Integer,typeData[]> joinLogic(BTreeMap<Integer,typeData[]> pDatosTable1, 
            BTreeMap<Integer,typeData[]> pDatosTable2, int pColumnaCondicionPos1,int pColumnaCondicionPos2 , ArrayList<ArrayList<Integer>> ColumnsToSelect, ArrayList<ArrayList<String>> typesToSelect,DB thedb){
        
        BTreeMap <Integer,typeData[]> tmp = thedb.treeMapCreate("tmp").keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
        int tail;
        int backupInt=0;
        Boolean insertedFlag=false;
        
        String[] columnsSelectedTable=new String[ColumnsToSelect.get(0).size()+ColumnsToSelect.get(1).size()];
        
        String[] typesSelectedTable=new String[typesToSelect.get(0).size()+typesToSelect.get(1).size() ];
        
        System.out.println("size 1:"+typesToSelect.get(0).size());
        
        System.out.println("size 2:"+typesToSelect.get(1).size());

        
        int sizeColSelected=0;
        
        int sizeTypesSelected=0;
        

         for (int i = 0; i < metadataTable1[0].length; i++) {
                for (int j = 0; j < ColumnsToSelect.get(0).size(); j++) {
                    if (i == ColumnsToSelect.get(0).get(j)) {
                        columnsSelectedTable[sizeColSelected] = metadataTable1[0][i];
                        sizeColSelected++;
                    }
                }
         }

         for (int i = 0; i < metadataTable2[0].length; i++) {
                for (int j = 0; j < ColumnsToSelect.get(1).size(); j++) {
                    if (i == ColumnsToSelect.get(1).get(j)) {
                        columnsSelectedTable[sizeColSelected] = metadataTable2[0][i];
                        sizeColSelected++;
                    }
                }
         }
         
        
        for (int i = 0; i < pDatosTable2.size(); i++) {
            for (int j = 0; j <pDatosTable1.size() ; j++) {
                    if(pDatosTable1.ceilingEntry(j).getValue()[pColumnaCondicionPos1].getDate().equals(pDatosTable2.ceilingEntry(i).getValue()[pColumnaCondicionPos2].getDate())){
                        tail=tmp.size();
                        ArrayList<String> tmpRegister= new ArrayList<>();    
                         
                        for (int k = 0; k < ColumnsToSelect.get(0).size(); k++) {
                            tmpRegister.add(pDatosTable1.ceilingEntry(j).getValue()[ColumnsToSelect.get(0).get(k)].getDate());
                        }
                        
                        for (int k = 0; k < ColumnsToSelect.get(1).size(); k++) {
                            tmpRegister.add(pDatosTable2.ceilingEntry(i).getValue()[ColumnsToSelect.get(1).get(k)].getDate());

                        }
                        //System.out.println("Register with Select"+tmpRegister.get(2));
                        
                        typeData[] myTypeData= new typeData[tmpRegister.size()];
                            

                        for (int k = 0; k <ColumnsToSelect.get(0).size(); k++) {
                            
                            if (typesToSelect.get(0).get(k).equals("VARCHAR")) {
                                myTypeData[k] = new VARCHAR(tmpRegister.get(k));
                                typesSelectedTable[sizeTypesSelected]="VARCHAR";
                                sizeTypesSelected++;
                            }
                     
                            else if (typesToSelect.get(0).get(k).equals("INTEGER")) {
                                myTypeData[k] = new INTEGER(tmpRegister.get(k));
                                typesSelectedTable[sizeTypesSelected]="INTEGER";
                                sizeTypesSelected++;
                            }
                        }
                        int backupK=ColumnsToSelect.get(0).size();
 
                        for (int k = 0; k <ColumnsToSelect.get(1).size(); k++) {
                            if (typesToSelect.get(1).get(k).equals("VARCHAR")) {
                                myTypeData[backupK] = new VARCHAR(tmpRegister.get(backupK));
                                backupK++;

                                typesSelectedTable[sizeTypesSelected]="VARCHAR";
                                sizeTypesSelected++;
                            } else if (typesToSelect.get(0).get(k).equals("INTEGER")) {
                                myTypeData[backupK] = new INTEGER(tmpRegister.get(backupK));
                                backupK++;
                                typesSelectedTable[sizeTypesSelected]="INTEGER";
                                sizeTypesSelected++;

                            }
                        }
                        //System.out.println("metadata types"+typesSelectedTable[2]);
                        

                        metadataTableSelected=new String[columnsSelectedTable.length][typesSelectedTable.length];
                        
                        
                        metadataTableSelected[0]=columnsSelectedTable;
                        metadataTableSelected[1]=typesSelectedTable;
                        

                        //System.out.println("Register with Select"+myTypeData[0].getDate());
                        
                        //System.out.println("Register with Select 2:"+myTypeData[1].getDate());
                        
                        //System.out.println("Register with Select 3:"+myTypeData[2].getDate());
                        //System.out.println("VERIF");


                        sizeTypesSelected=0;
                        
                        tmp.put(tail, myTypeData);     
                        //backupInt++;
                        //insertedFlag=true;
                    }
                    
            }
            
          
        }

        

        
        return tmp;
        
        /*for (int i = 0; i <pDatosTable2.size() ; i++) {
            if(pDatosTable2.ceilingEntry(i).getValue()._register[pColumnaCondicionPos2].equals(pDatosTable1.ceilingEntry(0).getValue()._register[pColumnaCondicionPos2])){
            tail=tmp.size();
            System.out.println("Tail"+tail);
            tmp.put(tail, new Register(pDatosTable2.ceilingEntry(i).getValue()._register));
            i++;
            //System.out.println("Dato Join"+tmp.ceilingEntry(1).getValue()._register[1]);
            }  
        }
        
        //System.out.println("Primer dato join"+tmp.ceilingEntry(0).getValue()._register[0]);
        
        
        return tmp;*/
    
    }
    
    
    
    public ArrayList<String[]> selectJoin(String[] pColSelect1, String[] pColSelect2, String pSchema,
            String pTable1, String pTable2, String ColumnJoin, int[] pTipoCondiciones, 
            String format) {
            
        
        
        metadataTable1 = getMetaDataTable(pSchema, pTable1);
        
        
        
        if (metadataTable1 != null) {
            File file = new File(Constants.DATABASE + pTable1);
            
            
            try (DB thedb = DBMaker.fileDB(file).closeOnJvmShutdown().make()) {
                BTreeMap<Integer, typeData[]> primary = thedb.treeMapCreate("pri")
                        .keySerializer(BTreeKeySerializer.INTEGER)
                        .makeOrGet();
                

                int tail = primary.size();
              
                ArrayList<String[]> salida = new ArrayList<>();

                //System.out.println("metadata" +md[0][0]);
                File fileToJoin = new File(Constants.DATABASE + pTable2);
                
                try (DB thedbToJoin = DBMaker.fileDB(fileToJoin).closeOnJvmShutdown().make()) {

                    BTreeMap<Integer, typeData[]> primarytoJoin = thedbToJoin.treeMapCreate("pri")
                            .keySerializer(BTreeKeySerializer.INTEGER)
                            .makeOrGet();

                    metadataTable2 = getMetaDataTable(pSchema, pTable2);
                    

                    //System.out.println("Metadata table FUNC:"+metadataTable2[0][2]);
                    String columnToJoinVerif = "";
                    int posColumnToJoin = 0;

                    ArrayList<ArrayList<Integer>> ColumnsToSelect = new ArrayList<ArrayList<Integer>>();
                    
                    ArrayList<ArrayList<String>> typesToSelect = new ArrayList<ArrayList<String>>();


                    ArrayList<Integer> ColumnsToSelectTab1 = new ArrayList<Integer>();

                    ArrayList<Integer> ColumnsToSelectTab2 = new ArrayList<Integer>();
                    
                     ArrayList<String> typesToSelectTab1 = new ArrayList<String>();

                    ArrayList<String> typesToSelectTab2 = new ArrayList<String>();
                    
                    
                    

                    for (int j = 0; j < pColSelect1.length; j++) {
                        for (int k = 0; k < metadataTable1[0].length; k++) {
                            if (pColSelect1[j].equals(metadataTable1[0][k])) {
                                ColumnsToSelectTab1.add(k);
                            }
                        }
                    }
                    for (int j = 0; j < pColSelect2.length; j++) {
                        for (int k = 0; k < metadataTable2[0].length; k++) {
                            if (pColSelect2[j].equals(metadataTable2[0][k])) {
                                ColumnsToSelectTab2.add(k);
                            }
                        }
                    }
                    for (int k = 0; k < ColumnsToSelectTab1.size(); k++) {
                            typesToSelectTab1.add(metadataTable1[1][ColumnsToSelectTab1.get(k)]);
                    }
                    
                    for (int k = 0; k < ColumnsToSelectTab2.size(); k++) {
                            typesToSelectTab2.add(metadataTable2[1][ColumnsToSelectTab2.get(k)]);
                    }
                    //System.out.println("Verif type to select1"+typesToSelectTab2.get(0));
                    
                    

                    ColumnsToSelect.add(ColumnsToSelectTab1);
                    ColumnsToSelect.add(ColumnsToSelectTab2);
                    
                    typesToSelect.add(typesToSelectTab1);
                    typesToSelect.add(typesToSelectTab2);

                    
                    
                    
                    for (int j = 0; j < metadataTable1[0].length; j++) {
                        if (metadataTable1[0][j].equals(ColumnJoin)) {
                            columnToJoinVerif = metadataTable1[0][j];
                            posColumnToJoin = j;
                        }
                    }
                    
                    int posColumnToJoin2 = 0;

                    for (int j = 0; j < metadataTable2[0].length; j++) {

                        if (metadataTable2[0][j].equals(ColumnJoin)) {
                            columnToJoinVerif = metadataTable2[0][j];
                            posColumnToJoin2 = j;
                        }
                    }
                    
                    

                    if (columnToJoinVerif.equals("") == true) {
                        return null;
                    } 
                    else {
                        //System.out.println("DATOS TABLA 2" + primarytoJoin.ceilingEntry(0).getValue()._register[posColumnToJoin]);
                        
                        
                        BTreeMap<Integer, typeData[]> myJoinSelect = joinLogic(primary, primarytoJoin, posColumnToJoin, posColumnToJoin2, ColumnsToSelect,typesToSelect, thedb);
                        System.out.println("Printing my Join Select Data" + myJoinSelect.ceilingEntry(0).getValue()[3].getDate());
                        //System.out.println("METADA TABLE SELECT"+metadataTableSelected[1][3]);
                        
                        //if(pAggregateFunction.equals("")!=true){
                        //    pAggregateLogic(myJoinSelect,pAggregateFunction.get(0),pAggregateFunction.get(1),metadataTableSelected);
                        //}
                        
                        
                        switch (format) {
                            case "FOR JSON":
                                break;
                            case "FOR XML":
                                break;
                        }
                        
                        
                        return salida;

                    }

                }

            } catch (Exception e) {
                System.out.println("n1");
                return null;
            }
        }
        System.out.println("n2");
        return null;

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
     *         -1216 -> Error en la IR, el dato que se va a insertar no esta en la columna referenciada 1216
     *         -1068 -> Error de la llave primaria el dato esta repetido
     *         -1217 -> Error la col a actualizar es referenciada en otra tabla
     *         -1048 -> Error el dato no admite nulos 1048->SQL
     *         -1232 -> Error el dato no es del tipo correspondiente 1232->SQL
     *         -1072 -> No esta la columna
     *         -1637 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
     *         -1146 -> no se encontro la tabla en la que se va a insertar
     */
    public int update(String pCol, String pValor, String pSchema, String pTable, String[] pColumnasCondiciones,
            String[] pDatosCondiciones,String[] pOpes, int[] pTipoCondiciones){
        
        //Verifica la IR
        String[] pColumns = { pCol };
        String[] pValues = { pValor };
        if(!verificarFK(pSchema, pTable, pColumns, pValues)){
            typeData[] r_a = {new NULL(), new INTEGER("1216"), new VARCHAR("UPDATE"), 
                new VARCHAR("El dato que se va a insertar no esta en la columna referenciada")};
            insert(Constants.LOG_ERRORS, r_a, true);
            return -1216;//Error en la IR, el dato que se va a insertar no esta en la columna referenciada
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
                    typeData[] r_a = {new NULL(), new INTEGER("1068"), new VARCHAR("UPDATE"), 
                        new VARCHAR("Error de la llave primaria el dato esta repetido")};
                    insert(Constants.LOG_ERRORS, r_a, true);
                    return -1068;//Error de la llave primaria el dato esta repetido
                }                           
            }
            
            if(!verificarREF(pSchema, pTable, pColumns)){
                typeData[] r_a = {new NULL(), new INTEGER("1217"), new VARCHAR("UPDATE"), 
                     new VARCHAR("Error la col a actualizar es referenciada en otra tabla")};
                insert(Constants.LOG_ERRORS, r_a, true);
                return -1217;
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
                                        typeData[] r_a = {new NULL(), new INTEGER("1048"), new VARCHAR("UPDATE"), 
                                                new VARCHAR("Error el dato no admite nulos")};
                                        insert(Constants.LOG_ERRORS, r_a, true);
                                        return -1048;//Error el dato no admite nulos 1048->SQL
                                    }
                                }
                                
                                register[j].setDate(pValor);
                                primary.replace(i, register);
                                thedb.commit();
                                nR++;
                            }
                            else{
                                typeData[] r_a = {new NULL(), new INTEGER("1232"), new VARCHAR("UPDATE"), 
                                    new VARCHAR("Error el dato no es del tipo correspondiente")};
                                insert(Constants.LOG_ERRORS, r_a, true);
                                return -1232;//Error el dato no es del tipo correspondiente 1232->SQL
                            }
                            
                        }

                    }
                    return nR;
                }
                else{
                    typeData[] r_a = {new NULL(), new INTEGER("1072"), new VARCHAR("UPDATE"), 
                        new VARCHAR("No esta la columna")};
                    insert(Constants.LOG_ERRORS, r_a, true);
                    return -1072;//-6 -> No esta la columna
                }

            }
            catch(Exception e){
                typeData[] r_a = {new NULL(), new INTEGER("1637"), new VARCHAR("UPDATE"), 
                    new VARCHAR("Error al intentar abrir el achivo, puede que este dañado o concurrencia")};
                insert(Constants.LOG_ERRORS, r_a, true);
                return -1637;//-7 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
            }
        }
        typeData[] r_a = {new NULL(), new INTEGER("1146"), new VARCHAR("UPDATE"), 
            new VARCHAR("no se encontro la tabla en la que se va a insertar")};
        insert(Constants.LOG_ERRORS, r_a, true);
        return -1146;//-8 -> no se encontro la tabla en la que se va a insertar
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
     *          -1217 -> Error en la IR, posee columnas referenciadas 1217
     *          -1637 -> Error al intentar abrir el achivo, puede que este dañado o concurrencia
     *          -1146 -> no se encontro la tabla en la que se va a insertar
     */
    public int delete(String pSchema, String pTable, String[] pColumnasCondiciones,
            String[] pDatosCondiciones, String[] pOpes, int[] pTipoCondiciones){
        
        String[][] md = getMetaDataTable(pSchema, pTable);
        int nR=0;
        if (md!=null){

            if(!verificarREF(pSchema, pTable, md[0])){
                typeData[] r_a = {new NULL(), new INTEGER("1217"), new VARCHAR("UPDATE"), 
                    new VARCHAR("Error en la IR, posee columnas referenciadas")};
                insert(Constants.LOG_ERRORS, r_a, true);
                return -1217;//Error en la IR, posee columnas referenciadas
            }
            
            File file = new File(Constants.DATABASE+pTable);
            try(DB thedb = DBMaker.fileDB(file).closeOnJvmShutdown().make()){
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
                typeData[] r_a = {new NULL(), new INTEGER("1637"), new VARCHAR("UPDATE"), 
                    new VARCHAR("Error al intentar abrir el achivo, puede que este dañado o concurrencia")};
                insert(Constants.LOG_ERRORS, r_a, true);
                return -1637;// Error al intentar abrir el achivo, puede que este dañado o concurrencia
            }
        }
        typeData[] r_a = {new NULL(), new INTEGER("1146"), new VARCHAR("UPDATE"), 
                    new VARCHAR("No existe la tabla")};
        insert(Constants.LOG_ERRORS, r_a, true);
        return -1146;//-3 -> no se encontro la tabla en la que se va a borrar
    
    
    
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
        try(DB thedb = DBMaker.fileDB(file).closeOnJvmShutdown().make()){
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
    
    public boolean verificarDBRepetidas(String pDBName){
        File file = new File(Constants.DATABASE+Constants.DB);
        try(DB thedb = DBMaker.fileDB(file).closeOnJvmShutdown().make()){
            BTreeMap <Integer,typeData[]> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            int tail = primary.size();
            
            for(int i=0; i<tail;i++){
                if (pDBName.equals(primary.ceilingEntry(i).getValue()[0].getDate())){
                    return false;
                }
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean borrarDatabase(String pDBName){
        File file = new File(Constants.DATABASE+Constants.DB);
        try(DB thedb = DBMaker.fileDB(file).closeOnJvmShutdown().make()){
            BTreeMap <Integer,typeData[]> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            int tail = primary.size();
            typeData[] tp = {new NULL()};
            for(int i=0; i<tail;i++){
                if (pDBName.equals(primary.ceilingEntry(i).getValue()[0].getDate())){
                    primary.replace(i, tp);
                    return true;
                }
            }
            return false;
        }
        catch(Exception e){
            return false;
        }
    }
    
    /**
     * Inserta una nueva tabla en la metadata de la base
     * @param pTable nombre de la tablas
     * @param pSchema esquema de la metadata
     * @param pColumnas Cnombres de las columnas de la tabla
     * @param pPrimary nombre de la columna que es PK
     * @return true si se inserta de forma satisfactoria, false en caso contrario
     */
    public boolean updateMETADATA(String pTable, String pSchema, String[] pColumnas, String pPrimary){
        
        File file = new File(Constants.DATABASE+pSchema);
        try(DB thedb = DBMaker.fileDB(file).closeOnJvmShutdown().make()){
            
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
     * @param pSchema Esquema de la tabla
     * @return true si se borra de forma satisfactoria, false en caso contrario
     */
    public boolean deleteTableMetadata(String pTable, String pSchema){
        
        File file = new File(Constants.DATABASE+pSchema);
        try(DB thedb = DBMaker.fileDB(file).closeOnJvmShutdown().make()){
            
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
            if (!plan.equals("NULO") && Integer.parseInt(plan)>3){
                
                String planActual=plan;
                Metadata m = new Metadata("NULL", "NULL", "NULL", "NULL", "NULL");
                for(int j=i;j<tail;j++){
                    
                    plan = primary.ceilingEntry(j).getValue()._id;
                    if(plan.equals(planActual)){
                        primary.replace(j, m);
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

