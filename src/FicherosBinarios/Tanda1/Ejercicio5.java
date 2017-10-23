package FicherosBinarios.Tanda1;

import java.io.*;

/*
Escribe un programa que saque por pantalla los datos del fichero anterior.
*/
public class Ejercicio5 {
    public static void main(String[] args) {
        try{
            DataInputStream dis = new DataInputStream(new FileInputStream("agenda.dat"));
            String linea;
            
            try{
                while(true){
                    linea=dis.readUTF();
                    System.out.println(linea);
                }
            }catch(EOFException ee){}
            dis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}