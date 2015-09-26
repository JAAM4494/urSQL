package urSQL.tipos;

/**
 *
 * @author JAAM
 */
public class CHAR extends typeData {

    private int charPrecision;

    public CHAR(String pData, int pPrecission) {
        setDate(pData);
        charPrecision = pPrecission;
    }

    @Override
    public boolean comparar(String pDate, String pOperador) {
        if (pOperador.equals("=") && pDate.equals(getDate())) {
            return true;
        }

        if (pOperador.equals("not") && !pDate.equals(getDate())) {
            return true;
        }

        if (pOperador.equals("like")) {
            return like(pDate);
        }
        
        if (pOperador.equals("is not null"))
            return true;

        //if (pOperador.equals("is not null") && !(getDate().equals("NULL"))) {
          //  return true;
        //}

        return false;
    }

    @Override
    public boolean verificarTipo(String pDate) {
        if (pDate.length() == getCharPrecision()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean verificarTipo() {
        if (getDate().length() == getCharPrecision()) {
            return true;
        } else {
            return false;
        }
    }

    public int getCharPrecision() {
        return charPrecision;
    }

    public void setCharPrecision(int charPrecision) {
        this.charPrecision = charPrecision;
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
