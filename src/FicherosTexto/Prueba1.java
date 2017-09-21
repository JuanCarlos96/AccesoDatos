package FicherosTexto;

import java.io.File;

public class Prueba1 {
    public static void main(String[] args) {
        File f = new File(args[0]);
        String[] archivos = f.list();
        for(int i=0; i<archivos.length; i++) {
            System.out.println(archivos[i]);
        }
    }
}