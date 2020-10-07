package xmlXstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import ficherosAleatorios.Contacto;

public class LeerContactos {

	
	public void leeContactosDeFicheroXML() throws IOException {
		
		FileInputStream ficheroXmlOrigen = new FileInputStream(".//src//ficheros//contactos.xml");
		
		
		
		XStream xstream = new XStream();
		
		xstream.alias("ListaContactosAgenda", ListaContactos.class);
		xstream.alias("DatosContacto", Contacto.class);
		xstream.addImplicitCollection(ListaContactos.class, "lista");
		
		ListaContactos listadoDelFichero = (ListaContactos) xstream.fromXML(new FileInputStream(".//src//ficheros//contactos.xml"));
		
		
		System.out.println("Tenemos en la agenda: "+listadoDelFichero.getListaContactos().size()+ " contactos");
		
		
		//Creamos un ArrayList para almacenar lo que hemos leído del fichero xml, deserializarlo. 
		List<Contacto> listaContactosArrayList = new ArrayList<Contacto>();
		listaContactosArrayList = listadoDelFichero.getListaContactos();
		
		
		Iterator iterador = listaContactosArrayList.listIterator();
		while(iterador.hasNext()) {
			Contacto c = (Contacto) iterador.next();
			System.out.println("Nombre: "+c.getNombre());
			System.out.println("Dirección: "+c.getDireccion());
			System.out.println("Fecha de nacimiento: "+c.getNacimiento());
		}
		
		System.out.println("\nFin de la lista");
		
	}
		
}
