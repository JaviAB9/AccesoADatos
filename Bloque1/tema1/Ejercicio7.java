package Bloque1;

import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio7 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("¿Cuanto rango quieres consultar? ");
            int inicio = Integer.parseInt(sc.nextLine());

            System.out.println("¿Cuantos asinetos quieres consultar a partir del numero selección? ");
            int canitidad = Integer.parseInt(sc.nextLine());

            RandomAccessFile asientos = new RandomAccessFile("./Bloque1/asientos.txt", "rw");

            asientos.seek(inicio);

            byte[] array = new byte[canitidad];

            asientos.read(array, 0, canitidad);

            for (int i = 0; i < canitidad; i++) {
                System.out.println("Asientos " + (inicio + i) + ": " + (char) array[i]);
            }

        sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
