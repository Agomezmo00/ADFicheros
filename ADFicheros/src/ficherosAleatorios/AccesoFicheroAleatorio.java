package ficherosAleatorios;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.File;

public class AccesoFicheroAleatorio {
	
	public AccesoFicheroAleatorio() {
		
	}
	
	public void uppercaseRandomAccessFile() throws IOException {

		char c;
		boolean finArchivo = false;
		RandomAccessFile archivo = null;

		File fichero = new File(".//src//ficheros//fichero_aleatorio.txt");

		try {
			archivo = new RandomAccessFile(fichero, "rw");
			System.out.println("El tamaño es: " + archivo.length());
			do {
				try {
					// Lee el fichero letra a letra y cuando encuentra una i la reemplaza por una I
					// mayúscula.
					c = (char) archivo.readByte();
					if (c == 'i') {

						long pos = archivo.getFilePointer();

						archivo.seek(pos - 1);
						archivo.writeByte(Character.toUpperCase(c));
					}
				} catch (EOFException eof) {
					finArchivo = true;
					archivo.close();
					System.out.println("Convertidas a mayusculas");
				} 
			} while (!finArchivo);
			
		} catch (FileNotFoundException fe) {
			System.out.println("No se encuentra el archivo");

		} catch (IOException ex) {
			ex.printStackTrace();
		}

    }


	public void ejemploAgendaSecuencial() {
		Registro contacto;
		Contactos agenda;
		
		
		Registro contacto1 = new Registro();
		contacto1.setNombre("Juanito");
		contacto1.setGrupo(1);
		contacto1.setDeuda(123.42);
		contacto1.setDireccion("Los laureles, 23");
		contacto1.setEmail("juanito@gmail.com");
		contacto1.setTelefono("974123456");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			contacto1.setNacimiento(dateFormat.parse("1995-03-21"));
		} catch (ParseException pex) {
			pex.printStackTrace();
		}
		
		
		Registro contacto2 = new Registro();
		contacto2.getContactoRandom();
		
		agenda = new Contactos();
		
		
		
		/*
		 * ACCESO SECUENCIAL A LA AGENDA
		 * */
		try {
			agenda.abrir();
			
			agenda.escribir(contacto1);
			agenda.escribir(contacto2);
			
			agenda.cerrar();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		try {
			agenda.abrir();
			
			contacto = agenda.leer();
			while (contacto != null) {
			
				System.out.println(" ");
				System.out.println(contacto.getNombre());
				System.out.println(contacto.getDeuda());
				System.out.println(contacto.getEmail());
				System.out.println(contacto.getTelefono());
				System.out.println(contacto.getNacimiento());
				System.out.println(" ");
				contacto = agenda.leer();
			}
			
			agenda.cerrar();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void ejemploAgendaAleatorio() {
		Registro contacto;
		Contactos agenda;
		
		agenda = new Contactos();
		
		try {
			agenda.abrir();
			contacto = agenda.leer(2);
			
			System.out.println(" ");
			System.out.println(contacto.getNombre());
			System.out.println(contacto.getDeuda());
			System.out.println(contacto.getEmail());
			System.out.println(contacto.getTelefono());
			System.out.println(contacto.getNacimiento());
			System.out.println(" ");
			
			
			
			contacto.setNombre("Julio Iglesias");
			contacto.setDeuda(2020);
			contacto.setDireccion("Paseo de la corona, 2");
			agenda.escribir(contacto, 2);
			
			
			Registro cambiado = new Registro();
			cambiado = agenda.leer(2);
			
			System.out.println(" ");
			System.out.println(cambiado.getNombre());
			System.out.println(cambiado.getDeuda());
			System.out.println(cambiado.getEmail());
			System.out.println(cambiado.getTelefono());
			System.out.println(cambiado.getNacimiento());
			System.out.println(cambiado.getDireccion());
			
			System.out.println(" ");
			
			
		
			agenda.cerrar();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
	}
		

}
