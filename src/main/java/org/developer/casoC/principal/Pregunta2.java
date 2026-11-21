package org.developer.casoC.principal;

import org.developer.casoC.misClases.Alumno;

import java.util.LinkedList;

public class Pregunta2 {

    public static void main(String[] args) {
        LinkedList<Alumno> fila = new LinkedList<>();
        fila.addLast(new Alumno(3045, "Rosa Quispe"));
        fila.addLast(new Alumno(3098, "Luis Barrios"));
        fila.addLast(new Alumno(3120, "Ana Medina"));
        fila.addLast(new Alumno(3162, "Jorge Alva"));
        fila.addLast(new Alumno(3287, "Elena Rojas"));

        System.out.println("LABORATORIO DE COMPUTO - ROTACION DE TURNOS");
        System.out.println("=".repeat(46));
        System.out.println();

        listar("FILA INICIAL (" + fila.size() + ")", fila);
        System.out.println();

        System.out.println("ROTACIONES");
        for (int ronda = 1; ronda <= 3; ronda++) {
            Alumno usa = fila.removeFirst();
            fila.addLast(usa);
            System.out.println("Ronda " + ronda + ": usa la maquina " + usa.getNombre()
                    + " | sigue " + fila.getFirst().getNombre());
        }
        System.out.println();

        listar("FILA DESPUES DE 3 ROTACIONES (" + fila.size() + ")", fila);
        System.out.println();

        Alumno retirado = fila.removeFirst();
        System.out.println("Se retira del laboratorio: " + retirado.getNombre());
        System.out.println();

        listar("FILA FINAL (" + fila.size() + ")", fila);
        System.out.println();
        System.out.println("Proximo en la maquina: " + fila.getFirst().getNombre());
        System.out.println("Ultimo de la fila    : " + fila.getLast().getNombre());
    }

    private static void listar(String titulo, LinkedList<Alumno> fila) {
        System.out.println(titulo);
        System.out.println(Alumno.cabecera());
        for (Alumno alumno : fila) {
            System.out.println(alumno);
        }
    }
}
