package FicherosBinarios;

import java.io.*;

/*
Leer un archivo binario
*/
public class Leer {
    public static void main(String[] args) {
        File f = new File("binario.dat");
        
        try{
            DataInputStream dis = new DataInputStream(new FileInputStream(f));
            String linea;
            int n;
            try{
                while(true){
                    linea= dis.readUTF();
                    n= dis.readInt();
                    System.out.println(linea);
                    System.out.println(n);
                }
            }catch(Exception ee){}
            dis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}