package FicherosBinarios.Tanda1;

import java.io.*;

/*
Escribe un programa que escriba en un fichero binario una agenda de nombres
de amigos con su fecha de cumpleaños. No se pasarán como parámetro. Inventad
una serie de datos y guardadlos en arrays.
*/
public class Ejercicio4 {
    public static void main(String[] args) {
        String[] amigos = {"Jaime","Ana","Maria","Ruben","Miriam"};
        String[] fecha = {"07/05/2003","17/04/1998","02/10/2002","18/09/1997","05/12/1996"};
        
        try{
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("agenda.dat"));
            for(int i=0; i<amigos.length; i++){
                dos.writeUTF(amigos[i]);
                dos.writeUTF(fecha[i]);
            }
            dos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}