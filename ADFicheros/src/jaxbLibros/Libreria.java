package jaxbLibros;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
 
//La anotacion @XmlRootElement significa que la clase Libreria es el elemento raiz del fichero xml
//el namespace es opcional

//@XmlRootElement(namespace = "ejemplo1.xml") 
//@XmlRootElement(namespace = "")
@XmlRootElement()
public class Libreria {
	 
    private ArrayList<Libro> listaLibros;
    private String nombre;
    private String lugar;
   
    public Libreria(ArrayList<Libro> listaLibros, String nombre, String lugar) {
		super();
		this.listaLibros = listaLibros;
		this.nombre = nombre;
		this.lugar = lugar;
	}
    
    public Libreria(){}
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setLugar(String lugar) { this.lugar = lugar;    }
    public String getNombre() {return nombre;    }
    public String getLugar() { return lugar;    }

    //Wrapper, envoltura alrededor la representación XML
    @XmlElementWrapper(name = "ListaLibros") // 
    @XmlElement(name = "Libro")
    public ArrayList<Libro> getListaLibros() {
        return listaLibros;    }
 
    public void setListaLibros(ArrayList<Libro> listaLibros) {
        this.listaLibros = listaLibros;    }
 }
