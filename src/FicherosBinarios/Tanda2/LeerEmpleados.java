package FicherosBinarios.Tanda2;

import java.io.*;

public class LeerEmpleados {
    public static void main(String[] args) {
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleados.dat"));
            Object obj;
            
            try{
                while((obj=ois.readObject())!=null){
                    System.out.println(obj);
                }
            }catch(EOFException ee){}
        }catch(Exception e){
            e.printStackTrace();
        }
        
        System.out.println("\n");
        
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleados2.dat"));
            Object obj;
            
            try{
                while((obj=ois.readObject())!=null){
                    System.out.println(obj);
                }
            }catch(EOFException ee){}
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}