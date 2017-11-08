package FicherosXML.EjerciciosDOM;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        try{
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse("mdb.xml");
            
            doc.getDocumentElement().normalize();
            
            System.out.println("Elemento raíz: "+doc.getChildNodes().item(0).getNodeName());
            
            Element movies = (Element) doc.getElementsByTagName("movies").item(0);
            System.out.println("\nPelículas");
            
            Element movie = (Element) movies.getElementsByTagName("movie").item(0);
            System.out.println("Película id="+movie.getAttribute("id"));
            System.out.println("Título: "+movie.getElementsByTagName("title").item(0).getTextContent());
            System.out.println("Año: "+movie.getElementsByTagName("year").item(0).getTextContent());
            System.out.println("\nDirectores");
            
            Element director = (Element) movie.getElementsByTagName("director").item(0);
            System.out.println(director.getAttribute("idref"));
            System.out.println("\nGéneros");
            System.out.println(movie.getElementsByTagName("genre").item(0).getTextContent());
            System.out.println(movie.getElementsByTagName("genre").item(1).getTextContent());
            System.out.println("\nCast");
            
            Element actor = (Element) movie.getElementsByTagName("actor").item(0);
            System.out.println("Actor: "+actor.getAttribute("idref"));
            System.out.println("Personaje: "+movie.getElementsByTagName("role").item(0).getTextContent());
            
            Element performer = (Element) doc.getElementsByTagName("performer").item(1);
            System.out.println("\nPerformer id="+performer.getAttribute("id"));
            System.out.println("Nombre: "+performer.getElementsByTagName("name").item(0).getTextContent());
            System.out.println("Fecha de nacimiento: "+performer.getElementsByTagName("dob").item(0).getTextContent());
            System.out.println("Lugar de nacimiento: "+performer.getElementsByTagName("pob").item(0).getTextContent());
            System.out.println("Ha actuado en:");
            
            Element peli = (Element) performer.getElementsByTagName("movie").item(0);
            System.out.println(peli.getAttribute("idref"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}