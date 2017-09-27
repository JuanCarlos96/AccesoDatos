/*
 Escribir en un archivo de texto con la clase FileWriter los carácteres pares
*/
package FicherosTexto.Tanda1;

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\almc\\Desktop\\leeme.txt",true);
            String cad = "linea nueva";
            for(int i=1; i<cad.length(); i++) {
                fw.write(cad.charAt(i));
                i++;
            }
            //bf.write(cad);
            fw.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}