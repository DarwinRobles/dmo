package org.developer.casoC.principal;

import org.developer.casoC.misClases.Alumno;

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

    private static final String ARCHIVO = "datos/bitacora.txt";

    public static void main(String[] args) throws IOException {
        ArrayList<Alumno> ingresos = new ArrayList<>();
        ingresos.add(new Alumno(3045, "Rosa Quispe"));
        ingresos.add(new Alumno(3098, "Luis Barrios"));
        ingresos.add(new Alumno(3120, "Ana Medina"));
        ingresos.add(new Alumno(3162, "Jorge Alva"));
        ingresos.add(new Alumno(3287, "Elena Rojas"));

        System.out.println("LABORATORIO DE COMPUTO - BITACORA");
        System.out.println("=".repeat(40));
        System.out.println();
        
        escribir("BITACORA DE USO - LABORATORIO DE COMPUTO", false);
        escribir("MAQUINA;CODIGO;NOMBRE", true);
        System.out.println("Cabecera escrita: la primera linea va con agregar=false y vacia el archivo");
        System.out.println();

        System.out.println("REGISTRO DE INGRESOS (modo agregado)");
        int n = 1;
        for (Alumno alumno : ingresos) {
            String linea = "PC-" + String.format("%02d", n) + ";"
                    + alumno.getCodigo() + ";" + alumno.getNombre();
            escribir(linea, true);
            System.out.println("Agregado -> " + linea);
            n++;
        }
        System.out.println();

        ArrayList<String> lineas = leer();
        System.out.println("CONTENIDO DE " + ARCHIVO);
        System.out.println("-".repeat(40));
        for (String linea : lineas) {
            System.out.println(linea);
        }
        System.out.println();

        int cabecera = 2;
        System.out.println("Lineas en el archivo : " + lineas.size());
        System.out.println("Lineas de cabecera   : " + cabecera);
        System.out.println("Ingresos registrados : " + (lineas.size() - cabecera));
    }

    private static void escribir(String linea, boolean agregar) throws IOException {
        new File("datos").mkdirs();
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(ARCHIVO, agregar), StandardCharsets.UTF_8))) {
            bw.write(linea);
            bw.newLine();
        }
    }

    private static ArrayList<String> leer() throws IOException {
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(ARCHIVO), StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }
}
