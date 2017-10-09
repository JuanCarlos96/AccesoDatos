package FicherosBinarios.Tanda1;

import java.io.*;
import java.util.Scanner;

/*
Realiza un programa para copiar un fichero binario en otro. Tanto el fichero
original como el nombre del destino se pasarán por parámetro.
*/
public class Ejercicio3b {
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
            byte i;
            
            try{
                while(true){
                    i=dis.readByte();
                    dos.writeByte(i);
                }
            }catch(EOFException ee){}
            dos.close();
            dis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}