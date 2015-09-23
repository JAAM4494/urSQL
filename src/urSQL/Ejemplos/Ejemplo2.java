package urSQL.Ejemplos;

import RuntimeDBProcessor.commands.CLP.CLPCommands;
import RuntimeDBProcessor.commands.DDL.DDLCommands;
import RuntimeDBProcessor.commands.DML.DMLCommands;
import urSQL.Constants.Constants;

/**
 *
 * @author Aaron Elizondo
 */
public class Ejemplo2 {
    
     
    public static void main(String[] args) {
        
        DMLCommands dml = new DMLCommands();
        DDLCommands ddl = new DDLCommands();
        CLPCommands clp = new CLPCommands();
        
        clp.createDatabase("TEC_DB");   
        System.out.println(ddl.setDatabase("TEC_DB"));
        Funciones.recorrerArchivo(Constants.DB);
        
        /*
        String[] str = {"Carne-INTEGER-NOT NULL", "Nombre-VARCHAR-NULL", "Edad-INTEGER-NOT NULL"};
        System.out.println("CREATE TABLE "+ddl.createTable("Estudiantes", str , "Carne"));
        String[] str2 = {"ID-INTEGER-NOT NULL", "Nombre-VARCHAR-NULL", "Edad-INTEGER-NOT NULL"};
        System.out.println("CREATE TABLE "+ddl.createTable("Profes", str2 , "ID"));
        String[] str3 = {"ID_Curso-INTEGER-NOT NULL", "ID_profe-VARCHAR-NULL"};
        System.out.println("CREATE TABLE "+ddl.createTable("Cursos", str3 , "ID_Curso"));
        Funciones.recorrerArchivo2("TEC_DB");
        */
        
        /*
        String[] datosC = {"1111", "Aaron", "20"};
        String[] datosC2 = {"2222", "Ariel", "18"};
        String[] datosC3 = {"3333", "Edwin", "20"};
        String[] colsC = {"Carne","Nombre","Edad"};
        System.out.println(dml.insert("Estudiantes", colsC, datosC));
        System.out.println(dml.insert("Estudiantes", colsC, datosC2));
        System.out.println(dml.insert("Estudiantes", colsC, datosC3));
        
        String[] datosCb = {"1", "Isac", "30"};
        String[] datosC2b = {"2", "Nereo", "22"};
        String[] datosC3b = {"3", "Pedro", "43"};
        String[] colsCb = {"ID","Nombre","Edad"};
        System.out.println(dml.insert("Profes", colsCb, datosCb));
        System.out.println(dml.insert("Profes", colsCb, datosC2b));
        System.out.println(dml.insert("Profes", colsCb, datosC3b));
        */
        
        /*
        String[] datosC = {"Nereo"};
        String[] colsC = { "Nombre"};
        String[] opes = {"=",};
        int[] condis = {};
        String[] datosCc = {"04", "2"};
        String[] datosC2c = {"02", "2"};
        String[] datosC3c = {"03", "34"};
        String[] colsc = {"ID_Curso","ID_profe"};
        System.out.println(dml.updateTable("ID","4","Profes",colsC, datosC, opes, condis));
        //System.out.println(dml.insert("Cursos", colsc, datosC2c));
        //System.out.println(dml.insert("Cursos", colsc, datosC3c));
        */
        
        Funciones.recorrerArchivo("Estudiantes");
        System.out.println("");
        Funciones.recorrerArchivo(Constants.CONSTRAIT_CATALOG);
        System.out.println("");
        Funciones.recorrerArchivo(Constants.LOG_ERRORS);
        
        
        
        
    }
    
    
}
