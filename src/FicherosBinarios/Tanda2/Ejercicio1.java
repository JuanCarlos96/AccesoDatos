package FicherosBinarios.Tanda2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio1 {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new FileReader("empleados.txt"));
            String linea;
            
            BufferedWriter bw = new BufferedWriter(new FileWriter("empleados2.txt"));
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date fecha1;
            Date fecha2;
            while((linea=br.readLine())!=null){
                String[] datos = linea.split("  ");
                fecha1 = sdf.parse(datos[1]);
                fecha2 = sdf.parse(datos[2]);
                
                if(fecha1.before(fecha2)){
                    bw.write(linea);
                    bw.newLine();
                }
            }
            bw.close();
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}