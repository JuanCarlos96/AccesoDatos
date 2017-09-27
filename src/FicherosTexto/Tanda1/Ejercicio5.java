package FicherosTexto.Tanda1;

import java.io.*;
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        int suma=0;
        String cad,linea=null;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca archivo:");
        cad = teclado.next();
        try{
            File f = new File(cad);
            BufferedReader br = new BufferedReader(new FileReader(f));
            if(f.isFile()){
                while((linea=br.readLine())!=null){
                    suma+=Integer.parseInt(linea);
                }
                System.out.println("La suma de los números del fichero "+f.getName()+" es: "+suma);
            }else{
                System.out.println("No has introducido un fichero");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}