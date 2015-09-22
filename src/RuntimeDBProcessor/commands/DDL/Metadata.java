package RuntimeDBProcessor.commands.DDL;

import java.io.Serializable;

/**
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
