package FicherosXML.EjLectura;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse("book.xml");
            
            // estos métodos podemos usarlos combinados para normalizar el archivo XML
            doc.getDocumentElement().normalize();
            
            System.out.println("Elemento raíz: "+doc.getChildNodes().item(0).getNodeName());
            
            // almacenamos los nodos para luego mostrar la
            // cantidad de ellos con el método getLength()
            NodeList nList = doc.getElementsByTagName("person");
            System.out.println("Número de personas: "+nList.getLength());
            
            for(int i=0; i<nList.getLength(); i++){
                Node nNode = nList.item(i);
                
                if(nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("\nNombre: "+eElement.getElementsByTagName("first").item(0).getTextContent());
                    System.out.println("Appellido: "+eElement.getElementsByTagName("last").item(0).getTextContent());
                    System.out.println("Edad: "+ eElement.getElementsByTagName("age").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}