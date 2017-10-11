package FicherosBinarios.Tanda2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio2 {
    public static void main(String[] args) {
        Empleado pepe = new Empleado("Pepe","2005/07/14","2006/01/20");
        Empleado alfonso = new Empleado("Alfonso","2004/05/18","2004/05/17");
        Empleado maria = new Empleado("María","2001/12/31","2001/12/30");
        Empleado ana = new Empleado("Ana","2007/11/06","2013/02/13");
        try{
            //Creación del fichero principal
            ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("empleados.dat"));
            oos1.writeObject(pepe);
            oos1.writeObject(alfonso);
            oos1.writeObject(maria);
            oos1.writeObject(ana);
            oos1.close();
            
            //Lectura del fichero principal y creación del segundo fichero
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleados.dat"));
                ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("empleados2.dat"));
                Object obj;
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Date fecha1;
                Date fecha2;
                
                while((obj=ois.readObject())!=null){
                    Empleado emp = (Empleado)obj;
                    fecha1 = sdf.parse(emp.getFcontrato());
                    fecha2 = sdf.parse(emp.getFdespido());
                    
                    if(fecha1.before(fecha2)){
                        oos2.writeObject(emp);
                    }
                }
                oos2.close();
                ois.close();
            }catch(EOFException eofe){}
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}