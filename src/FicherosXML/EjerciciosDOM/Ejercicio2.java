package FicherosXML.EjerciciosDOM;

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
            Document doc = db.newDocument();
            
            Element raiz = doc.createElement("Servers");
            doc.appendChild(raiz);
            
            Element server = doc.createElement("server");
            raiz.appendChild(server);
            
            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode("algo"));
            server.appendChild(name);
            
            Element port = doc.createElement("port");
            port.appendChild(doc.createTextNode("1111"));
            server.appendChild(port);
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("servers.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}