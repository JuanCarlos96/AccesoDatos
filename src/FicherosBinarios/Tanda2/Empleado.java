package FicherosBinarios.Tanda2;

import java.io.Serializable;

public class Empleado implements Serializable{
    String nombre,fcontrato,fdespido;

    public Empleado(String nombre, String fcontrato, String fdespido) {
        this.nombre = nombre;
        this.fcontrato = fcontrato;
        this.fdespido = fdespido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFcontrato() {
        return fcontrato;
    }

    public String getFdespido() {
        return fdespido;
    }

    @Override
    public String toString() {
        return getNombre()+"  "+getFcontrato()+"  "+getFdespido();
    }
}