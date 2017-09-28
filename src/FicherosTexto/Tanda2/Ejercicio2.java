package FicherosTexto.Tanda2;

import java.io.*;
import java.util.Scanner;

/*
Escribe un programa que obtenga los ficheros con una extensión específica de una carpeta
específica (que pida por teclado ambos datos).
*/
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String carpeta,ext;
        
        try{
            System.out.print("Introduce carpeta: ");
            carpeta = teclado.nextLine();
            
            System.out.print("Introduce extensión: ");
            ext = teclado.nextLine();
            
            File f = new File(carpeta);
            
            if(f.isDirectory()){
                String[] archivos = f.list(new FilenameFilter() {//Creo un filtro
                    @Override
                    public boolean accept(File dir, String name) {//dir es el directorio padre y name es el archivo que listamos
                        if(name.endsWith(ext))//Si el archivo termina con la extensión que se le pasa devuelve true y lo muestra
                            return true;
                        else//En caso contrario no lo muestra
                            return false;
                    }
                });
                
                for(String s:archivos)
                    System.out.println(s);
            }else
                System.out.println("Error leyendo el directorio");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}