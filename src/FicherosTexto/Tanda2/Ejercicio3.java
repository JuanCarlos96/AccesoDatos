package FicherosTexto.Tanda2;

import java.io.*;
import java.util.Scanner;

/*
Escribe un programa que encuentre la palabra más larga en un fichero de texto.
*/
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String fichero;
        System.out.print("Introduce fichero de texto: ");
        fichero = teclado.nextLine();
        try{
            File f = new File(fichero);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea,cad = "";
            
            while((linea=br.readLine())!=null){
                if(linea.split(" ").length>1){
                    for(String s:linea.split(" ")){
                        if(s.length()>cad.length()){
                            cad = s;
                        }
                    }
                }else{
                    if(linea.length()>cad.length()){
                        cad = linea;
                    }
                }
            }
            br.close();
            System.out.println("La palabra más larga es: "+cad);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}