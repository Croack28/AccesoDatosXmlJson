package xmlJson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Xml {

    public static void main(String[] args) {
        
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);

        Alumno a1 = new Alumno();
        a1.setDni("23846324J");
        a1.setNombre("Paco");
        
        Alumno a2 = new Alumno();
        a2.setDni("892357237L");
        a2.setNombre("Mario");
        
        Clase c = new Clase();
        c.insertar(a1);
        c.insertar(a2);
        
        // Serializar el objeto a XML
        String xml = xstream.toXML(c);

        // Escribir el XML a un archivo
        try (FileWriter writer = new FileWriter("clase.xml")) {
            writer.write(xml);
            System.out.println("Objeto Clase escrito en clase.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Deserializar el objeto desde el XML
        try (FileReader reader = new FileReader("clase.xml")) {
            Clase c2 = (Clase) xstream.fromXML(reader);
            System.out.println(c2.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
