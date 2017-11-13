package FicherosXML.EjExtra;

import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.newDocument();
            Document doc2 = db.parse("lista.xml");
            
            doc2.normalize();
            
            doc.appendChild(doc.createTextNode("<!DOCTYPE html>"));
            
            Element html = doc.createElement("html");
            doc.appendChild(html);
            Element body = doc.createElement("body");
            html.appendChild(body);
            
            NodeList uls = doc2.getElementsByTagName("ul");
            for(int i=0; i<uls.getLength(); i++){
                Element ul = (Element)uls.item(i);
                Element ul2 = doc.createElement(ul.getNodeName());
                body.appendChild(ul2);

                Attr ultype = doc.createAttribute("type");
                ultype.setValue(ul.getAttribute("type"));
                ul2.setAttributeNode(ultype);
                
                NodeList lis = ul.getElementsByTagName("li");
                for(int j=0; j<lis.getLength(); j++){
                    Element li = (Element)lis.item(j);
                    Element li2 = doc.createElement(li.getNodeName());
                    ul2.appendChild(li2);
                    
                    Element a = (Element)li.getElementsByTagName("a").item(0);
                    Element a2 = doc.createElement(a.getNodeName());
                    li2.appendChild(a2);
                    
                    Attr ahref = doc.createAttribute("href");
                    ahref.setValue(a.getAttribute("href"));
                    a2.setAttributeNode(ahref);
                    a2.appendChild(doc.createTextNode(a.getTextContent()));
                }
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("lista.html"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}