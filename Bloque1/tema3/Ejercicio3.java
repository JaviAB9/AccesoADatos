import java.io.FileReader;

public class Ejercicio3 {
    public static void main(String[] args) {
        
        try {
            
            FileReader file = new FileReader("./Bloque1/tema3/archivo.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
