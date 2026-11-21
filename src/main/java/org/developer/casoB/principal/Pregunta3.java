package org.developer.casoB.principal;

import org.developer.casoB.misClases.Alumno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Pregunta3 {

    private static final String DATOS = "datos/lectores.txt";
    private static final String REPORTE = "datos/reporte_lectores.txt";

    public static void main(String[] args) throws IOException {
        ArrayList<Alumno> lectores = new ArrayList<>();
        lectores.add(new Alumno(2041, "Rosa Quispe"));
        lectores.add(new Alumno(2118, "Luis Barrios"));
        lectores.add(new Alumno(2007, "Ana Medina"));
        lectores.add(new Alumno(2260, "Jorge Alva"));
        lectores.add(new Alumno(2175, "Elena Rojas"));
        lectores.add(new Alumno(2099, "Marco Tello"));

        new File("datos").mkdirs();
        grabarDatos(lectores);

        ArrayList<Alumno> leidos = leerDatos();
        grabarReporte(leidos);

        System.out.println("BIBLIOTECA CENTRAL - DATOS Y REPORTE");
        System.out.println("=".repeat(42));
        System.out.println();
        System.out.println("Archivo de datos : " + DATOS + " (" + contarLineas(DATOS) + " lineas)");
        System.out.println("Registros leidos : " + leidos.size());
        System.out.println("Archivo de reporte: " + REPORTE);
        System.out.println();
        mostrarArchivo(REPORTE);
    }

    private static void grabarDatos(ArrayList<Alumno> lectores) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(DATOS, false), StandardCharsets.UTF_8))) {
            for (Alumno alumno : lectores) {
                bw.write(alumno.getCodigo() + ";" + alumno.getNombre());
                bw.newLine();
            }
        }
    }

    private static ArrayList<Alumno> leerDatos() throws IOException {
        ArrayList<Alumno> leidos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(DATOS), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                leidos.add(new Alumno(Integer.parseInt(partes[0]), partes[1]));
            }
        }
        return leidos;
    }

    private static void grabarReporte(ArrayList<Alumno> leidos) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(REPORTE, false), StandardCharsets.UTF_8))) {
            bw.write("REPORTE DE LECTORES - BIBLIOTECA CENTRAL");
            bw.newLine();
            bw.write(Alumno.cabecera());
            bw.newLine();
            for (Alumno alumno : leidos) {
                bw.write(alumno.toString());
                bw.newLine();
            }
            bw.write("TOTAL DE LECTORES: " + leidos.size());
            bw.newLine();
        }
    }

    private static int contarLineas(String ruta) throws IOException {
        int lineas = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(ruta), StandardCharsets.UTF_8))) {
            while (br.readLine() != null) {
                lineas++;
            }
        }
        return lineas;
    }

    private static void mostrarArchivo(String ruta) throws IOException {
        System.out.println("CONTENIDO DE " + ruta);
        System.out.println("-".repeat(42));
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(ruta), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }
}
