package UD2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class Ejercicio5_3 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        File archivo = null;

        RandomAccessFile fichero = null;

        DataOutputStream salida = null;

        String ruta;

        try {
            ruta = "C:\\Users\\Alvaro\\OneDrive\\2DAM\\Acceso a Datos\\Unidad 2 - Ficheros\\Ejercicio 5\\datos.dat";
            archivo = new File(ruta);
            fichero = new RandomAccessFile(archivo, "rw");

            System.out.println("ARCHIVO ORIGINAL.");

            System.out.println(viewFile(fichero));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int viewFile(RandomAccessFile archivo) {
        try {
            int n;
            archivo.seek(0); // NOS SITUAMOS AL PRINCIPIO
            while (true) {
                n = archivo.readInt();
                return n;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
