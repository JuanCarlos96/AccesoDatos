package FicherosXML.EjLectura;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse("universidad.xml");
            
            doc.getDocumentElement().normalize();
            
            System.out.println("Elemento raíz: "+doc.getChildNodes().item(0).getNodeName());
            NodeList nl = doc.getElementsByTagName("estudiante");
            System.out.println("Número de estudiantes: "+nl.getLength());
            
            for(int i=0; i<nl.getLength(); i++){
                Node n = nl.item(i);
                
                if(n.getNodeType()==Node.ELEMENT_NODE){
                    Element e = (Element)n;
                    
                    Node nombre = e.getElementsByTagName("nombre").item(0);
                    
                    if(nombre.getNodeType()==Node.ELEMENT_NODE){
                        Element nom = (Element)nombre;
                        
                        System.out.println("\nID de estudiante: "+nom.getAttribute("id"));
                        System.out.println("Nombre: "+nom.getTextContent());
                    }
                    
                    //System.out.println("\nID de estudiante: ");
                    //System.out.println("Nombre: "+e.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("Edad: "+e.getElementsByTagName("edad").item(0).getTextContent());
                    
                    NodeList hobbys = e.getElementsByTagName("hobby");
                    for(int j=0; j<hobbys.getLength(); j++){
                        Node hobby = hobbys.item(j);
                        
                        if(hobby.getNodeType()==Node.ELEMENT_NODE){
                            Element h = (Element)hobby;
                            
                            System.out.println("Hobby: "+h.getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}