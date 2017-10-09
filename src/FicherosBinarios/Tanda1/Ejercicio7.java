package FicherosBinarios.Tanda1;

import java.io.*;

/*
Escribe un programa que saque por pantalla los datos del fichero anterior(agenda2.dat).
*/
public class Ejercicio7 {
    public static void main(String[] args) {
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("agenda2.dat"));
            Object obj;
            
            try{
                while((obj=ois.readObject())!=null){
                    System.out.println(obj);
                }
            }catch(EOFException ee){}
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}