/*
A partir del fichero binario que contenía la clase Persona, escribir un programa que guarde
en un fichero xml todos las personas en dicho fichero.
*/
package FicherosXML.EjEscritura;

import FicherosBinarios.Tanda2.Empleado;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleados.dat"));
            Object obj;
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.newDocument();
            
            Element empleados = doc.createElement("empleados");
            doc.appendChild(empleados);
            
            try{
                while((obj=ois.readObject())!=null){
                    Empleado emp = (Empleado)obj;
                    
                    Element empleado = doc.createElement("empleado");
                    empleados.appendChild(empleado);
                    
                    Element nombre = doc.createElement("nombre");
                    nombre.appendChild(doc.createTextNode(emp.getNombre()));
                    empleado.appendChild(nombre);
                    
                    Element fAlta = doc.createElement("fechaAlta");
                    fAlta.appendChild(doc.createTextNode(emp.getFcontrato()));
                    empleado.appendChild(fAlta);
                    
                    Element fBaja = doc.createElement("fechaDespido");
                    fBaja.appendChild(doc.createTextNode(emp.getFdespido()));
                    empleado.appendChild(fBaja);
                }
            }catch(EOFException ee){}
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("empleados.xml"));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}