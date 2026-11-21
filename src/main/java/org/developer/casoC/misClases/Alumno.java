package org.developer.casoC.misClases;

public class Alumno implements Comparable<Alumno> {

    private int codigo;
    private String nombre;

    public Alumno() {
    }

    public Alumno(int codigo, String nombre) {
        setCodigo(codigo);
        setNombre(nombre);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static String cabecera() {
        return String.format("%-8s %-22s", "CODIGO", "NOMBRE");
    }

    @Override
    public String toString() {
        return String.format("%-8d %-22s", codigo, nombre);
    }

    @Override
    public int compareTo(Alumno otro) {
        return Integer.compare(getCodigo(), otro.getCodigo());
    }
}
