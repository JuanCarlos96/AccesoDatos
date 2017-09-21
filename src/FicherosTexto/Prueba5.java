/*
 Leer un archivo de texto con la clase BufferedReader
*/
package FicherosTexto;

import java.io.*;

public class Prueba5 {
    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(new File("C:\\Users\\almc\\Desktop\\leeme.txt")));
            String cad = null;
            while((cad = bf.readLine())!=null){
                System.out.println(cad);
            }
            bf.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}