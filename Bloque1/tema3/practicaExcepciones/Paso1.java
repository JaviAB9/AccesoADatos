package practicaExcepciones;

import java.io.FileReader;
import java.io.IOException;

public class Paso1 {
    public static void main(String[] args) {
        
        String ruta = "mis_datos.txt";

        try (FileReader file = new FileReader(ruta)) {
            int c;

            while ((c = file.read()) != -1) {
                System.out.println((char) c);
            }

        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.toString());
        }
    }
}
