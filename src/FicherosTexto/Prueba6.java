/*
 Escribir en un archivo de texto con la clase BufferedWriter
*/
package FicherosTexto;

import java.io.*;

public class Prueba6 {
    public static void main(String[] args) {
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter("C:\\Users\\almc\\Desktop\\leeme.txt",true));
            String cad = "linea nueva";
            bf.newLine();
            bf.write(cad);
            bf.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}