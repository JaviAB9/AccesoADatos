package Bloque1;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Guardar");
        System.out.println("2. Imprimir");
        
        int opcion = Integer.parseInt(sc.nextLine());

        if (opcion == 1) {
            
            System.out.println("Nombre y apellidos: ");
            String nombre = sc.nextLine();

            System.out.println("Email: ");
            String email = sc.nextLine();

            System.out.println("Fecha nacimiento: ");
            String fecha = sc.nextLine();

            System.out.println("Genero: ");
            String genero = sc.nextLine();

            System.out.println("Titulo: ");
            String titulo = sc.nextLine();

            System.out.println("Observaciones: ");
            String observacion = sc.nextLine();

            String contenido = " ----- FORMULARIO DE MATRICULACIÓN ----- \n" +
                                "Nombre y apellidos: " + nombre + "\n" +
                                "Email: " + email + "\n" +
                                "Fecha de nacimiento: " + fecha + "\n" +
                                "Genero: " + genero + "\n" +
                                "Titulo: " + titulo + "\n" +
                                "Observación: " + observacion + "\n";

        try {
            FileWriter fw = new FileWriter("./Bloque1/matricula.txt");
            fw.write(contenido);
            fw.close();

        } catch (Exception e) {
            // TODO: handle exception
        }


        } else if (opcion == 2) {
            
            try {
                FileReader fr = new FileReader("./Bloque1/matricula.txt");
                int data;
                
                while ((data = fr.read()) != -1) {
                    System.out.println((char) data);
                }

                fr.close();

            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
