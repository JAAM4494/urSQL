/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RuntimeDBProcessor;

import RuntimeDBProcessor.commands.DDL.DDLCommands;
import RuntimeDBProcessor.parser.urSQLLexer;
import RuntimeDBProcessor.parser.urSQLParser;
import StoredDataManager.TableOperations;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import urSQL.Ejemplos.main;

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
    
     public static void main(String[] args) throws RecognitionException {
        RuntimePreParser prueba = new RuntimePreParser();
        prueba.recievemsg("INSERT INTO mytable(column1,column2) VALUES (valor1,valor2)");  
     }
    
    
    
}
