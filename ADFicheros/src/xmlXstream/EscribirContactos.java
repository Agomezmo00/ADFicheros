package xmlXstream;

import java.io.*;
import com.thoughtworks.xstream.XStream;

import ficherosAleatorios.Contacto;
import ficherosAleatorios.Contactos;

public class EscribirContactos {
	
	
	/*
	 * Este método lee los datos de contactos presentes en un fichero binario, los almacena en una lista y posteriormente, mediante XStream 
	 * se introducen en un fichero xml (que se crea al efecto).
	 * */
	public void escribeContactosEnFicheroXML() throws IOException, ClassNotFoundException {
		
		Contactos agenda = new Contactos();
		Contacto contacto;
		
		FileOutputStream ficheroXmlDestino = new FileOutputStream(".//src//ficheros//contactos.xml");
		
		System.out.println("Vamos leyendo los objetos del fichero");
		
		//Creamos un objeto Lista de contactos y lo rellenamos con los contactos que tiene la agenda
		ListaContactos lstContacts = new ListaContactos();
		
		
		try {
			agenda.abrir();
			
			contacto = agenda.leer();
			while (contacto != null) {
				lstContacts.add(contacto);
				contacto = agenda.leer();
			}
			
			agenda.cerrar();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		
		
		
		try {
			XStream xstream = new XStream();
			
			//Se establecen nombres para las etiquetas XML
			xstream.alias("ListaContactosAgenda", ListaContactos.class);
			xstream.alias("DatosContacto", Contacto.class);
			
			//Se quita la etiqueta lista (atributo de ListaContactos)
			xstream.addImplicitCollection(ListaContactos.class, "lista");
			
			//Operación de inserción de los objetos en el xml
			xstream.toXML(lstContacts, ficheroXmlDestino);
			System.out.println("Creado fichero XML con XStream");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		ficheroXmlDestino.close();
	}

}
