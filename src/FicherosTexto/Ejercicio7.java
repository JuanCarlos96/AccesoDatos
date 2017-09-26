package FicherosTexto;

import java.io.*;

public class Ejercicio7 {
    public void leer(File f){
        try{
            BufferedReader br = new BufferedReader(new FileReader(f));
            String[] lineas;
            
            lineas = br.readLine().split("\\*");
            for(String s:lineas)
                System.out.println(s);
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Ejercicio7 ej = new Ejercicio7();
        File f = new File("asteriscos.txt");
        
        ej.leer(f);
    }
}