package acceso.a.datos;

import java.io.File;

/*
    Sacar la siguiente información del fichero o carpeta que se la pase como argumento:
    Nombre del fichero
    Ruta del fichero
    Permisos de escritura
    Permisos de lectura
    Tamaño
    Si es directorio o fichero
*/

public class Prueba2 {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\almc\\Documents\\NetBeansProjects\\Acceso a Datos\\build.xml");
        System.out.println("Nombre del fichero o carpeta: "+f.getName());
        System.out.println("Ruta del fichero o carpeta: "+f.getAbsolutePath());
        System.out.println("Permisos de escritura: "+(f.canWrite()?"Sí":"No"));
        System.out.println("Permisos de lectura: "+(f.canRead()?"Sí":"No"));
        System.out.println("Tamaño: "+f.length());
        System.out.println("Es un directorio: "+(f.isDirectory()?"Sí":"No"));
        System.out.println("Es un fichero: "+(f.isFile()?"Sí":"No"));
    }
}