package org.developer.casoB.misClases;

public class Alumno {

    public static final int CODIGO_MINIMO = 1000;
    public static final int CODIGO_MAXIMO = 9999;

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
        if (codigo < CODIGO_MINIMO || codigo > CODIGO_MAXIMO) {
            throw new IllegalArgumentException("codigo fuera de rango: " + codigo);
        }
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("nombre vacio");
        }
        this.nombre = nombre.trim();
    }

    public static String cabecera() {
        return String.format("%-8s %-22s", "CODIGO", "NOMBRE");
    }

    @Override
    public String toString() {
        return String.format("%-8d %-22s", codigo, nombre);
    }
}
