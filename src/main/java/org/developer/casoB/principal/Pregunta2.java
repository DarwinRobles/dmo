package org.developer.casoB.principal;

import org.developer.casoB.misClases.Alumno;

import java.util.LinkedList;

public class Pregunta2 {

    public static void main(String[] args) {
        LinkedList<Alumno> pila = new LinkedList<>();

        System.out.println("BIBLIOTECA CENTRAL - PILA DE DEVOLUCIONES");
        System.out.println("=".repeat(44));
        System.out.println();
        System.out.println("LLEGADA AL MOSTRADOR");
        apilar(pila, new Alumno(2041, "Rosa Quispe"));
        apilar(pila, new Alumno(2118, "Luis Barrios"));
        apilar(pila, new Alumno(2007, "Ana Medina"));
        apilar(pila, new Alumno(2260, "Jorge Alva"));
        apilar(pila, new Alumno(2175, "Elena Rojas"));

        System.out.println();
        mostrar(pila, "PILA (" + pila.size() + " devoluciones)");
        System.out.println("Tope de la pila : " + pila.getFirst().getNombre());
        System.out.println("Fondo de la pila: " + pila.getLast().getNombre());

        System.out.println();
        System.out.println("REINGRESO A ESTANTE (se procesa el tope)");
        for (int paso = 1; paso <= 3; paso++) {
            Alumno alumno = pila.removeFirst();
            System.out.println("Paso " + paso + ": " + alumno.getCodigo() + " - " + alumno.getNombre());
        }

        System.out.println();
        mostrar(pila, "PENDIENTES (" + pila.size() + ")");

        System.out.println();
        System.out.println("Orden de llegada : Rosa, Luis, Ana, Jorge, Elena");
        System.out.println("Orden de salida : Elena, Jorge, Ana (ultimo que llega, primero que sale)");
    }

    private static void apilar(LinkedList<Alumno> pila, Alumno alumno) {
        pila.addFirst(alumno);
        System.out.println("Devuelve " + alumno.getNombre() + " -> la pila tiene " + pila.size());
    }

    private static void mostrar(LinkedList<Alumno> pila, String titulo) {
        System.out.println(titulo);
        System.out.println(Alumno.cabecera());
        for (Alumno alumno : pila) {
            System.out.println(alumno);
        }
    }
}
