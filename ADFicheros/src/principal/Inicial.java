package principal;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import leeBinarios.EjemploFicherosBinarios;
import leeTexto.*;
import xmlDOM.CrearXmlDom;
import xmlSAX.LeeXmlSax;
import xmlXstream.EscribirContactos;
import xmlXstream.LeerContactos;
import ficherosAleatorios.AccesoFicheroAleatorio;
import xmlJAXB.EjemploJAXB;
import jaxbLibros.Ejemplo1_JAXB;
import jaxbLibrosGenerado.EjemploConBeansGenerados;

public class Inicial {

	public static void main(String[] args) throws ClassNotFoundException, IOException, JAXBException {
		// TODO Auto-generated method stub
		//binarios();
		//texto();
		//entradaTeclado();
		//aleatorios();
		//xmlConDOM();
		//xmlConSax();
		//xmlConXStream();
		//xmlConJaxb();
		//jaxbLibros();
		jaxLibrosGenerados();
	}
	
	
	public static void binarios() {
		
		EjemploFicherosBinarios efb = new EjemploFicherosBinarios();
		
		try {
			efb.operacionesFicherosBinarios();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public static void texto() {
		EjemploLeeFichero elf = new EjemploLeeFichero();
		
		try {
			elf.operacionesFicherosTexto();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void entradaTeclado() {
		LeeEntradaTeclado ldl = new LeeEntradaTeclado();
		
		try {
			ldl.ejemploLeeLinea();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
		
	}
	
	public static void aleatorios() throws IOException  {
		AccesoFicheroAleatorio afa = new AccesoFicheroAleatorio();
		
		
		//afa.uppercaseRandomAccessFile();
		
		//afa.ejemploAgendaSecuencial();
		afa.ejemploAgendaAleatorio();
		
		
	}
	
	public static void xmlConDOM() {
		CrearXmlDom cxml = new CrearXmlDom(); 
		try {
			cxml.creaXmlDesdeAleatorio();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.printStackTrace();
		}
	}
	
	public static void xmlConSax() {
		LeeXmlSax lxs = new LeeXmlSax();
		lxs.leeFichero();
		
	}
	
	public static void xmlConXStream() {
		EscribirContactos ec = new EscribirContactos();
		try {
		ec.escribeContactosEnFicheroXML();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		LeerContactos lc = new LeerContactos();
		try {
			lc.leeContactosDeFicheroXML();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void xmlConJaxb() {		
		EjemploJAXB ejemplo = new EjemploJAXB();
		ejemplo.operacionesConJaxb();
	}
	
	public static void jaxbLibros() {
		
		try {
		Ejemplo1_JAXB ej = new Ejemplo1_JAXB();
		ej.operacionesLibrosJaxb();
		} catch (JAXBException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void jaxLibrosGenerados() throws JAXBException {
		EjemploConBeansGenerados ecbg = new EjemploConBeansGenerados();
		ecbg.crearFicheroXMLConObjetos();
	}
	
	

}
