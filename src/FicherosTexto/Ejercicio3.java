package FicherosTexto;

import java.io.File;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        char letra,c1;
        File f;
        Scanner teclado = new Scanner(System.in);
        String directorio;
        System.out.println("Introduzca un directorio:");
        try{
            directorio = teclado.next();
            f = new File(directorio);
            if(f.isDirectory()){
                System.out.println("Introduzca letra:");
                letra = teclado.next().charAt(0);
                File[] files = f.listFiles();
                for(File g:files){
                    c1 = g.getName().charAt(0);
                    if(c1 == letra){
                        System.out.println(g);
                    }
                }
            }else{
                System.out.println("No has introducido un directorio");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}