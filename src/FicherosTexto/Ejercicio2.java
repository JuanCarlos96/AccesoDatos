package FicherosTexto;

import java.io.File;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String ruta,nombre;
        File f,g;
        
        System.out.println("Introduzca ruta del archivo:");
        try{
            ruta = teclado.next();
            f = new File(ruta);
            System.out.println("Introduzca nuevo nombre:");
            nombre = teclado.next();
            g = new File(nombre);
            f.renameTo(g);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}