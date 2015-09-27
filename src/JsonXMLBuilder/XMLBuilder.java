package JsonXMLBuilder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author jaam
 */ 
public class XMLBuilder {
    
    private final Element root;
    private final Document document;
    
    public XMLBuilder(String pRoot){ 
        root = new Element(pRoot);
        document = new Document();
        document.setRootElement(root);
    }
    
    public void addElement(Element pElem) {
        document.getRootElement().addContent(pElem);
    }
    
    public String getStringXML() {
        String rValue = null;
        
        XMLOutputter xmlOut = new XMLOutputter(); 
        xmlOut.setFormat(Format.getPrettyFormat().setOmitDeclaration(true));
        rValue = xmlOut.outputString(document);
        
        return rValue;
    }
}
