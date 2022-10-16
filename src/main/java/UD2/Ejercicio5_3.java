package UD2;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

public class Ejercicio5_3 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // INICIAMOS 'BUFFERED READER' EL CUAL NOS SIRVE PARA LEER LO QUE INTRODUCIMOS POR TECLADO, LO TENEMOS ESTATICO PARA PODER USARLO EN LOS METODOS EXTERNOS A 'MAIN'
    static RandomAccessFile fichero = null; // INICIAMOS EL FICHERO DE ACCESO ALEATORIO, ESTATICO PARA USARLO EN LOS METODOS EXTERNOS A 'MAIN'

    public static void main(String[] args) {
        int num; // INICIAMOS 'NUM', DONDE ALMACENAREMOS EL NÚMERO QUE AÑADIREMOS AL FICHERO BINARIO
        try {
            fichero = new RandomAccessFile("datos.dat", "rw"); // INDICAMOS LA RUTA Y LOS PERMISOS QUE TENDRÁ

            System.out.println("ARCHIVO ORIGINAL.");
            mostrarFichero(); // MOSTRAMOS EL FICHERO

            System.out.println("Ahora añadiremos datos al fichero.");

            System.out.println("Introduce un número entero.");
            num = Integer.parseInt(br.readLine()); // LEEMOS LO QUE QUEREMOS INTRODUCIR
            fichero.seek(fichero.length()); // NOS SITUAMOS AL FINAL DEL FICHERO
            fichero.writeInt(num); // AÑADIMOS

            System.out.println("ARCHIVO MODIFICADO.");
            mostrarFichero(); // MOSTRAMOS EL FICHERO
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fichero != null) {
                    fichero.close(); // CERRAMOS EL FICHERO
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void mostrarFichero() {
        int n; // INICIAMOS VARIABLE 'N'
        try {
            fichero.seek(0); // NOS SITUAMOS AL PRINCIPIO
            while (true) {
                n = fichero.readInt();  // LEEMOS EL NUMERO         
                System.out.println(n); // MOSTRAMOS POR PANTALLA
            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero"); // CON ESTA EXCEPCIÓN INDICAREMOS CUANDO ACABA EL FICHERO, SI NO PONEMOS UN 'SYSO' INDICANDOLO NOS SALDRÁ UNA EXCEPCIÓN
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
