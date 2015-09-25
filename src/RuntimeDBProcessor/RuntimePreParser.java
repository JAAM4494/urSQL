/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RuntimeDBProcessor;

import RuntimeDBProcessor.parser.urSQLLexer;
import RuntimeDBProcessor.parser.urSQLParser;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import urSQL.Constants.Constants;
import urSQL.Ejemplos.Funciones;

/**
 *
 * @author macbook
 */
public class RuntimePreParser {
    
    public void recievemsg(String msg) throws RecognitionException{
       ANTLRStringStream in = new ANTLRStringStream(msg);
       urSQLLexer lexer = new urSQLLexer(in);
       CommonTokenStream tokens = new CommonTokenStream(lexer);
       urSQLParser parserP = new urSQLParser(tokens);  
       parserP.script();
    }
    //CREATE DATABASE TecDB
    //CREATE TABLE Hola AS (Nombre VARCHAR NOT NULL,Cedula INTEGER NOT NULL, PRIMARY KEY(Nombre));
    //ALTER TABLE hola ADD CONSTRAINT FOREIGN KEY (colhola) REFERENCES hola2 (colhola2)
    //UPDATE hola Set col=valor WHERE a=1 OR b=2
    //INSERT INTO hola(col1, col2) VALUES (val1, val2, val3)
    public static void main(String[] args) throws RecognitionException {
        RuntimeDB d = new RuntimeDB();
        d.setDB("TecDB");
        RuntimePreParser prueba = new RuntimePreParser();
        prueba.recievemsg("CREATE TABLE Est AS (Carne INTEGER NOT NULL,Nombre VARCHAR NOT NULL, PRIMARY KEY(Carne))");  
       
        
        //Funciones.recorrerArchivo2("TecDB");
        /*System.out.println("HISTORY CATALOG");
        Funciones.recorrerArchivo(Constants.HISTORY_CATALOG);
        System.out.println("CONSTRAIT CATALOG");
        Funciones.recorrerArchivo(Constants.CONSTRAIT_CATALOG);
        */
    }
    /*
    CREATE DATABASE TecDB
    CREATE TABLE Est AS (Carne INTEGER NOT NULL,Nombre VARCHAR NOT NULL, PRIMARY KEY(Carne))
    CREATE TABLE Profes AS (idProfe INTEGER NOT NULL,Nombre VARCHAR NOT NULL, PRIMARY KEY(idProfe))
    CREATE TABLE Cursos AS (idCurso INTEGER NOT NULL,carneEst INTEGER NOT NULL, idProfe VARCHAR NOT NULL, PRIMARY KEY(idCurso))
    ALTER TABLE Cursos ADD CONSTRAINT FOREIGN KEY (carneEst) REFERENCES Est(Carne)
    ALTER TABLE Cursos ADD CONSTRAINT FOREIGN KEY (idProfe) REFERENCES Profes(idProfe)
    INSERT INTO Est (Carne,Nombre) VALUES (2013018351, Aaron)
    INSERT INTO Profes (idProfe,Nombre) VALUES (1, IssacNereo)
    INSERT INTO Cursos (idCurso,carneEst,idProfe) VALUES (1, 2013018351, PRO1)
    */
     
}
