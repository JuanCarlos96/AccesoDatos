/*
Realiza un programa que escriba un fichero xml con la siguiente forma:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<company>
<employee id="10">
<firstname>Jaime</firstname>
<lastname>Florin</lastname>
<email>jaime@example.org</email>
<department>Recursos Humanos</department>
</employee>
</company>
*/
package FicherosXML.EjEscritura;

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
            
            Element company = doc.createElement("company");
            doc.appendChild(company);
            
            Element employee = doc.createElement("employee");
            company.appendChild(employee);
            
            Attr id = doc.createAttribute("id");
            id.setValue("10");
            employee.setAttributeNode(id);
            
            Element firstname = doc.createElement("firstname");
            firstname.appendChild(doc.createTextNode("Jaime"));
            employee.appendChild(firstname);
            
            Element lastname = doc.createElement("lastname");
            lastname.appendChild(doc.createTextNode("Florin"));
            employee.appendChild(lastname);
            
            Element email = doc.createElement("email");
            email.appendChild(doc.createTextNode("jaime@example.org"));
            employee.appendChild(email);
            
            Element department = doc.createElement("department");
            department.appendChild(doc.createTextNode("Recursos Humanos"));
            employee.appendChild(department);
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("company.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}