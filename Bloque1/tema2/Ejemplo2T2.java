package Bloque1;

import java.io.FileReader;
import java.io.LineNumberReader;

public class Ejemplo2T2 {
    public static void main(String[] args) {
        
        try {
            
            LineNumberReader ln = new LineNumberReader(new FileReader("./Bloque1/datosT2.txt"));
            String linea;

            while ((linea = ln.readLine()) != null) {
                System.out.println("Contenido de la linea: " + ln.getLineNumberReader.getLineNumber() + ": " + linea);
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
