package UD2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejercicio5_2 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // INICIAMOS 'BUFFERED READER' EL CUAL NOS SIRVE PARA LEER LO QUE INTRODUCIMOS POR TECLADO

            FileReader fr = null; // INICIAMOS VARIABLE PARA LEER EL ARCHIVO

            FileWriter fw = null; // INICIAMOS VARIABLE PARA INDICAR QUE ARCHIVO ES EN EL QUE VAMOS A ESCRIBIR 
            PrintWriter pw = null; // INICIAMOS VARIABLE PARA PODER ESCRIBIR EN EL ARCHIVO

            File archivo = null; // INICIAMOS VARIABLE PARA INDICAR CUAL ES EL ARCHIVO

            String ruta; // ALMACENAREMOS LA RUTA DEL ARCHIVO

            System.out.println("--- MENÚ ---");
            System.out.println("1. Crear un fichero.");
            System.out.println("2. Mostrar contenido de un fichero.");
            System.out.println("3. Escribir al final de un fichero.");
            System.out.println("4. Salir.");
            System.out.print("Elige una opción: ");
            int opcion = Integer.parseInt(br.readLine()); // AQUI ALMACENAREMOS QUE OPCION DEL MENU ESCOGEMOS

            switch (opcion) { // INICIAMOS EL 'SWITCH'
                case 1: // OPCIÓN 1
                    try {
                    ruta = "ejercicio5-1.txt"; // INDICAMOS EL NOMBRE DEL FICHERO, YA QUE ESTÁ DENTRO DEL PROYECTO
                    archivo = new File(ruta); // INDICAMOS QUE EL ARCHIVO ESTÁ AHÍ

                    if (!archivo.exists()) { // SI EL ARCHIVO NO EXISTE
                        archivo.createNewFile(); // CREAMOS EL ARCHIVO
                        System.out.println("El archivo se ha creado correctamente."); // LO INDICAMOS
                    } else { // SI NO
                        System.out.println("No se ha podido crear el archivo o ya existe."); // INDICAMOS QUE NO SE PUEDE CREAR O YA ESTÁ CREADO
                    }
                    break; // SALIMOS DEL 'SWITCH'
                } catch (IOException e) {
                    e.printStackTrace();
                }
                case 2: // OPCIÓN 2
                    try {
                    ruta = "ejercicio5-1.txt"; // INDICAMOS EL NOMBRE DEL FICHERO, YA QUE ESTÁ DENTRO DEL PROYECTO
                    archivo = new File(ruta); // INDICAMOS QUE EL ARCHIVO ESTÁ AHÍ

                    if (!archivo.exists()) { // SI EL ARCHIVO NO EXISTE
                        System.out.println("El archivo no existe."); // INDICAMOS QUE NO EXISTE
                    } else { // SI NO
                        fr = new FileReader(archivo); // INDICAMOS QUE ARCHIVO VAMOS A LEER
                        br = new BufferedReader(fr); // INDICAMOS QUE VAMOS A LEERLO CON LA VARIABLE 'BR' (BUFFERED READER)

                        String linea; // AQUI LEEREMOS LINEA POR LINEA

                        while ((linea = br.readLine()) != null) { // MIENTRAS SIGA HABIENDO LINEAS, SEGUIRÁ LEYENDO
                            System.out.println(linea); // MOSTRAMOS POR PANTALLA
                        }
                    }
                    break; // SALIMOS DEL 'SWITCH'
                } catch (IOException e) {
                    e.printStackTrace();
                }
                case 3: // OPCIÓN 3
                    try {
                    ruta = "ejercicio5-1.txt"; // INDICAMOS EL NOMBRE DEL FICHERO, YA QUE ESTÁ DENTRO DEL PROYECTO
                    archivo = new File(ruta); // INDICAMOS QUE EL ARCHIVO ESTÁ AHÍ

                    if (!archivo.exists()) { // SI EL ARCHIVO NO EXISTE
                        System.out.println("El archivo no existe."); // INDICAMOS QUE NO EXISTE
                    } else { // SI NO
                        fw = new FileWriter(archivo, true); // INDICAMOS QUE ARCHIVO VAMOS A ESCRIBIR
                        pw = new PrintWriter(fw); // INDICAMOS QUE LO HAREMOS CON LA VARIABLE 'PW' (PRINT WRITER)

                        boolean bandera = true; // CON ESTA VARIABLE CONTROLAREMOS SI EL USUARIO QUIERE SEGUIR INTRODUCIENDO LINEAS
                        pw.println(); // ESCRIBIMOS UNA LINEA EN BLANCO
                        do { // USAREMOS UN 'DO WHILE'
                            System.out.println("Introduce el contenido que deseas añadir:");
                            pw.println("" + br.readLine()); // AÑADIMOS LA LINEA AL FICHERO

                            System.out.println("¿Desea introducir otra línea? S/n");
                            String eleccion = br.readLine(); // ALMACENAMOS LA ELECCION
                            if (eleccion.equalsIgnoreCase("n")) { // SI LA ELECCION EL 'N' 
                                bandera = false; // PONEMOS BANDERA A 'FALSE'
                            } else { // SI NO
                                bandera = true; // SEGUIMOS CON LA BANDERA A 'TRUE'
                            }
                        } while (bandera != false); // SEGUIRA ESCRIBIENDO MENOS CUANDO BANDERA ESTE EN 'FALSE'
                    }
                    break; // SALIMOS DEL 'SWITCH'
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (null != pw) {
                        pw.close(); // CERRAMOS EL 'PW'
                    }
                }
                case 4: // OPCIÓN 4
                    break; // SALIMOS DEL 'SWITCH'
                default: // SI NO ESCOGEMOS NINGUNA OPCIÓN
                    break; // SALIMOS DEL 'SWITCH'
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
