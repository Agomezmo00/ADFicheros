package xmlDOM;

import org.w3c.dom.*;

import ficherosAleatorios.Contactos;
import ficherosAleatorios.Registro;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearXmlDom {
	public void creaXmlDesdeAleatorio() throws IOException {

		File fichero_agenda_xml = new java.io.File(".//src//ficheros//fichero_agenda.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Agenda", null);
			document.setXmlVersion("1.0");

			
			
			int index = 1;
			for (int i = 0; i<10; i++) {
				if (i % 2 == 0) {
					index = 2;
				} else {
					index = 1;
				}
				Registro contacto = leerContacto(index);

				Element raiz = document.createElement("contacto"); // nodo contacto
				document.getDocumentElement().appendChild(raiz);
				
						
						// añadir datos al fichero
						CrearElemento("deuda", Double.toString(contacto.getDeuda()), raiz, document);
						
						CrearElemento("nombre", contacto.getNombre().trim(), raiz, document);
						
						CrearElemento("email", contacto.getEmail().trim(), raiz, document);
						
						CrearElemento("telefono", contacto.getTelefono().trim(), raiz, document);
						
						CrearElemento("direccion", contacto.getDireccion().trim(), raiz, document);
						
						CrearElemento("grupo", Integer.toString(contacto.getGrupo()), raiz, document);
						
						CrearElemento("fecha_nac", contacto.getNacimiento().toString().trim(), raiz, document);

			}
			
				
			
		

			Source source = new DOMSource(document);
			Result result = new StreamResult(fichero_agenda_xml);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			
			
			// MOSTRAR EL DOCUMENTO POR CONSOLA
		    Result console = new StreamResult(System.out);
		    transformer.transform(source, console);	 

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}

		
	}

	// Inserción de los datos del empleado
	public void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoEmple);
		Text text = document.createTextNode(valor); // damos valor
		raiz.appendChild(elem); // pegamos el elemento hijo a la raiz
		elem.appendChild(text); // pegamos el valor
	}

	
	public Registro leerContacto(int posicion) throws IOException {
		Registro contacto = null;
		Contactos agenda;
		
		agenda = new Contactos();
		
		try {
			agenda.abrir();
			contacto = agenda.leer(posicion);
			agenda.cerrar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return contacto;
	}

}// fin de la clase
