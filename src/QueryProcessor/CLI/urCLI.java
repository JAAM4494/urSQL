/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryProcessor.CLI;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JAAM
 */
public class urCLI {

    static String userInputString;
    static Scanner userScanner;

    public static void main(String[] args) {
        // TODO code application logic here
        userScanner = new Scanner(System.in);
        userInputString = "";
        while (!userInputString.equals("exit")) {
            System.out.print("~/urSQL:>");
            userInputString = userScanner.nextLine();
            if (userInputString.equals("exit")) {
                // exit from cmd
                break;
            } else {
                try {
                    Connector conn = new Connector(8080);
                    String out = conn.sendMessage(userInputString);
                    //System.out.println(out);
                    ResultSetManager manager =  new ResultSetManager();
                    manager.displayResult(out);
                    manager.displayStatus(out);
                } catch (IOException ex) {
                    Logger.getLogger(urCLI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}

