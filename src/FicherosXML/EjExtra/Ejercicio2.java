package FicherosXML.EjExtra;

import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc1 = db.parse("familia.xml");
            Document doc2 = db.newDocument();
            
            doc1.normalize();
            
            Element html = doc2.createElement("html");
            doc2.appendChild(html);
            
            Element body = doc2.createElement("body");
            html.appendChild(body);
            
            Element ol = doc2.createElement("ol");
            Attr type1 = doc2.createAttribute("type");
            type1.setValue("1");
            ol.setAttributeNode(type1);
            body.appendChild(ol);
            
            NodeList parents = doc1.getElementsByTagName("parent");
            for(int i=0; i<parents.getLength(); i++){
                Element parent = (Element)parents.item(i);
                Element lip = doc2.createElement("li");
                Element lim = doc2.createElement("li");
                
                lip.appendChild(doc2.createTextNode("Padre: "+parent.getElementsByTagName("father").item(0).getTextContent()));
                lim.appendChild(doc2.createTextNode("Madre: "+parent.getElementsByTagName("mother").item(0).getTextContent()));
                
                ol.appendChild(lip);
                ol.appendChild(lim);
                
                Element ol2 = doc2.createElement("ol");
                Attr type2 = doc2.createAttribute("type");
                type2.setValue("a");
                ol2.setAttributeNode(type2);
                ol.appendChild(ol2);
                
                NodeList names = parent.getElementsByTagName("name");
                for (int j=0; j<names.getLength(); j++) {
                    Element name = (Element)names.item(j);
                    Element li2 = doc2.createElement("li");
                    li2.appendChild(doc2.createTextNode("Hijo: "+name.getTextContent()));
                    ol2.appendChild(li2);
                }
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc2);
            StreamResult result = new StreamResult(new File("familia.html"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}