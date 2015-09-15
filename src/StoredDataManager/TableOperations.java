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
import java.util.ArrayList;
import org.mapdb.BTreeKeySerializer;
import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

/**
 *
 * @author Aaron Elizondo
 */
public class TableOperations {
    
    public boolean insert(String pTable, String[] pValues){
        File file = new File(Constants.DATABASE+pTable);
        try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
            BTreeMap <Integer,Register> primary = thedb.treeMapCreate("pri")
                    .keySerializer(BTreeKeySerializer.INTEGER)
                    .makeOrGet();
            int tail = primary.size();
            primary.put(tail, new Register(pValues));
            thedb.commit();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean insertINTO(String pSchema, String pTable, String[] pColumns, String[] pValues){
        
        String[][] metadata = getMetaDataTable(pSchema, pTable);
        int largoC = pColumns.length;
        int largoDatos = metadata[0].length;
        String[] salida = new String[largoDatos];
        
        for (int i=0; i<largoDatos; i++){
            int j;
            for (j=0; j<largoC; j++){
                
                if (pColumns[j].equals(metadata[0][i])){        
                    //Antes de aqui hay que verificar los tipos
                    salida[i] = pValues[j];
                    break;
                }
                
            }
            
            if (j==largoC){
                //Aqui hay que verificar nullability
                salida[i] = "NULL";
            }
            
        }
        for (int k=0; k<largoDatos; k++){
            System.out.print(salida[k]+"  ");
        }

        return insert(pTable,salida);
        
        
    }
    
    public boolean where(String[] pRegistroDatos, String[] pRegistroCols, String[] pColumnasCondiciones,
            String[] pDatosCondiciones, int[] pTipoCondiciones){

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
                    if (pRegistroDatos[j].equals(pDatosCondiciones[i])){
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
                    condicionActual = pRegistroDatos[j].equals(pDatosCondiciones[i]);

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
            String[] pDatosCondiciones, int[] pTipoCondiciones){
        
        String[][] md = getMetaDataTable(pSchema, pTable);
        if (md!=null){
            File file = new File(Constants.DATABASE+pTable);
            try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
                BTreeMap <Integer,Register> primary = thedb.treeMapCreate("pri")
                        .keySerializer(BTreeKeySerializer.INTEGER)
                        .makeOrGet();

                int tail = primary.size();
                /*if (pColSelect[0].equals("*")){
                    pColSelect = md[0];
                }*/
                ArrayList<String[]> salida = new ArrayList<>();

                for (int i=0; i<tail; i++){
                    String[] dates = primary.ceilingEntry(i).getValue()._register;
                    boolean w = where(dates, md[0], pColumnasCondiciones, pDatosCondiciones, pTipoCondiciones);
                    if(w){
 
                        int larDates = md[0].length;
                        int larCols = pColSelect.length;
                        String[] sal = new String[larCols];
                        for (int j=0; j<larCols; j++){    
                            int k;
                            for (k=0; k<larDates; k++){

                                if (pColSelect[j].equals(md[0][k])){
                                   sal[j] = dates[k];
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
                return null;
            }
        }
        System.out.println("n2");
        return null;
        
    }
    
    public boolean update(String pCol, String pValor, String pSchema, String pTable, String[] pColumnasCondiciones,
            String[] pDatosCondiciones, int[] pTipoCondiciones){
        
        String[][] md = getMetaDataTable(pSchema, pTable);
        
        if (md!=null){
            File file = new File(Constants.DATABASE+pTable);
            try(DB thedb = DBMaker.fileDB(file).closeOnJvmShutdown().make()){
                BTreeMap <Integer,Register> primary = thedb.treeMapCreate("pri")
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
                if (j!=larDates){

                    for (int i=0; i<tail; i++){
                        String[] dates = primary.ceilingEntry(i).getValue()._register;
                        boolean w = where(dates, md[0], pColumnasCondiciones, pDatosCondiciones, pTipoCondiciones);
                        if(w){
                            dates[j] = pValor;
                            primary.replace(i, new Register(dates));
                            thedb.commit();
                            System.out.println("Se actualizo un registro");
                        }

                    }
                }
                else{
                    System.out.println("No esta la columnas");
                    //aqui va un erroor
                }

            }
            catch(Exception e){
                System.out.println("n1");
            }
        }
        System.out.println("n2");
        return false;
    }
    
    public boolean delete(String pSchema, String pTable, String[] pColumnasCondiciones,
            String[] pDatosCondiciones, int[] pTipoCondiciones){
        
        String[][] md = getMetaDataTable(pSchema, pTable);
        
        if (md!=null){
            
            File file = new File(Constants.DATABASE+pTable);
            try(DB thedb = DBMaker.newFileDB(file).closeOnJvmShutdown().make()){
                BTreeMap <Integer,Register> primary = thedb.treeMapCreate("pri")
                        .keySerializer(BTreeKeySerializer.INTEGER)
                        .makeOrGet();

                int tail = primary.size();
                
                int larDates = md[0].length;
                String[] registerVacio = new String[larDates];
                for (int j=0; j<larDates; j++){    
                    registerVacio[j] = "#|VACIO|#";
                }

                for (int i=0; i<tail; i++){
                    String[] dates = primary.ceilingEntry(i).getValue()._register;
                    boolean w = where(dates, md[0], pColumnasCondiciones, pDatosCondiciones, pTipoCondiciones);
                    if(w){
                        primary.replace(i, new Register(registerVacio));
                        thedb.commit();
                        System.out.println("Se Borro un registro");
                    }
                }
            }
            catch(Exception e){
                System.out.println("n1");
            }
        }
        System.out.println("n2");
        return false;
    
    
    
    }
    
    public String[][] getMetaDataTable(String pSchema, String pTable){
        
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
    
    public ArrayList<Metadata> getMetaDataTable2(String pSchema, String pTable){
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
            System.out.println("n2");
            return null;
            //AQUI VA UN ERROR O MENSAJE DE QUE NO SE ENCONTRO LA DATABASE
        }
    }

}

