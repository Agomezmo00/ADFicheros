package jaxbLibros;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
 

public class Ejemplo1_JAXB {
 
    private static final String MIARCHIVO_XML = ".//src//ficheros//libreria.xml";
 
    public void operacionesLibrosJaxb() throws JAXBException, IOException {
         
    		crearFicheroXMLConObjetos();
    		leeFicheroXml();
    }
    
    
    public void crearFicheroXMLConObjetos() throws JAXBException, IOException {
    	//Se crea la lista de libros
        ArrayList<Libro> librosLista = new ArrayList<Libro>();
 
        // Creamos dos libros y los añadimos
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez","Sudamericana","978-14-8151-845-1" );
        librosLista.add(libro1);
        Libro libro2 = new Libro("La fiesta del chivo", "Mario Vargas Llosa","Alfaguara","978-03-124-2027-7" );
        librosLista.add(libro2);
        Libro libro3 = new Libro("El Capitán Alatriste", "Arturo Pérez-Reverte", "Alfaguara", "978-83-731-9569-1");
        librosLista.add(libro3);
    
 
        // Se crea La libreria y se le asigna la lista de libros
        Libreria milibreria = new Libreria();
        milibreria.setNombre("Prueba de libreria JAXB");
        milibreria.setLugar("Cuesta de Moyano (Madrid)");
        milibreria.setListaLibros(librosLista);
 
        // Creamos el contexto indicando la clase raíz
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
      
        //Creamos el Marshaller, convierte el java bean en una cadena XML
        Marshaller m = context.createMarshaller();
        
        //Formateamos el xml para que quede bien
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
 
        // Lo visualizamos con system out
        m.marshal(milibreria, System.out);
 
        // Escribimos en el archivo
        m.marshal(milibreria, new File(MIARCHIVO_XML));

    }
    
    public void leeFicheroXml() throws JAXBException, IOException {
    	
        // Visualizamos ahora los datos del documento XML creado
        System.out.println("------------ Leo el XML ---------");
        
        // Creamos el contexto indicando la clase raíz
        JAXBContext context = JAXBContext.newInstance(Libreria.class);
        
        //Se crea Unmarshaller en el cotexto de la clase Libreria
        Unmarshaller unmars = context.createUnmarshaller();
        
        //Utilizamos el método unmarshal, para obtener datos de un Reader
        Libreria libreria2 = (Libreria) unmars.unmarshal(new FileReader(MIARCHIVO_XML));
        
        //Recuperamos el array list y visualizamos
        System.out.println("Nombre de librería: "+ libreria2.getNombre());
        System.out.println("Lugar de la librería: "+ libreria2.getLugar());
        System.out.println("Libros de la librería: ");
        
        ArrayList<Libro> lista = libreria2.getListaLibros();
        for (Libro libro : lista) {
            System.out.println("\tTítulo del libro: " + libro.getNombre() + " , autor/a: " + libro.getAutor());
 
        }
    }
    
    
    
}