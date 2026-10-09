import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.Socket;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Ejercicio2 {
    public static void main(String[] args) {
        
        try {
            
            File archivo = new File("./Bloque1/tema3/balondoro.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document documento = builder.parse(archivo);
            documento.getDocumentElement().normalize();

            NodeList grupos = documento.getElementsByTagName("grupo");

            int totalGrupos = grupos.getLength();
            int totalNominados = 0;

            for (int i = 0; i < grupos.getLength(); i++) {
                
                Element grupo = (Element) grupos.item(i);
                String pais = grupo.getAttribute("pais");

                System.out.println("\nPais: " + pais);

                NodeList nominados = grupo.getElementsByTagName("nominado");

                System.out.println("Numero de nomidados: " + nominados.getLength());

                for (int j = 0; j < nominados.getLength(); j++) {
                    
                    Element nominado = (Element) nominados.item(j);

                    String nombre = nominado.getElementsByTagName("nombre").item(0).getTextContent();
                    String equipo = nominado.getElementsByTagName("equipo").item(0).getTextContent();
                    String posicion = nominado.getElementsByTagName("posicion").item(0).getTextContent();
                    String puntos = nominado.getElementsByTagName("puntos").item(0).getTextContent();

                    System.out.println(" Nombre: " + nombre);
                    System.out.println(" Equipo: " + equipo);
                    System.out.println(" Posicion: " + posicion);
                    System.out.println("Puntos: " + puntos);

                    totalNominados++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el XML: " + e.getMessage());
        }
    }
}
