package UD2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Ejercicio5_1 {

    public static void main(String[] args) {
        FileReader fr = null; // INICIAMOS LA VARIABLE PARA PODER LEER EL ARCHIVO
        File archivo = null; // INICIAMOS VARIBLE PARA INDICAR EL ARCHIVO

        String ruta; // AQUI ALMACENAREMOS LA RUTA
        try {
            ruta = "AlvaroFernandezdecordova.txt"; // EN ESTE CASO SOLO PONGO EL NOMBRE PORQUE EL ARCHIVO ESTA EN LA CARPETA DEL PROYECTO
            archivo = new File(ruta); // INDICAMOS QUE EL ARCHIVOS ESTA EN ESA 'RUTA'

            fr = new FileReader(archivo); // E INDICAMOS QUE VAMOS A LEERLO CON LA VARIABLE 'FR'

            int caracter = fr.read(); // EN LA VARIABLE 'CARACTER' SE ALMACENARÁ LO QUE EL PROGRAMA LEA

            while (caracter != -1) { // SI NO QUEDAN CARACTERES SE SALDRÁ DEL BUCLE
                if (caracter != 32) { // SI EL CARACTER EL DISTINTO A '32' LO MOSTRARÁ, YA QUE EL ESPACIO EN EL 'CODIGO ASCII' SU VALOR ES '32'
                    System.out.print((char) caracter); // MOSTRAMOS
                }
                caracter = fr.read(); // SIGUE LEYENDO CARACTERES
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
