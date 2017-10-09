package FicherosBinarios.Tanda1;

import java.io.*;
import java.util.Scanner;

/*
Realiza un programa para copiar un fichero binario en otro. Tanto el fichero
original como el nombre del destino se pasarán por parámetro.
*/
public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String origen,destino;
        
        System.out.print("Introduce nombre de archivo binario: ");
        origen = teclado.nextLine();
        System.out.print("Introduce nombre de copia del archivo: ");
        destino = teclado.nextLine();
        
        try{
            DataInputStream dis = new DataInputStream(new FileInputStream(origen));
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(destino));
            int i;
            byte[] b = new byte[2048];
            
            while((i=dis.read(b))>0){
                dos.write(b, 0, i);
            }
            dos.close();
            dis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}