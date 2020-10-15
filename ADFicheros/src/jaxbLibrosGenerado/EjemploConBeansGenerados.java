package jaxbLibrosGenerado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import jaxbLibros.Libro;

public class EjemploConBeansGenerados {
	
	private static final String MIARCHIVO_XML = ".//src//ficheros//libreriaGenerada.xml";
	 
    public void operacionesLibrosJaxb(){
         
    		crearFicheroXMLConObjetos();
    		leeFicheroXml();
    }
 
    
    public void crearFicheroXMLConObjetos() {
    	
    	ArrayList<Libreria.ListaLibros.Libro> librosLista = new ArrayList<Libreria.ListaLibros.Libro>();
    	
    	ObjectFactory of = new ObjectFactory();
    	
    	Libreria.ListaLibros.Libro libro1 = of.createLibreriaListaLibrosLibro();
    	libro1.setAutor("Miguel de Cervantes");
    	libro1.setNombre("Don Quijote de La Mancha");
    	libro1.setEditorial("dominio público");
    	libro1.setIsbn("987654321");
    	librosLista.add(libro1);
    	
    	Libreria.ListaLibros.Libro libro2 = of.createLibreriaListaLibrosLibro();
    	libro2.setAutor("Joshua Bloch");
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
    	JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Libreria.class);
			
			//Crear el marshaller a partir del contexto
	    	Marshaller m = contexto.createMarshaller();
	    	
	    	m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    	
	    	System.out.println("-------------LIBRERIA GENERADA CON JAXB-------------");
	    	m.marshal(miLibreria, System.out);
	    	
	    	m.marshal(miLibreria, new File(MIARCHIVO_XML));
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }
    
    
    public void leeFicheroXml() {
    	ObjectFactory of = new ObjectFactory();
    	Libreria miLibreria = of.createLibreria();
    	
    	Libreria.ListaLibros miLista = of.createLibreriaListaLibros();
    	
    	try {
			JAXBContext contexto = JAXBContext.newInstance(Libreria.class);
			Unmarshaller um = contexto.createUnmarshaller();
			
			miLibreria = (Libreria) um.unmarshal(new FileReader(MIARCHIVO_XML));
			
			System.out.println("------------Datos de la librería leídos del XML---------------");
			System.out.println("Nombre: "+miLibreria.getNombre());
			System.out.println("Ubicación: "+miLibreria.getLugar());
			System.out.println("Lista de títulos disponibles: \n");
			
			for(Libreria.ListaLibros.Libro libro: miLibreria.listaLibros.libro) {
				
				System.out.println("Título: "+libro.getNombre());
				System.out.println("Autor: "+libro.getAutor());
				System.out.println("Editorial: "+libro.getEditorial());
				System.out.println("ISBN: "+libro.getIsbn());
				System.out.println("----------------------------------------------");
			}
		
			
			
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

}
