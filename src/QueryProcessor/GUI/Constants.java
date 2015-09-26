/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryProcessor.GUI;

/**
 *
 * @author jaam
 */
public interface Constants {

    final String[] PalabrasReservadas = {"WHERE", "CREATE", "DROP", "DATABASES",
        "LIST", "DATABASE", "START", "GET", "STATUS", "STOP", "DISPLAY", "Set",
        "TABLE", "AS", "TYPE", "CONSTRAINT", "NULL", "NOT", "ALTER", "XML", "JSON",
        "ADD", "PRIMARY", "FOREIGN", "REFERENCES", "INDEX", "ON", "SELECT",
        "FROM", "GROUP", "JOIN", "COUNT", "AVERAGE", "MAX", "MIN", "UPDATE", "BY",
        "SET", "DELETE", "INSERT", "VALUES", "FOR", "IS", "INTO", "KEY"};
    
    final String[] OperatorsAndTypes = {">", "<", "=", "like",
        "INTEGER", "CHAR", "VARCHAR", "DATETIME", "DECIMAL", "0", "1", "2",
    "3", "4", "5", "6", "7", "8", "9"};
}
