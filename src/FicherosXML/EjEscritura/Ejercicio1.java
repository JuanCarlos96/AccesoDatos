package FicherosXML.EjEscritura;
/*
Realiza un programa que escriba un fichero xml con la siguiente forma:
<persona>
<nombre>Luis Piripi</persona>
<edad>35</edad>
<url href="http://www.piriri.com/luis"/>
</persona>
*/
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
            
            Element raiz = doc.createElement("persona");
            doc.appendChild(raiz);
            
            Element nombre = doc.createElement("nombre");
            nombre.appendChild(doc.createTextNode("Luis Piripi"));
            raiz.appendChild(nombre);
            
            Element edad = doc.createElement("edad");
            edad.appendChild(doc.createTextNode("35"));
            raiz.appendChild(edad);
            
            Element url = doc.createElement("url");
            raiz.appendChild(url);
            
            Attr href = doc.createAttribute("href");
            href.setValue("http://www.piriri.com/luis");
            url.setAttributeNode(href);
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("persona.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}