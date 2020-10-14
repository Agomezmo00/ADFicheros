//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.14 a las 11:41:43 AM CEST 
//


package jaxbLibrosGenerado;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ListaLibros">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Libro" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="autor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="editorial" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="isbn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="lugar" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listaLibros",
    "lugar",
    "nombre"
})
@XmlRootElement(name = "libreria")
public class Libreria {

    @XmlElement(name = "ListaLibros", required = true)
    protected Libreria.ListaLibros listaLibros;
    @XmlElement(required = true)
    protected String lugar;
    @XmlElement(required = true)
    protected String nombre;

    /**
     * Obtiene el valor de la propiedad listaLibros.
     * 
     * @return
     *     possible object is
     *     {@link Libreria.ListaLibros }
     *     
     */
    public Libreria.ListaLibros getListaLibros() {
        return listaLibros;
    }

    /**
     * Define el valor de la propiedad listaLibros.
     * 
     * @param value
     *     allowed object is
     *     {@link Libreria.ListaLibros }
     *     
     */
    public void setListaLibros(Libreria.ListaLibros value) {
        this.listaLibros = value;
    }

    /**
     * Obtiene el valor de la propiedad lugar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Define el valor de la propiedad lugar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLugar(String value) {
        this.lugar = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Libro" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="autor" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="editorial" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="isbn" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "libro"
    })
    public static class ListaLibros {

        @XmlElement(name = "Libro", required = true)
        protected List<Libreria.ListaLibros.Libro> libro;

        /**
         * Gets the value of the libro property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the libro property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLibro().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Libreria.ListaLibros.Libro }
         * 
         * 
         */
        public List<Libreria.ListaLibros.Libro> getLibro() {
            if (libro == null) {
                libro = new ArrayList<Libreria.ListaLibros.Libro>();
            }
            return this.libro;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="autor" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="editorial" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="isbn" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "autor",
            "nombre",
            "editorial",
            "isbn"
        })
        public static class Libro {

            @XmlElement(required = true)
            protected String autor;
            @XmlElement(required = true)
            protected String nombre;
            @XmlElement(required = true)
            protected String editorial;
            @XmlElement(required = true)
            protected String isbn;

            /**
             * Obtiene el valor de la propiedad autor.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAutor() {
                return autor;
            }

            /**
             * Define el valor de la propiedad autor.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAutor(String value) {
                this.autor = value;
            }

            /**
             * Obtiene el valor de la propiedad nombre.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNombre() {
                return nombre;
            }

            /**
             * Define el valor de la propiedad nombre.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNombre(String value) {
                this.nombre = value;
            }

            /**
             * Obtiene el valor de la propiedad editorial.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEditorial() {
                return editorial;
            }

            /**
             * Define el valor de la propiedad editorial.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEditorial(String value) {
                this.editorial = value;
            }

            /**
             * Obtiene el valor de la propiedad isbn.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIsbn() {
                return isbn;
            }

            /**
             * Define el valor de la propiedad isbn.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIsbn(String value) {
                this.isbn = value;
            }

        }

    }

}
