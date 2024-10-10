package xmlJson;

import java.io.File;
import java.util.Iterator;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import com.thoughtworks.xstream.security.AnyTypePermission;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;

public class XmlPersistenteEscribir {
    
    protected static String fichero = "xmlPersistente";

    public static void main(String[] args) {
        
        // Configurar XStream con permisos de seguridad antes de la persistencia
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);  // Permitir todas las clases (solo para desarrollo)

        // Asignar el XStream configurado a la estrategia de persistencia
        PersistenceStrategy strategy = new FilePersistenceStrategy(new File(fichero), xstream);
        XmlArrayList lista = new XmlArrayList(strategy);

        // Escribir objetos en el archivo XML
        Alumno a1 = new Alumno();
        a1.setDni("23846324J");
        a1.setNombre("Paco");
        Alumno a2 = new Alumno();
        a2.setDni("892357237L");
        a2.setNombre("Mario");
        Clase c1 = new Clase();
        c1.insertar(a1);
        c1.insertar(a2);
        
        Alumno a3 = new Alumno();
        a3.setDni("634563485L");  
        a3.setNombre("Sans");
        Alumno a4 = new Alumno();
        a4.setDni("537892756K"); 
        a4.setNombre("Leo");
        Clase c2 = new Clase();
        c2.insertar(a3);
        c2.insertar(a4);
        
        lista.add(c1);
        lista.add(c2);

    }
}