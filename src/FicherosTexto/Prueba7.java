/*
 Escribir en un archivo de texto con la clase FileWriter
*/
package FicherosTexto;

import java.io.*;

public class Prueba7 {
    public static void main(String[] args) {
        try {
            FileWriter bf = new FileWriter("C:\\Users\\almc\\Desktop\\leeme.txt",true);
            String cad = "linea nueva";
            bf.write(cad);
            bf.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}