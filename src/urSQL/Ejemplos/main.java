package urSQL.Ejemplos;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import java.util.ArrayList;
import org.mapdb.Serializer;
import urSQL.Constants.Constants;
import RuntimeDBProcessor.commands.DDL.DDLCommands;
import RuntimeDBProcessor.commands.DML.DMLCommands;
import urSQL.StoreDataManager.TableOperations;

/**
 *
 * @author Aaron Elizondo
 */
public class main {
    public static void main(String[] args) {
           
        TableOperations to = new TableOperations();
        DDLCommands ddl = new DDLCommands();
        ddl.setDatabase("TEC_DB");
        //Funciones.recorrerArchivo2("TEC_DB");
        //Funciones.recorrerArchivo("Estudiantes");
        
        /*
        ddl.createDatabase();
        Funciones.recorrerArchivo2("TEC_DB");
      
        
        
        //INSERTAR METADATA EN EL ESQUEMA Y SU HISTORY
        String[] str  = {"Carne-INTEGER-NOT NULL", "Nombre-VARCHAR-NULL", "Edad-INTEGER-NOT NULL"};
        System.out.println(ddl.createTable("Estudiantes", str , "Carne"));
        Funciones.recorrerArchivo2("TEC_DB");
        */
        
        
        //INSERTAR
        /*String[] datosC = {"1111", "Aaron", "20"};
        String[] datosC2 = {"2222", "Ariel", "18"};
        String[] datosC3 = {"3333", "Edwin", "20"};
        String[] datosC4 = {"2222", "Gabo", "28"};
        String[] datosC5 = {"5555", "segt", "68"};
        String[] colsC = {"Carne","Nombre","Edad"};
        System.out.println(to.insertINTO("TEC_DB", "Estudiantes", colsC, datosC));
        System.out.println(to.insertINTO("TEC_DB", "Estudiantes", colsC, datosC2));
        System.out.println(to.insertINTO("TEC_DB", "Estudiantes", colsC, datosC3));
        System.out.println(to.insertINTO("TEC_DB", "Estudiantes", colsC, datosC4));
        System.out.println(to.insertINTO("TEC_DB", "Estudiantes", colsC, datosC5));
        Funciones.recorrerArchivo("Estudiantes");
        */
        
        /*
        String[] datosC = {"20130183", "Largo", "Bases2"};
        String[] colsC = {"Carne","Nombre","Curso"};
        System.out.println(to.insertINTO("TEC_DB", "Cursos", colsC, datosC));
        Funciones.recorrerArchivo("Cursos");
        */
        
        /*
        //WHERE
        typeData[] datos = {new VARCHAR("Aaron"), new VARCHAR("Elizondo"), new INTEGER("2013018351"), new INTEGER("20")};
        String[] cols = {"Nombre", "Apellido", "Carne", "Edad"};
        String[] datosC = {"Aaron", "19"};
        String[] colsC = {"Nombre", "Edad"};
        String[] opes = {"=",">"};
        int[] condis = {1};
        boolean a = to.where(datos, cols, colsC, datosC, opes, condis);
        System.out.println(a);
        */
        
       /* 
        //SELECT
        String[] cols = {"="};
        String[] datosC = {"8"};
        String[] colsC = {"Carne"};
        String[] opes = {"="};
        int[] condis = {};
        ArrayList<String[]> salida = to.select(cols, "TEC_DB", "Estudiantes", colsC, datosC, opes, condis);
        System.out.println(salida.get(0)[0]+"  "+salida.get(0)[1]+"  "+salida.get(0)[2]);
        */
        
        /*
        //UPDATE
        Funciones.recorrerArchivo("Estudiantes");
        String[] datosC = {"Edwin"};
        String[] colsC = { "Nombre"};
        String[] opes = {"=",};
        int[] condis = {};
        to.update("Carne", "2222", "TEC_DB", "Estudiantes", colsC, datosC, opes, condis);
        //to.delete( "TEC_DB", "Estudiantes", colsC, datosC, opes, condis);
        Funciones.recorrerArchivo("Estudiantes");
        */
        
        //ALTER TABLE
        //System.out.println(ddl.createAlterTable("Cursos", "Carne", "Estudiantes_Carne"));
        //Funciones.recorrerArchivo(Constants.CONSTRAIT_CATALOG);
        
        /*
        String[] colsC = {"Carne","Nombre","Curso"};
        String[] data = {"201301835", "Largo", "Bases2"};
        System.out.println(to.verificarFK("TEC_DB", "Cursos", colsC, data));
        */

    }
}
//Nota acordar poner siempre llave primaria primero mejor