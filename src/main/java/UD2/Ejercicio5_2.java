package UD2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;

public class Ejercicio5_2 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            FileReader fr = null;

            FileWriter fw = null;
            PrintWriter pw = null;

            File archivo = null;

            String ruta;

            System.out.println("--- MENÚ ---");
            System.out.println("1. Crear un fichero.");
            System.out.println("2. Mostrar contenido de un fichero.");
            System.out.println("3. Escribir al final de un fichero.");
            System.out.println("4. Salir.");
            System.out.print("Elige una opción: ");
            int opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    ruta = "C:\\Users\\fernandez.coalv\\OneDrive\\2DAM\\Acceso a Datos\\Unidad 2 - Ficheros\\Ejercicio 5\\holasucolega.txt";
                    archivo = new File(ruta);

                    if (!archivo.exists()) {
                        archivo.createNewFile();
                    } else {
                        System.out.println("No se ha podido crear el archivo o ya existe.");
                    }
                case 2:
                    ruta = "C:\\Users\\fernandez.coalv\\OneDrive\\2DAM\\Acceso a Datos\\Unidad 2 - Ficheros\\Ejercicio 5\\ejercicio5.txt";
                    archivo = new File(ruta);

                    if (!archivo.exists()) {
                        System.out.println("El archivo no existe.");
                    } else {
                        fr = new FileReader(archivo);
                        br = new BufferedReader(fr);

                        String linea = br.readLine();

                        while (linea != null) {
                            System.out.println(linea);
                            linea = br.readLine();
                        }
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }
}
