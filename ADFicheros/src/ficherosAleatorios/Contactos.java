package ficherosAleatorios;

import java.io.*;

public class Contactos {

	private RandomAccessFile file;
	
	
	public void abrir() throws IOException {
		file = new RandomAccessFile(".//src//ficheros//aleatorio_binario.dat","rw");
		
	}
	
	public void cerrar() throws IOException {
		
		if(file != null)
			file.close();
	}
	
	public void escribir(Registro registro) throws IOException {
		
		
		  if (file!=null) registro.write(file);
		 
	}	
	
	
	// Escribir un registro en una posición cualquiera
	public void escribir(Registro registro, int pos) throws IOException {
		if(file != null) {
			
			// Primero situamos el cursor donde nos interesa
			file.seek( (pos - 1) * Registro.DIM);
			
			// Después pasamos el registro a escribir en el fichero
			escribir(registro);
		}
	}
	
	//leer del fichero un registro que se encuentra en la posición actual del cursor
	public Registro leer () {
		Registro registro = null;
		
		if (file != null) {
			try {
				registro = new Registro();
				registro.read(file);
			} catch (Exception error) {
				registro = null;
			}
		}
		
		return registro;
	}
	
	
	public Registro leer (int pos) throws IOException {
		if (file != null) {
			file.seek((pos-1)* Registro.DIM );
		}
		return leer();
	}
	
	
}
