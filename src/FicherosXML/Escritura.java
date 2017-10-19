package FicherosXML;

import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Escritura {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            
            // definimos el elemento raíz del documento
            Element eRaiz = doc.createElement("concesionario");
            doc.appendChild(eRaiz);
            
            // definimos el nodo que contendrá los elementos
            Element eCoche = doc.createElement("coche");
            eRaiz.appendChild(eCoche);
            
            // atributo para el nodo coche
            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            eCoche.setAttributeNode(attr);
            
            // definimos cada uno de los elementos y le asignamos un valor
            Element eMarca = doc.createElement("marca");
            eMarca.appendChild(doc.createTextNode("Renault"));
            eCoche.appendChild(eMarca);
            Element eModelo = doc.createElement("modelo");
            eModelo.appendChild(doc.createTextNode("Megano"));
            eCoche.appendChild(eModelo);
            Element eCilindrada = doc.createElement("cilindrada");
            eCilindrada.appendChild(doc.createTextNode("1.5"));
            eCoche.appendChild(eCilindrada);
            
            // Segundo coche
            Element coche2 = doc.createElement("coche");
            eRaiz.appendChild(coche2);
            
            Attr idcoche2 = doc.createAttribute("id");
            idcoche2.setValue("2");
            coche2.setAttributeNode(idcoche2);
            
            Element marcacoche2 = doc.createElement("marca");
            marcacoche2.appendChild(doc.createTextNode("Seat"));
            coche2.appendChild(marcacoche2);
            Element modelocoche2 = doc.createElement("modelo");
            modelocoche2.appendChild(doc.createTextNode("León"));
            coche2.appendChild(modelocoche2);
            
            
            // clases necesarias finalizar la creación del archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("ejercicio3.xml"));
            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}