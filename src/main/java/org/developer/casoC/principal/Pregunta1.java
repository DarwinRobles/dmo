package org.developer.casoC.principal;

import org.developer.casoC.misClases.Alumno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Pregunta1 {

    public static void main(String[] args) {
        ArrayList<Alumno> usuarios = new ArrayList<>();
        usuarios.add(new Alumno(3120, "Rosa Quispe"));
        usuarios.add(new Alumno(3045, "Luis Barrios"));
        usuarios.add(new Alumno(3287, "Ana Medina"));
        usuarios.add(new Alumno(3003, "Jorge Alva"));
        usuarios.add(new Alumno(3162, "Elena Rojas"));
        usuarios.add(new Alumno(3098, "Marco Tello"));

        System.out.println("LABORATORIO DE COMPUTO - USUARIOS");
        System.out.println("=".repeat(40));
        System.out.println();

        listar("ORDEN DE REGISTRO", usuarios);
        System.out.println();

        Collections.sort(usuarios);
        listar("POR CODIGO ASCENDENTE (orden natural)", usuarios);
        System.out.println();

        Collections.sort(usuarios, Comparator.comparing(Alumno::getNombre));
        listar("POR NOMBRE ALFABETICO (Comparator)", usuarios);
        System.out.println();

        Collections.sort(usuarios, Comparator.comparingInt(Alumno::getCodigo).reversed());
        listar("POR CODIGO DESCENDENTE (Comparator invertido)", usuarios);
        System.out.println();

        System.out.println("Codigo mayor: " + Collections.max(usuarios).getCodigo());
        System.out.println("Codigo menor: " + Collections.min(usuarios).getCodigo());
    }

    private static void listar(String titulo, ArrayList<Alumno> lista) {
        System.out.println(titulo);
        System.out.println(Alumno.cabecera());
        for (Alumno alumno : lista) {
            System.out.println(alumno);
        }
    }
}
