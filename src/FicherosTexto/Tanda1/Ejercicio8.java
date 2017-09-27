package FicherosTexto.Tanda1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio8 {
    public void ordenar(File f){
        try{
            BufferedReader br = new BufferedReader(new FileReader(f));
            String cad = null;
            ArrayList<String> lineas = new ArrayList();
            
            while((cad=br.readLine())!=null)
                lineas.add(cad);
            br.close();
            
            Collections.sort(lineas);
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            
            for(String s:lineas){
                bw.write(s);
                bw.newLine();
            }
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Ejercicio8 ej = new Ejercicio8();
        File f = new File("ordename.txt");
        
        ej.ordenar(f);
    }
}