package FicherosTexto;

import java.io.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\almc\\Desktop\\numNaturales.txt"));
            for(int i=1; i<=50; i++){
                bw.write(Integer.toString(i));
                bw.newLine();
            }
            bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}