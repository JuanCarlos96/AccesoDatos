package FicherosTexto.Tanda2;

import java.io.*;
import java.util.Scanner;

/*
Escribe un programa que cuente el número de palabras de un fichero de texto.
*/
public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String fichero;
        System.out.print("Introduce fichero de texto: ");
        fichero = teclado.nextLine();
        try{
            File f = new File(fichero);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea;
            int suma = 0;
            while((linea=br.readLine())!=null){
                if(linea.split(" ").length>1){
                    for(String s:linea.split(" ")){
                        suma+=1;
                    }
                }else{
                    suma+=1;
                }
            }
            br.close();
            System.out.println("El fichero contiene "+suma+" palabras");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}