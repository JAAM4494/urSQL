package urSQL.tipos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JAAM
 */
public class DATETIME extends typeData {

    public DATETIME(String pData) {
        setDate(pData);
    }

    @Override
    public boolean comparar(String pDate, String pOperador) {
        if (pOperador.equals("=") && pDate.equals(getDate())) {
            return true;
        }

        if (pOperador.equals("not") && !pDate.equals(getDate())) {
            return true;
        }

        if (pOperador.equals("is not null")) {
            return true;
        }
        
        if (pOperador.equals("like")) {
            return like(pDate);
        }

        //if (pOperador.equals("is not null") && !(getDate().equals("NULL")))
        //    return true;  
        return false;
    }

    @Override
    public boolean verificarTipo(String pDate) {
        if(validateDate(pDate))
            return true;
        else
            return false;
    }

    @Override
    public boolean verificarTipo() {
        if(validateDate(getDate()))
            return true;
        else
            return false;
    }
    
     public static boolean validateDate(String date) {

        SimpleDateFormat sdf = new SimpleDateFormat("d-MM-yyyy,k:mm");
        Date testDate = null;
        try {
            testDate = sdf.parse(date);
        }
        catch (ParseException e) {
            return false;
        }
        if (!sdf.format(testDate).equals(date)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean like(String pDate) {
        boolean rValue = false;
        String stringtoCompare = pDate.replaceAll("/", "");;

        if (pDate.startsWith("/") && pDate.endsWith("/")) {
            if(getDate().matches("(?i).*" + stringtoCompare + ".*")) {
                rValue = true;
            }
        } else if (pDate.startsWith("/")) {
            if(getDate().matches("(?i).*" + stringtoCompare)) {
                rValue = true;
            }
        } else if (pDate.endsWith("/")) {
            if(getDate().matches("(?i)" + stringtoCompare + ".*")) {
                rValue = true;
            }
        }

        return rValue;
    }

}
