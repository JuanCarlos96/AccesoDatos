package FicherosBinarios.Tanda1;

import java.io.*;
import java.util.Scanner;

/*
Realiza un programa para escribir números enteros por teclado hasta que se
introduzca -1 (que no se incluirá). Dichos números se guardarán en un fichero de
texto.
*/
public class Ejercicio1 {
    public static void main(String[] args) {
        File f = new File("enteros.txt");
        int x;
        Scanner teclado = new Scanner(System.in);
        
        try{
            System.out.println("Introduzca números enteros (-1 para terminar):");
            x = Integer.parseInt(teclado.nextLine());
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            while(x!=-1){
                bw.write(Integer.toString(x));
                bw.newLine();
                x = Integer.parseInt(teclado.nextLine());
            }
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}