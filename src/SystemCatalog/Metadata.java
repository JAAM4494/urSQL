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
package SystemCatalog;

import java.io.Serializable;

/**
 *
 * @author Aaron Elizondo
 */
public class Metadata implements Serializable {
    
    public final String _id;
    public final String _typeData;
    public final String _name;
    public final String _type;
    public final String _nullability;
    
            
    public Metadata(String pId, String pTypeData, String pName, String pType, String pNULL){
        _id = pId;
        _typeData = pTypeData;
        _name = pName;
        _type= pType;
        _nullability = pNULL;
    }
    
}
