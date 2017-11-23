package FicherosXML.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Manejador extends DefaultHandler{

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Abriendo etiqueta...");
        System.out.println("URI: "+uri);
        System.out.println("LocalName: "+localName);
        System.out.println("qName: "+qName);
        System.out.println("Atributos: "+attributes.getLength());
        
        for(int i=0; i<attributes.getLength(); i++) {
            System.out.println("Nombre: "+attributes.getQName(i));
            System.out.println("Valor: "+attributes.getValue(i));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Leyendo texto dentro de etiqueta...");
        System.out.println("Texto: "+String.valueOf(ch, start, start));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Cerrando etiqueta...");
        System.out.println("URI: "+uri);
        System.out.println("LocalName: "+localName);
        System.out.println("qName: "+qName);
    }
}