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
                int tam = group.getElementsByTagName("videoUrl").item(0).getTextContent().trim().split(" ").length;
                
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
                    Element exercises2 = doc2.createElement(exercises.getNodeName());
                    group2.appendChild(exercises2);
                    
                    Attr id3 = doc2.createAttribute("id");
                    id3.setNodeValue(exercises.getAttribute("id"));
                    exercises2.setAttributeNode(id3);
                    Attr name2 = doc2.createAttribute("name");
                    name2.setValue(exercises.getAttribute("name"));
                    exercises2.setAttributeNode(name2);
                    
                    Element implementation = (Element)exercises.getElementsByTagName("implementation").item(0);
                    Element implementation2 = doc2.createElement(implementation.getNodeName());
                    implementation2.appendChild(doc2.createTextNode(implementation.getTextContent()));
                    exercises2.appendChild(implementation2);
                    
                    Element videoUrl = (Element)group.getElementsByTagName("videoUrl").item(0);
                    Element videoUrl2 = doc2.createElement(videoUrl.getNodeName());
                    videoUrl2.appendChild(doc2.createTextNode(videoUrl.getTextContent()));
                    exercises2.appendChild(videoUrl2);
                }
            }
            
            // clases necesarias finalizar la creación del archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc2);
            StreamResult result = new StreamResult(new File("fitness2.xml"));
//            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}