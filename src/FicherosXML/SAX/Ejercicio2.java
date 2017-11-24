package FicherosXML.SAX;

import java.io.FileInputStream;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new Manejador());
            reader.parse(new InputSource(new FileInputStream("mensajes.xml")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}