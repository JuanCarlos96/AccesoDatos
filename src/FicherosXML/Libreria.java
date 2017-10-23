package FicherosXML;
/*
Crea un esquema xml para guardar los libros de una librería, los campos que debe tener son:
título, autor, ISBN, nº ejemplares, editorial, nº páginas y año de edición. Decidir cuales
de esos campos son atributos xml o elementos xml
*/
import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class Libreria {
    public static void main(String[] args) {
        try{
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.newDocument();
            
            Element raiz = doc.createElement("libreria");
            doc.appendChild(raiz);
            
            Element libro = doc.createElement("libro");
            raiz.appendChild(libro);
            
            Attr isbn = doc.createAttribute("ISBN");
            //isbn.setValue(value);
            libro.setAttributeNode(isbn);
            
            Element titulo = doc.createElement("titulo");
            //titulo.appendChild(doc.createTextNode(data));
            libro.appendChild(titulo);
            
            Element autor = doc.createElement("autor");
            //autor.appendChild(doc.createTextNode(data));
            libro.appendChild(autor);
            
            Element editorial = doc.createElement("editorial");
            //editorial.appendChild(doc.createTextNode(data));
            libro.appendChild(editorial);
            
            Element ejemplares = doc.createElement("nEjemplares");
            //ejemplares.appendChild(doc.createTextNode(data));
            libro.appendChild(ejemplares);
            
            Element paginas = doc.createElement("nPaginas");
            //paginas.appendChild(doc.createTextNode(data));
            libro.appendChild(paginas);
            
            Element edicion = doc.createElement("fechaEdicion");
            //edicion.appendChild(doc.createTextNode(data));
            libro.appendChild(edicion);
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("libreria.xml"));
            //transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}