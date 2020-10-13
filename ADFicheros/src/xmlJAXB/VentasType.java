//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.12 a las 08:39:56 PM CEST 
//


package xmlJAXB;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para VentasType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="VentasType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="articulo" type="{}DatosArtic"/>
 *         &lt;element name="ventas" type="{}ventas"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */

/*
 * 
 * Esta clase modela el fichero XML ventas_articulos.xml, concretamente el elemento ráiz, <ventasarticulo> que incluye la descripción de cada
 * artículo, modelado en DatosArtic y los datos relativos a sus ventas (son una lista de elementos venta) modelados en la clase Ventas
 *  
 * */



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VentasType", propOrder = {
    "articulo",
    "ventas"
})
public class VentasType {

    @XmlElement(required = true)
    protected DatosArtic articulo;
    @XmlElement(required = true)
    protected Ventas ventas;

    /**
     * Obtiene el valor de la propiedad articulo.
     * 
     * @return
     *     possible object is
     *     {@link DatosArtic }
     *     
     */
    public DatosArtic getArticulo() {
        return articulo;
    }

    /**
     * Define el valor de la propiedad articulo.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosArtic }
     *     
     */
    public void setArticulo(DatosArtic value) {
        this.articulo = value;
    }

    /**
     * Obtiene el valor de la propiedad ventas.
     * 
     * @return
     *     possible object is
     *     {@link Ventas }
     *     
     */
    public Ventas getVentas() {
        return ventas;
    }

    /**
     * Define el valor de la propiedad ventas.
     * 
     * @param value
     *     allowed object is
     *     {@link Ventas }
     *     
     */
    public void setVentas(Ventas value) {
        this.ventas = value;
    }

}
