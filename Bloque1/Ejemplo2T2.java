package Bloque1;

import java.io.FileReader;
import java.io.LineNumberReader;

public class Ejemplo2T2 {
    public static void main(String[] args) {
        
        try {
            
            LineNumberReader ln = new LineNumberReader(new FileReader("./Bloque1/datosT2.txt"));
            String line;

            while ((line = ln.readLine()) != null) {
                System.out.println("Contenido de la linea: " + ln.getLineNumber());
                System.out.println(line);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
