package transparencias;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

/**
 *  @descrition
 *	@author Laura
 *  @date 6/5/2015
 *  @version 1.0
 *  @license GPLv3
 */

public class PruebaXStreamJSON {

	public static void main(String[] args) {

		//Construimos el objeto  a convertir despu�s en XML
		Telefono tel=new Telefono();
		tel.setCodigo(34);
		tel.setNumero(666666666);
		Persona persona=new Persona();
		persona.setNombre("Pepe");
		persona.setApellido("Garcia");
		persona.setTelefono(tel);
		
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());        
        xstream.alias("product", Persona.class);

        String jsPersona = xstream.toXML(persona);
        System.out.println(xstream.toXML(persona));	
        
        Persona persona2 = (Persona) xstream.fromXML(jsPersona);
        
       
	}

}


