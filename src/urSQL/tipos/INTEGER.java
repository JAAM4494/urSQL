/*
 * Copyright 2015 Aaron Elizondo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package urSQL.tipos;

/**
 *
 * @author Aaron Elizondo
 */
public class INTEGER extends typeData {

    public INTEGER(String pDate) {
        setDate(pDate);
    }

    @Override
    public boolean comparar(String pDate, String pOperador) {

        int pDateInt = Integer.parseInt(pDate);
        if (verificarTipo(pDate)) {

            int date = Integer.parseInt(getDate());

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
        //if (pOperador.equals("is not null") && !(getDate().equals("NULL")))
        //    return true;  

        return false;
    }

    @Override
    public boolean verificarTipo(String pDate) {
        System.out.println("VERIFICANDO INT "+pDate);
        try {
            if (pDate.equals("NULL")){
            return false;
            }
            Integer.parseInt(pDate);
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
            Integer.parseInt(getDate());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean like(String pDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
