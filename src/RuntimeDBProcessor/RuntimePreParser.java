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
    //CREATE TABLE Hola AS (Nombre VARCHAR NOT NULL,Cedula INTEGER NOT NULL, PRIMARY KEY(Nombre));
    //ALTER TABLE hola ADD CONSTRAINT FOREIGN KEY (colhola) REFERENCES hola2 (colhola2)
    //UPDATE hola Set col=valor WHERE a=1 OR b=2
    //INSERT INTO hola(col1, col2) VALUES (val1, val2, val3)
    public static void main(String[] args) throws RecognitionException {
        RuntimePreParser prueba = new RuntimePreParser();
        prueba.recievemsg("UPDATE hola Set col=newVal WHERE a=1 OR b=2");  
    }
    
    
    
}
