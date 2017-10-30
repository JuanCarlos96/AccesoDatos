package FicherosXML.EjLectura;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        try{
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse("modelingOutput.xml");
            
            doc.getDocumentElement().normalize();
            
            System.out.println("Elemento raíz: "+doc.getChildNodes().item(0).getNodeName());
            
            Node n = doc.getElementsByTagName("modelingOutput").item(0);
            Element mo = (Element)n;
            
            Node n2 = mo.getElementsByTagName("listOfTopics").item(0);
            Element lot = (Element)n2;
            System.out.println("\n"+lot.getNodeName());
            
            Node n3 = lot.getElementsByTagName("topic").item(0);
            Element lotTopic = (Element)n3;
            System.out.println(lotTopic.getNodeName()+" "+lotTopic.getAttribute("id"));
            
            Node n4 = lotTopic.getElementsByTagName("token").item(0);
            Element lotToken = (Element)n4;
            System.out.println(lotToken.getNodeName()+" "+lotToken.getAttribute("id")+": "+lotToken.getTextContent());
            
            Node n5 = doc.getElementsByTagName("rankedDocs").item(0);
            Element rd = (Element)n5;
            System.out.println("\n"+rd.getNodeName());
            
            Node n6 = rd.getElementsByTagName("topic").item(0);
            Element rdTopic = (Element)n6;
            System.out.println(rdTopic.getNodeName()+" "+rdTopic.getAttribute("id"));
            
            Node n7 = rdTopic.getElementsByTagName("documents").item(0);
            Element rdDocs = (Element)n7;
            System.out.println(rdDocs.getNodeName());
            
            NodeList nDocs = rdDocs.getElementsByTagName("document");
            for(int i=0; i<nDocs.getLength(); i++){
                Element rdDoc = (Element)nDocs.item(i);
                System.out.println(rdDoc.getNodeName()+" "+rdDoc.getAttribute("id"));
                System.out.println("NumWords "+rdDoc.getAttribute("numWords"));
            }
            
            Node n8 = doc.getElementsByTagName("listOfDocs").item(0);
            Element lod = (Element)n8;
            System.out.println("\n"+lod.getNodeName());
            
            Node n9 = lod.getElementsByTagName("documents").item(0);
            Element lodDocs = (Element)n9;
            System.out.println(lodDocs.getNodeName());
            
            Node n10 = lodDocs.getElementsByTagName("document").item(0);
            Element lodDoc = (Element)n10;
            System.out.println(lodDoc.getNodeName()+" "+lodDoc.getAttribute("id"));
            
            NodeList nTopics = lodDoc.getElementsByTagName("topic");
            for (int i=0; i<nTopics.getLength(); i++) {
                Element lodTopic = (Element)nTopics.item(i);
                System.out.println(lodTopic.getNodeName()+" "+lodTopic.getAttribute("id"));
                System.out.println("Percentage "+lodTopic.getAttribute("percentage"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}