package FicherosBinarios;

import java.io.*;

/*
Escribir dos arrays en un fichero binario
*/
public class Escribir {
    public static void main(String[] args) {
        File f = new File("binario.dat");
        String[] palabras = {"hola","esto","es","un","array","de","cadenas"};
        int[] numeros = {0,1,2,3,4,5,6};
        try{
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
            for(int i=0; i<7; i++){
                dos.writeUTF(palabras[i]);
                dos.writeInt(numeros[i]);
            }
            dos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}