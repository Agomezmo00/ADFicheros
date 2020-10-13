package xmlJAXB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class EjemploJAXB {

	public void operacionesConJaxb() {
		visualizarxml();
		//insertaventa(3, "Pepito Pérez", 4, "14-10-2020");
	}
//método para visualizar el contenido del fichero XML ventasarticulos.xml

	public static void visualizarxml() {
		System.out.println("----------------------------------------------------------");
		System.out.println("---------------------- VISUALIZAR XML --------------------");
		System.out.println("----------------------------------------------------------");
		try {

			
			/*
			 * Al proceso de serializar un objeto java a un fichero XML se le denomina marshall o marshalling ----> JAVA Object a XML
			 * Al proceso de deserializar XML a un objeto java se le denomina unmarshall o unmarshalling ---> XML a JAVA Object
			 * 
			 * Para crear el XML necesitas tener un JavaBean con sus anotaciones correspondientes.
			 * 
			 * */
			
			//Creamos el contexto, se indica la clase que va a ser el elemento raíz del XML
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			
			// El unmarshaller crea un objeto java a partir del contenido del fichero XML
			Unmarshaller u = jaxbContext.createUnmarshaller();
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream(".//src//ficheros//ventas_articulos.xml"));
			
			// El marshaller crea una cadena XML a partir del objeto Java mapeado.
			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			//Visualiza por consola
			m.marshal(jaxbElement, System.out);

			//Cargamos ahora el documento en los tipos
			VentasType miventa = (VentasType) jaxbElement.getValue();

			//Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();

			//Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();
			System.out.println("----------------------------------------------------------");
			System.out.println("------------------ VISUALIZAR LOS OBJETOS ----------------");
			System.out.println("----------------------------------------------------------");

			//Cargamos los datos del artículo
			DatosArtic miartic = (DatosArtic) miventa.getArticulo();
			System.out.println("Nombre art: " + miartic.getDenominacion());
			System.out.println("Codigo art: " + miartic.getCodigo());
			System.out.println("Ventas del artículo, hay: " + listaVentas.size());

			//Visualizamos las ventas del artículo
			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Ventas.Venta) listaVentas.get(i);
				System.out.println("Número de venta: " + ve.getNumventa() + ".Nombre cliente: " + ve.getNombrecliente()+ ", unidades: " + ve.getUnidades() + ", fecha: " + ve.getFecha());
			}
		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (FileNotFoundException ex) {
			Logger.getLogger(EjemploJAXB.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/*
	 * método recibe datos de una venta y lo añade al documento XML. 
	 * Comprobará antes de insertar que el número de venta no exista.
	*/
	private static void insertaventa(int numeventa, String nomcli, int uni, String fecha) {
		System.out.println("----------------------------------------------------------");
		System.out.println("-------------- AÑADIR VENTA -- --------------------");
		System.out.println("----------------------------------------------------------");
		try {

			//Creamos el contexto
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream(".//src//ficheros//ventas_articulos.xml"));
			VentasType miventa = (VentasType) jaxbElement.getValue();
			Ventas vent = miventa.getVentas();
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			//comprobar si existe el número de venta recorriendo el arraylist
			int existe = 0;
			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Ventas.Venta) listaVentas.get(i);

				if (ve.getNumventa().intValue() == numeventa) {
					existe = 1;
				}
				break;
			}
			if (existe == 0) {

				//Crear el objeto Ventas.Venta
				Ventas.Venta ve = new Ventas.Venta();
				ve.setNombrecliente(nomcli);
				ve.setFecha(fecha);
				ve.setUnidades(uni);
				BigInteger nume = BigInteger.valueOf(numeventa);
				ve.setNumventa(nume);

				//Se añade la venta a la lista
				listaVentas.add(ve);
				
				//Se crea el Marshaller, volcar la lista al fichero XML
				Marshaller m = jaxbContext.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.marshal(jaxbElement, new FileOutputStream(".//src//ficheros//ventas_articulos.xml"));
				System.out.println("Venta añadida: " + numeventa);
			} else {
				System.out.println("El número de venta ya existe: " + numeventa);
			}
		} catch (JAXBException ex) {
			Logger.getLogger(EjemploJAXB.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
}
