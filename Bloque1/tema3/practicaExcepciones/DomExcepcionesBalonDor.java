package practicaExcepciones;


import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomExcepcionesBalonDor {

    public static void main(String[] args) {

        String fichero   = "balondoro.xml";                 // PRUEBAS 1, 2 y 7
        String etiqueta  = "title";                         // PRUEBA 3 (título/nombre del jugador)
        String atributo  = "location";                      // PRUEBA 4 (ubicación de la librería/grupo)
        String expresion = "/libraries/library/books/book"; // PRUEBAS 5 y 6 (Ruta XPath)

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(fichero));
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList libros = (NodeList) xPath.compile(expresion).evaluate(doc, XPathConstants.NODESET);

            System.out.println("Total de nominados encontrados: " + libros.getLength());

            for (int i = 0; i < libros.getLength(); i++) {
                Element libro = (Element) libros.item(i);
                
                String titulo = libro.getElementsByTagName(etiqueta).item(0).getTextContent();
                String autor = libro.getElementsByTagName("author").item(0).getTextContent();
                String genero = libro.getElementsByTagName("genre").item(0).getTextContent();
                
                Element bibliotecaPadre = (Element) libro.getParentNode().getParentNode();
                String location = bibliotecaPadre.getAttribute(atributo);

                System.out.println(" - Jugador: " + titulo + " | Club: " + autor + " | Posición: " + genero + " (Zona: " + location + ")");
            }

        } catch (ParserConfigurationException e) {
            System.out.println("Error de configuración del analizador: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de lectura del fichero XML (" + e.getClass().getSimpleName() + "): " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error SAX (" + e.getClass().getSimpleName() + "): " + e.getMessage());
        } catch (XPathExpressionException e) {
            System.out.println("Error en la expresión XPath: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Otro error (" + e.getClass().getSimpleName() + "): " + e.getMessage());
        }
    }
}