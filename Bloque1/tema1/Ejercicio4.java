package Bloque1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio4 {
    public static void main(String[] args) {
        
        try {
            
            BufferedInputStream entrada = new BufferedInputStream(new FileInputStream("./Bloque1/foto.jpg"));

            BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream("foto_copia_buffer.jpg"));

            byte[] buffer = new byte[1024];

            int bytesLeidos;
            int bloque = 1;

            while ((bytesLeidos = entrada.read(buffer)) != -1) {
                
                salida.write(buffer, 0, bytesLeidos);
                System.out.println("Fin copia bloque " + bloque);
                bloque++;
            }

            salida.flush();

            entrada.close();
            salida.close();

            System.out.println("Copia finalizada correctamente");


        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
