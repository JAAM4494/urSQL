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

import RuntimeDBProcessor.commands.DDL.DDLCommands;
import java.util.ArrayList;

/**
 *
 * @author Aaron Elizondo
 */
public class main {
    public static void main(String[] args) {
        
        String[] str 
                = {"Carne-INT-NOT NULL", "Nombre-VARCHAR-NULL", "Edad-INT-NOT NULL"};
        System.out.println(DDLCommands.createTableMD("Estudiantes", str , "Carne"));
        System.out.println(DDLCommands.updateMETADATA("TEC", "EST", str, "Edad"));
        //Files.commitFile(Constants.HISTORY_CATALOG);
        //DDLCommands.createP&EINDEX("Emp", "personas.edad");
        //Funciones.recorrerArchivo(Constants.HISTORY_CATALOG);
        Funciones.recorrerArchivo2("TEC");
        
        
        /*
        String[] datos = {"Aaron", "Elizondo", "2013018351", "20"};
        String[] cols = {"Nombre", "Apellido", "Carne", "Edad"};
        
        String[] datosC = {"Aaron", "Elizono"};
        String[] colsC = {"Nombre", "Apellido"};
        
        int[] condis = {1};
        
        TableOperations t = new TableOperations();
        boolean a = t.where(datos, cols, colsC, datosC, condis);
        System.out.println(a);
        */
        
        
        /*
        TableOperations t2 = new TableOperations();
        ArrayList<Metadata> as = t2.getMetaDataTable2("TEC", "EST");
        System.out.println(as.size());
        */
        
        
        /*
        TableOperations t2 = new TableOperations();
        String[] datosC = {"Gabo", "20"};
        String[] colsC = {"Nombre", "Edad"};
        
        //t2.insertINTO("TEC", "EST", colsC, datosC);
        int[] condis = {1};
        Funciones.recorrerArchivo("EST");
        System.out.println("SELECT");
        ArrayList<String[]> salida = t2.select(colsC, "TEC", "EST", colsC, datosC, condis);
        System.out.println(salida.get(0)[0]);
         */
        
        /*
        Funciones.recorrerArchivo("EST");
        TableOperations t2 = new TableOperations();
        String[] datosC = {"20"};
        String[] colsC = { "Edad"};
        int[] condis = {};
        //t2.update("Carne", "ACT", "TEC", "EST", colsC, datosC, condis);
        t2.delete("TEC", "EST", colsC, datosC, condis);
        Funciones.recorrerArchivo("EST");
                */
    }
}
//Nota acordar poner siempre llave primaria primero mejor