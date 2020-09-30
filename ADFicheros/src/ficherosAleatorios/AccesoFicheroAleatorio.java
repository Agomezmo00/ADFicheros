package ficherosAleatorios;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.File;

public class AccesoFicheroAleatorio {
	
	public AccesoFicheroAleatorio() {
		
	}
	
	public void operacionConFicheroAleatorio() throws IOException {

        char c;
        boolean finArchivo = false;
        RandomAccessFile archivo = null;
        
        File fichero = new File(".//src//ficheros//fichero_aleatorio.txt");
        

        try {
            archivo = new RandomAccessFile(fichero, "rw");
            System.out.println("El tamaño es: "+ archivo.length());
            do {
                try {
                	//Lee el fichero letra a letra y cuando encuentra una i la reemplaza por una I mayúscula.
                    c = (char) archivo.readByte(); 
                    if (c == 'i') {
                    	
                    	long pos = archivo.getFilePointer();
                        
                    	archivo.seek(pos-1);
                        archivo.writeByte(Character.toUpperCase(c));
                    }
                } catch (EOFException eof) {
                    finArchivo = true;
                    archivo.close();
                    System.out.println("Convertidas a mayusculas");
                }
            } while (!finArchivo);
        } catch (FileNotFoundException fe) {
            System.out.println("No se encontro el archivo");

        }

    }



}
