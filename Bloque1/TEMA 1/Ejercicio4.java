package Bloque1;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Ejercicio4 {
    public static void main(String[] args) {
        
        try {
            
            BufferedInputStream entrada = new BufferedInputStream(new FileInputStream("foto.jpg"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
