package FicherosXML.EjLectura;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse("mensajes.xml");
            
            doc.getDocumentElement().normalize();
            
            System.out.println("Elemento raíz: "+doc.getChildNodes().item(0).getNodeName());
            
            Node n = doc.getElementsByTagName("mensajes").item(0);
            
            if(n.getNodeType()==Node.ELEMENT_NODE){
                Element e = (Element)n;
                
                System.out.println("Nombre: "+e.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println("Modo: "+e.getElementsByTagName("modo").item(0).getTextContent());
                
                Node campo = e.getElementsByTagName("campos").item(0);
                Element camp = (Element)campo;
                System.out.println("Campos: "+camp.getElementsByTagName("nombre").item(0).getTextContent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}