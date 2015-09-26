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
public class NULL extends typeData{

    
    public NULL(){
        setDate("NULL");
    }
    @Override
    public boolean comparar(String pDate, String pOperador) {
        if (pOperador.equals("is null"))
            return true;  
        
        return false;
    }

    @Override
    public boolean verificarTipo(String pData) {
        return pData.equals("NULL");
    }

    @Override
    public boolean verificarTipo() {
        return getDate().equals("NULL");
    }

    @Override
    public boolean like(String pDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
