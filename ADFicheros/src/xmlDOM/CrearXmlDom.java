package xmlDOM;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import ficherosAleatorios.Contactos;
import ficherosAleatorios.Registro;

public class CrearXmlDom {
	public void creaXmlDesdeAleatorio() throws IOException {

		File fichero_agenda_xml = new java.io.File(".//src//ficheros//fichero_agenda.xml");
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Agenda", null);
			document.setXmlVersion("1.0");

			
			
			
			for (int i = 0; i<10; i++) {
				

				Registro contacto = new Registro();
				// Tengo un método que me devuelve contactos aleatorios para introducirlos en el XML
				contacto.getContactoRandom();

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
			
			Result result = new StreamResult(fichero_agenda_xml);
			Source source = new DOMSource(document);
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);
			
			this.leerDocumentoXml(transformer, source);
			

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
	
	
	public void leerDocumentoXml(Transformer transformer, Source source) {
		
		try {
			
			
			
			// MOSTRAR EL DOCUMENTO POR CONSOLA
		    Result console = new StreamResult(System.out);
		    transformer.transform(source, console);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
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
