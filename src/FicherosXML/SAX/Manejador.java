package FicherosXML.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Manejador extends DefaultHandler{

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("\nAbriendo etiqueta '"+qName+"'");
        System.out.println("Atributos: "+attributes.getLength());
        
        for(int i=0; i<attributes.getLength(); i++) {
            System.out.print("    Nombre: "+attributes.getQName(i));
            System.out.println("    Valor: "+attributes.getValue(i));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Leyendo texto: "+String.valueOf(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Cerrando etiqueta '"+qName+"'");
    }
}