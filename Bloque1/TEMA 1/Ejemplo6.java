package Bloque1;

import java.io.RandomAccessFile;

public class Ejemplo6 {
    public static void main(String[] args) {
        
        try {

            RandomAccessFile file = new RandomAccessFile("./Bloque1/abecedario.txt", "rw");
            file.seek(5);
            
            System.out.println("Puntero ANTES de leer: " + file.getFilePointer()); //Escribira 5

            int unbyte = file.read();
            System.out.println("Puntero DESPUES de leer: " + file.getFilePointer());
            System.out.println((char)unbyte);

            file.write('0');
            System.out.println("Puntero DESPUES de escribir " + file.getFilePointer());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
