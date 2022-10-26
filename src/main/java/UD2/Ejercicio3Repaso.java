package UD2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejercicio3Repaso {

    static String nomFich = "ficheroEjercicio3.txt";

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = null;

            File archivo = null;

            PrintWriter pw = null;
            FileWriter fw = null;

            FileReader fr = null;

            FileInputStream in = null;

            System.out.println("********************** MENÚ **********************");
            System.out.println("1. CREAR FICHERO DE TEXTO.");
            System.out.println("2. MOSTRAR CONTENIDO DEL FICHERO DE TEXTO CREADO.");
            System.out.println("3. INSERCIÓN DE NÚMEROS AL FINAL DEL FICHERO.");
            System.out.println("4. COMPROBACIÓN DEL FICHERO.");
            System.out.println("5. SALIR.");
            System.out.println("**************************************************");
            System.out.print("Elige una opción: ");
            int opcion = Integer.parseInt(br.readLine());

            switch (opcion) {
                case 1:
                    try {
                    archivo = new File(nomFich);

                    if (archivo.exists()) {
                        System.out.println("El archivo ya existe.");
                    } else {

                        int[] numeros = new int[49];

                        int num = 0;
                        int contador = 0;

                        while (contador != 49) {
                            if (num % 2 != 0) {
                                numeros[contador] = num;
                                contador++;
                            }
                            num++;
                        }

                        fw = new FileWriter(archivo, true);
                        pw = new PrintWriter(fw);

                        for (int i = 0; i < numeros.length; i++) {
                            pw.println(numeros[i]);
                        }
                    }
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (null != pw) {
                            pw.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 2:
                    archivo = new File(nomFich);

                    fr = new FileReader(archivo);
                    br = new BufferedReader(fr);

                    String linea;

                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                    }
                    break;
                case 3:
                    try {
                    archivo = new File(nomFich);

                    int num;

                    boolean bandera = true;

                    fw = new FileWriter(archivo, true);
                    pw = new PrintWriter(fw);

                    do {
                        System.out.print("Introduce un número para añadir al fichero: ");
                        num = Integer.parseInt(br.readLine());
                        pw.println(num);

                        System.out.println("¿Deseas introducir más números? S/n");
                        String res = br.readLine();

                        if (res.equalsIgnoreCase("n")) {
                            bandera = false;
                        }
                    } while (bandera != false);
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (null != pw) {
                            pw.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case 4:
                    archivo = new File(nomFich);

                    fr = new FileReader(archivo);
                    br = new BufferedReader(fr);
                    
                    break;
                case 5:
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
