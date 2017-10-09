package FicherosBinarios.Tanda1;

import java.io.Serializable;


public class Amigo implements Serializable{
    String nombre,fecha;

    public Amigo(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return getNombre()+" cumple años en "+getFecha();
    }
}