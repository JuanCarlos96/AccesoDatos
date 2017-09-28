package FicherosTexto.Tanda2;

import java.io.*;

/*
Escribe un programa a que cuente el número de líneas en cada fichero que se le pasa como
argumento. Si un error ocurre mientras se lee alguno de los ficheros, se deberá imprimir un mensaje
de error, pero se debe continuar de procesar el resto de ficheros.
*/
public class Ejercicio1 {
    public static void main(String[] args) {
        for(String s:args){
            int suma = 0;
            File f = new File(s);
            
            if(f.isFile()){
                try{
                    BufferedReader br = new BufferedReader(new FileReader(f));
                    while(br.readLine()!=null)
                        suma += 1;
                    System.out.println("El fichero "+f.getName()+" tiene "+suma+" líneas");
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                System.out.println("Error leyendo el fichero "+f.getName());
            }
        }
    }
}