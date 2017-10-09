package FicherosBinarios.Tanda1;

import java.io.*;

/*
Realiza un programa para contar el número de números que existe en el fichero
anterior.
*/
public class Ejercicio2 {
    public static void main(String[] args) {
        int suma = 0;
        
        try{
            BufferedReader br = new BufferedReader(new FileReader("enteros.txt"));
            String linea;
            while((linea=br.readLine())!=null){
                suma++;
            }
            br.close();
            System.out.println("El fichero tiene "+suma+" números");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}