package org.developer.casoB.principal;

import org.developer.casoB.misClases.Alumno;

import java.util.ArrayList;
import java.util.Iterator;

public class Pregunta1 {

    public static void main(String[] args) {
        ArrayList<Alumno> padron = new ArrayList<>();
        padron.add(new Alumno(2041, "Rosa Quispe"));
        padron.add(new Alumno(2118, "Luis Barrios"));
        padron.add(new Alumno(2007, " Ana Medina      "));
        padron.add(new Alumno(2260, "Jorge Alva"));
        padron.add(new Alumno(2175, "Elena Rojas"));

        System.out.println("BIBLIOTECA CENTRAL - PADRON DE LECTORES");
        System.out.println("=".repeat(42));
        System.out.println();
        mostrar(padron, "PADRON (" + padron.size() + " lectores)");

        System.out.println();
        System.out.println("INTENTOS RECHAZADOS");
        intentarAlta(padron, 45, "Pedro Luna");
        intentarAlta(padron, 2300, "    ");
        System.out.println("El padron sigue con " + padron.size() + " lectores");

        System.out.println();
        System.out.println("BAJAS");
        System.out.println("Baja 2118: " + eliminar(padron, 2118));
        System.out.println("Baja 2999: " + eliminar(padron, 2999));

        System.out.println();
        mostrar(padron, "PADRON FINAL (" + padron.size() + ")");
    }

    private static void intentarAlta(ArrayList<Alumno> lista, int codigo, String nombre) {
        try {
            lista.add(new Alumno(codigo, nombre));
        } catch (IllegalArgumentException ex) {
            System.out.println("Rechazado -> " + ex.getMessage());
        }
    }

    private static boolean eliminar(ArrayList<Alumno> lista, int codigo) {
        Iterator<Alumno> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next().getCodigo() == codigo) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    private static void mostrar(ArrayList<Alumno> lista, String titulo) {
        System.out.println(titulo);
        System.out.println(Alumno.cabecera());
        for (Alumno alumno : lista) {
            System.out.println(alumno);
        }
    }
}
