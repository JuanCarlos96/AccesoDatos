package FicherosTexto.Tanda2;

import java.io.*;

/*
Escribe un programa que cree un nuevo fichero de texto a partir del contenido de todos los
ficheros de texto que se le pasen como argumentos.
*/
public class Ejercicio6 {
    public static void main(String[] args) {
        try{
            for(String s:args){
                File f = new File(s);
                BufferedReader br = new BufferedReader(new FileReader(f));
                String linea;
                BufferedWriter bw = new BufferedWriter(new FileWriter("union.txt",true));
                
                while((linea=br.readLine())!=null){
                    bw.write(linea);
                    bw.newLine();
                }
                br.close();
                bw.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}