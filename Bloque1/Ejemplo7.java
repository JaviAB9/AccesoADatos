package Bloque1;

import java.io.RandomAccessFile;

public class Ejemplo7 {
    public static void main(String[] args) {
        
        try {
            
            RandomAccessFile file = new RandomAccessFile("./Bloque1/abecedario.txt", "r");

            file.seek(5);
            System.out.println("Puntero ANTES del read: " + file.getFilePointer());
            byte[] arrayBytes = new byte[3];
            file.read(arrayBytes, 0, 3);

            System.out.println("Bytes leidos: " + arrayBytes.length);
            System.out.println("Puntero DESPUES del read: " + file.getFilePointer());

            System.out.println("\nArray DESPUES de leer (ya relleno con datos del fichero): ");

            for (int i = 0; i < arrayBytes.length; i++) {
                System.out.println("  arrayBytes[" + i + "] = " + arrayBytes[i] + " -> '" + (char) arrayBytes[i] + "'");
            }

            file.close();

        } catch (Exception e) {
            e.printStackTrace(); 
        }


    }
}
