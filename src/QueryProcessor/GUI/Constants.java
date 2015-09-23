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

    final String[] PalabrasReservadas = {"where", "create", "drop", "databases",
        "list", "database", "start", "get", "status", "stop", "display", "set",
        "table", "as", "type", "constraint", "null", "not", "alter", "xml", "json",
        "add", "primary", "foreign", "references", "drop", "index", "on", "select",
        "from", "group", "join", "count", "average", "max", "min", "update", "by",
        "set", "delete", "insert", "values", "for", "is", "into", "key"};
    
    final String[] OperatorsAndTypes = {">", "<", "=", "like", "true", "false",
        "integer", "char", "varchar", "datetime", "decimal", "0", "1", "2",
    "3", "4", "5", "6", "7", "8", "9"};
}
