package Bloque1;

import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        try {
            
            FileWriter escribir = new FileWriter("datos.txt");  //Escribimos y creamos el abecedario 
            escribir.write("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            escribir.close();

            System.out.print("Introduce la posición que quieres modificar: "); //Pido posicion 
            int posicion = sc.nextInt();

            System.out.print("Introduce el carácter que quieres escribir: "); //Pido caracter
            char caracter = sc.next().charAt(0);

            if (posicion < 0 || posicion >= 26) {

                System.out.println("La posición no es valida");

            } else {

                RandomAccessFile fichero = new RandomAccessFile("datos.txt", "rw");
                fichero.seek(posicion);

                fichero.writeByte(caracter);

                fichero.close();

                System.out.println("Archivo modificado");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
