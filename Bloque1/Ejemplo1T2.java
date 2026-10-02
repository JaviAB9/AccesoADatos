package Bloque1;

import java.io.FileReader;
import java.io.StreamTokenizer;

public class Ejemplo1T2 {
    public static void main(String[] args) {
        
        try {
            
            StreamTokenizer streamTokenizer = new StreamTokenizer(new FileReader("./Bloque1/datosT2.txt"));

            //Configurar para que el cáracter de nueva linea sea interpretado
            streamTokenizer.eolIsSignificant(true);

            while (streamTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
                if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    System.out.println("Palabra: " + streamTokenizer.sval);   // token de tipo palabra
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    System.out.println("Numero: " + streamTokenizer.nval);   // token de tipo número
                } else if (streamTokenizer.ttype == StreamTokenizer.TT_EOL) {
                    System.out.println(" Salto de línea");                       // fin de línea
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
        
}            
