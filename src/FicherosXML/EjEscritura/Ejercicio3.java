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
                    
                    
                }
            }catch(EOFException ee){}
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}