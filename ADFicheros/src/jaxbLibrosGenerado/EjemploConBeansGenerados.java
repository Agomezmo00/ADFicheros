package jaxbLibrosGenerado;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import jaxbLibros.Libro;

public class EjemploConBeansGenerados {
	
	private static final String MIARCHIVO_XML = ".//src//ficheros//libreriaGenerada.xml";
	 
    public void operacionesLibrosJaxb() throws JAXBException, IOException {
         
    		crearFicheroXMLConObjetos();
    		//leeFicheroXml();
    }
 
    
    public void crearFicheroXMLConObjetos() throws JAXBException {
    	
    	ArrayList<Libreria.ListaLibros.Libro> librosLista = new ArrayList<Libreria.ListaLibros.Libro>();
    	
    	ObjectFactory of = new ObjectFactory();
    	
    	Libreria.ListaLibros.Libro libro1 = of.createLibreriaListaLibrosLibro();
    	libro1.setAutor("Miguel de Cervantes");
    	libro1.setNombre("Don Quijote de La Mancha");
    	libro1.setEditorial("dominio público");
    	libro1.setIsbn("987654321");
    	librosLista.add(libro1);
    	
    	Libreria.ListaLibros.Libro libro2 = of.createLibreriaListaLibrosLibro();
    	libro2.setAutor("Joshua Block");
    	libro2.setNombre("Effective Java");
    	libro2.setEditorial("McGraw-Hill");
    	libro2.setIsbn("123456789");
    	librosLista.add(libro2);
    	
    	Libreria.ListaLibros misLibros = of.createLibreriaListaLibros();
    	
    	misLibros.libro = librosLista;
    
    	
    	
    	Libreria miLibreria = of.createLibreria();
    	
    	miLibreria.setLugar("IES San Alberto");
    	miLibreria.setNombre("DAM 2");
    	miLibreria.setListaLibros(misLibros);
    	
    	//Creamos el contexto
    	JAXBContext contexto = JAXBContext.newInstance(Libreria.class);
    	
    	//Crear el marshaller a partir del contexto
    	Marshaller m = contexto.createMarshaller();
    	
    	m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    	
    	System.out.println("-------------LIBRERIA GENERADA CON JAXB-------------");
    	m.marshal(miLibreria, System.out);
    	
    	
    	
    	
    }

}
