package urSQL.tipos;

/**
 *
 * @author JAAM
 */
public class DECIMAL extends typeData {

    public DECIMAL(String pData) {
        setDate(pData);
    }

    @Override
    public boolean comparar(String pDate, String pOperador) {
        double pDateInt = Double.parseDouble(pDate);
        if (verificarTipo(pDate)) {

            double date = Double.parseDouble(pDate);

            if (pOperador.equals(">") && date > pDateInt) {
                return true;
            }

            if (pOperador.equals("<") && date < pDateInt) {
                return true;
            }

            if (pOperador.equals("=") && date == pDateInt) {
                return true;
            }

            if (pOperador.equals("not") && date != pDateInt) {
                return true;
            }
            if (pOperador.equals("is not null")) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean verificarTipo(String pDate) {
        try {
            //if (pDate.equals("NULL"))
            //return false;
            Double.parseDouble(pDate);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean verificarTipo() {
        try {
            //if (getDate().equals("NULL"))
            //return false;
            Double.parseDouble(getDate());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
