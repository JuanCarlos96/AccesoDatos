package FicherosTexto;

import java.io.*;

public class Ejercicio6 {
    public static void escribir(String[] cadenas){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\almc\\Desktop\\asteriscos.txt"));
            for(int i=0; i<cadenas.length-1; i++){
                bw.write(cadenas[i]);
                bw.write("*");
            }
            bw.write(cadenas[cadenas.length]);
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
    }
}