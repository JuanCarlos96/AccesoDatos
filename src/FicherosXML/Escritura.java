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
            eModelo.appendChild(doc.createTextNode("Megane"));
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
            Element cilindradacoche2 = doc.createElement("cilindrada");
            cilindradacoche2.appendChild(doc.createTextNode("1.6"));
            coche2.appendChild(cilindradacoche2);
            
            // Tercer coche
            Element coche3 = doc.createElement("coche");
            eRaiz.appendChild(coche3);
            
            Attr idcoche3 = doc.createAttribute("id");
            idcoche3.setValue("3");
            coche3.setAttributeNode(idcoche3);
            
            Element marcacoche3 = doc.createElement("marca");
            marcacoche3.appendChild(doc.createTextNode("Suzuki"));
            coche3.appendChild(marcacoche3);
            Element modelocoche3 = doc.createElement("modelo");
            modelocoche3.appendChild(doc.createTextNode("Vitara"));
            coche3.appendChild(modelocoche3);
            Element cilindradacoche3 = doc.createElement("cilindrada");
            cilindradacoche3.appendChild(doc.createTextNode("1.9"));
            coche3.appendChild(cilindradacoche3);
            
            // clases necesarias finalizar la creación del archivo XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("coches.xml"));
//            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}