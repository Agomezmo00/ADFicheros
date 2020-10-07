package xmlSAX;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class LeeXmlSax {

    public void leeFichero() {
    	
    	System.out.println("****************EJEMPLO CON SAX******************");

        try {
        	
        	File file = new File(".//src//ficheros//fichero_agenda.xml");
            InputStream inputStream = new FileInputStream(file);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bNombre = false;
                boolean bDireccion = false;
                boolean bDeuda = false;
                boolean bEmail = false;
                boolean bGrupo = false;
                boolean bFecha_nac = false;
                boolean bTelefono = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("---->" + qName);
                    if (qName.equalsIgnoreCase("nombre")) {
                        bNombre = true;
                    }
                    if (qName.equalsIgnoreCase("direccion")) {
                        bDireccion = true;
                    }

                    if (qName.equalsIgnoreCase("deuda")) {
                        bDeuda = true;
                    }
                    
                    if (qName.equalsIgnoreCase("grupo")) {
                        bGrupo = true;
                    }
                    
                    if (qName.equalsIgnoreCase("email")) {
                        bEmail = true;
                    }
                    
                    if (qName.equalsIgnoreCase("fecha_nac")) {
                        bFecha_nac = true;
                    }
                    
                    if (qName.equalsIgnoreCase("telefono")) {
                        bTelefono = true;
                    }
                }

                public void endElement(String uri, String localName, String qName) throws SAXException {
                    System.out.println("---->/" + qName);
                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    if (bNombre) {
                        System.out.println("---------------->nombre: " + new String(ch, start, length));
                        bNombre = false;
                    }

                    if (bDireccion) {
                        System.out.println("---------------->Direccion: " + new String(ch, start, length));
                        bDireccion = false;
                    }

                    if (bDeuda) {
                        System.out.println("---------------->Deuda: " + new String(ch, start, length));
                        bDeuda = false;
                    }
                    
                    if (bGrupo) {
                        System.out.println("---------------->Grupo: " + new String(ch, start, length));
                        bGrupo = false;
                    }
                    
                    if (bEmail) {
                    	System.out.println("---------------->Email: " + new String(ch, start, length));
                    	bEmail = false;
                    }
                    
                    if (bFecha_nac) {
                    	System.out.println("---------------->Fecha_nac: " + new String(ch, start, length));
                    	bFecha_nac=false;
                    }
                    
                    if (bTelefono) {
                    	System.out.println("---------------->Telefono: " + new String(ch, start, length));
                    	bTelefono=false;
                    }
                    
                }

            };

            
            Reader reader = new InputStreamReader(inputStream, "UTF-8");

            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");
            saxParser.parse(is, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}