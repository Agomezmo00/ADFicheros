package principal;

import java.io.IOException;

import leeBinarios.EjemploFicherosBinarios;
import leeTexto.*;
import xmlDOM.CrearXmlDom;
import xmlSAX.LeeXmlSax;
import ficherosAleatorios.AccesoFicheroAleatorio;

public class Inicial {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		//binarios();
		//texto();
		//entradaTeclado();
		//aleatorios();
		//xmlConDOM();
		xmlConSax();
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

}
