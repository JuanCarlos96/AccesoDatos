package FicherosTexto.Tanda2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
Escribe un programa que muestre las veces que aparece cada palabra en un fichero de texto.
*/
public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String fichero;
        ArrayList<String> palabras = new ArrayList();
        ArrayList<String> encontradas = new ArrayList();
        HashSet hs = new HashSet();
        System.out.print("Introduce fichero de texto: ");
        fichero = teclado.nextLine();
        try{
            File f = new File(fichero);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String linea;
            while((linea=br.readLine())!=null){
                if(linea.split(" ").length>1){
                    for(String s:linea.split(" ")){
                        palabras.add(s);
                    }
                }else{
                    palabras.add(linea);
                }
            }
            br.close();
            
            hs.addAll(palabras);//añado los objetos sin repetirlos
            encontradas.addAll(hs);//los objetos sin repetir los añado a otro arraylist
            
            for(int i=0; i<encontradas.size(); i++){
                int suma = 0,x = 0;
                for(String s:palabras){
                    if(encontradas.get(i).equals(palabras.get(x))){
                        suma+=1;
                    }
                    x+=1;
                }
                System.out.println("La palabra "+encontradas.get(i)+" aparece "+suma+" veces");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}