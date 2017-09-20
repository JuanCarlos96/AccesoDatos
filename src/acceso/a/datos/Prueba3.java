/*
    Hacer un programa que cree un directorio en el directorio actual y a continuación
    cree dos ficheros de texto en ese directorio con cualquier nombre
 */
package acceso.a.datos;

import java.io.File;
import java.io.IOException;

public class Prueba3 {
    public static void main(String[] args) throws IOException {
        File f = new File("MiCarpeta");
        File f2 = new File(f.getAbsolutePath()+"\\fichero1.txt");
        File f3 = new File(f.getAbsolutePath()+"\\fichero2.txt");
        
        System.out.println(f.mkdir());
        System.out.println(f2.createNewFile());
        System.out.println(f3.createNewFile());
    }
}