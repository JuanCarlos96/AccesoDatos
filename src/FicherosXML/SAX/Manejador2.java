package FicherosXML.SAX;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Manejador2 extends DefaultHandler{
    private BufferedWriter bw;

    public Manejador2() throws IOException {
        this.bw = new BufferedWriter(new FileWriter("class.txt"));
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        try{
            bw.write(String.valueOf(ch,start,length));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        try{
            bw.newLine();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            switch(qName){
                case "student":
                    bw.write("Estudiante no: "+attributes.getValue("rollno"));
                    bw.newLine();
                    break;
                case "firstname":
                    bw.write("Nombre: ");
                    break;
                case "lastname":
                    bw.write("Apellido: ");
                    break;
                case "nickname":
                    bw.write("Apodo: ");
                    break;
                case "marks":
                    bw.write("Notas: ");
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endDocument() throws SAXException {
        try {
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
