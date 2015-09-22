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
public class VARCHAR extends typeData{
    
    
    public VARCHAR(String pData){
        setDate(pData);
    }
    
    @Override
    public boolean comparar(String pDate, String pOperador) {
        
        if (pOperador.equals("=") && pDate.equals(getDate()))
            return true;
            
        /*
        if (pOperador.equals("not") && date!=pDateInt)
            return true;

        if (pOperador.equals(">") && date>pDateInt)
            return true;
            
        if (pOperador.equals("<") && date<pDateInt)
            return true;
        
        if (pOperador.equals("like"))
            return false;
        
        if (pOperador.equals("is not null") && !(getDate().equals("NULL")))
            return true;  
        
        if (pOperador.equals("is null") && getDate().equals("NULL"))
            return true;
        */
        
        return false;
    }
    
    @Override
    public boolean verificarTipo(String pDate) {
        return true;
    }
    
    @Override
    public boolean verificarTipo() {
        return true; 
    }    
}
