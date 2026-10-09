package Bloque1;

import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Sistema de asientos elige dos opciones \n. Elegir un asiento \n2 ver lista de asientos");
    
            int opciones = Integer.parseInt(sc.nextLine());

            switch (opciones) {
                case 1:
                    
                    RandomAccessFile acceso = new RandomAccessFile("/.Bloque1/asientos.txt", "rw");
                    System.out.println("Elige un asiento que este disponible");
                    int posicion = Integer.parseInt(System.in);
                    long tamanoAsiento = acceso.length();
                    char caracterLeido = acceso.readChar();

                    if (tamanoAsiento < 0 || posicion >= tamanoAsiento || caracterLeido == 'C') {
                        System.out.println("Asiento no disponible");
                    } else {

                        acceso.seek(posicion);
                        acceso.write('C');
                        System.out.println("Asiento reservado correctamente");

                    }
                    break;
                case 2:

                    System.out.println("Mostrando lista de asientos");
                    FileReader lectura = new FileReader("./Bloque1/asientos.txt");

                    int datos;
                    
                    while ((datos = lectura.read()) != -1) {
                        System.out.println((char) datos);
                    }

                    lectura.close();
            
                default:
                    System.out.println("Opción elegida no disponible");
                    break;
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
