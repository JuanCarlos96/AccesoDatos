/*
 Leer un archivo de texto con la clase FileReader
*/
package FicherosTexto;

import java.io.*;

public class Prueba4 {
    public static void main(String[] args) {
        try {
            FileReader f = new FileReader(new File("C:\\Users\\almc\\Desktop\\leeme.txt"));
            int r;
            while((r=f.read())!=-1){
                System.out.println((char)r);
            }
            f.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}