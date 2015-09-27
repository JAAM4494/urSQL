/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueryProcessor.GUI;

import java.util.Observable;
import java.util.StringTokenizer;

/**
 *
 * @author jaam
 */
public class TextAnalysis extends Observable {

    private int x = 0, y = 0;
    private int x_aux = 0;

    public String posicionCursor(String pTexto, int pPos) {
        StringTokenizer pText = new StringTokenizer(pTexto, "\n");
        int col = 0, a = pText.countTokens();
        //System.out.println("a="+a);
        String token = "";
        for (int i = 0; i < a; i++) {
            token = pText.nextToken();
            //System.out.println(token);
            if ((col + token.length()) >= pPos) {
                //System.out.println("entro");
                int posLinea = pPos - col;
                int linea = i + 1;
                //System.out.println("Linea "+linea+":"+(posLinea));
                return ("Linea " + linea + ":" + (posLinea));
            }
            col += token.length();
            //System.out.println("col="+col);

        }
        return "Linea " + (a) + ":" + (token.length());

    }

    public void analizador(String pText) {

        int largo = pText.length() + 1;
        String pComparar;
        boolean flag = true;

        for (int i = 0; i < largo; i++) {

            for (int j = 0; j < Constants.PalabrasReservadas.length; j++) {

                pComparar = Constants.PalabrasReservadas[j];
                int largoComparar = pComparar.length();

                if ((i + largoComparar) < largo) {
                    
                    if (pComparar.equals(pText.substring(i, i + largoComparar))) {
                        x = i;
                        y = i + largoComparar - 1;
                        i = y;
                        setChanged();
                        notifyObservers("palabraReservada");
                        flag = false;
                        break;
                    }
                }
            }

            for (int j = 0; j < Constants.OperatorsAndTypes.length; j++) {

                pComparar = Constants.OperatorsAndTypes[j];
                int largoComparar = pComparar.length();

                if ((i + largoComparar) < largo) {

                    if (pComparar.equals(pText.substring(i, i + largoComparar))) {
                        x = i;
                        y = i + largoComparar - 1;
                        i = y;
                        setChanged();
                        notifyObservers("palabra1");
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                x_aux = i;
                setChanged();
                notifyObservers("letraNormal");
            }
            flag = true;
        }

    }

    public int obtenerInicio() {
        return x;
    }

    public int obtenerFinal() {
        return y;
    }

    public int obtenerLetra() {
        return x_aux;
    }

}
