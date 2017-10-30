package FicherosXML;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class LecturayEscritura {
    public static void main(String[] args) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse("fitness.xml");
            Document doc2 = db.newDocument();
            
            doc.getDocumentElement().normalize();
            
            Element fitness = (Element)doc.getElementsByTagName("fitness").item(0);
            Element raiz = doc2.createElement(fitness.getNodeName());
            doc2.appendChild(raiz);
            
            NodeList nGroups = fitness.getElementsByTagName("group");
            for(int i=0; i<nGroups.getLength(); i++){
                Element group = (Element)nGroups.item(i);
                int id = Integer.parseInt(group.getAttribute("id"));
                int tam = group.getElementsByTagName("videoUrl").item(0).getTextContent().length();
                
                if (id%2!=0 && tam>1) {
                    Element group2 = doc2.createElement(group.getNodeName());
                    raiz.appendChild(group2);
                    
                    Attr id2 = doc2.createAttribute("id");
                    id2.setValue(group.getAttribute("id"));
                    group2.setAttributeNode(id2);
                    Attr name = doc2.createAttribute("name");
                    name.setValue(group.getAttribute("name"));
                    group2.setAttributeNode(name);
                    
                    Element exercises = (Element)group.getElementsByTagName("exercises").item(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}