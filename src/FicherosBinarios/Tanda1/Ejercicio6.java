package FicherosBinarios.Tanda1;

import java.io.*;
import java.util.ArrayList;

/*
Escribe el programa del ejercicio 4 pero usando objetos a la hora de guardar los
datos.
*/
public class Ejercicio6 {
    public static void main(String[] args) {
        Amigo jaime = new Amigo("Jaime","07/05/2003");
        Amigo ana = new Amigo("Ana","17/04/1998");
        Amigo maria = new Amigo("Maria","02/10/2002");
        Amigo ruben = new Amigo("Ruben","18/09/1997");
        Amigo miriam = new Amigo("Miriam","05/12/1996");
        
        ArrayList<Amigo> lista = new ArrayList();
        lista.add(jaime);
        lista.add(ana);
        lista.add(maria);
        lista.add(ruben);
        lista.add(miriam);
        
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("agenda2.dat"));
            for(Amigo a:lista){
                oos.writeObject(a);
            }
            oos.close();
        }catch(Exception e){
            
        }
    }
}