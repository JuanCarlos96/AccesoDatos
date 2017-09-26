package FicherosTexto;

import java.io.*;

public class Ejercicio6 {
    public void escribir(String[] cadenas){
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("asteriscos.txt"));
            for(int i=0; i<cadenas.length-1; i++){
                bw.write(cadenas[i]);
                bw.write("*");
            }
            bw.write(cadenas[cadenas.length-1]);
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Ejercicio6 ej = new Ejercicio6();
        String[] frase = {"hola","esto","es","una","frase","separada","por","asteriscos"};
        
        ej.escribir(frase);
    }
}