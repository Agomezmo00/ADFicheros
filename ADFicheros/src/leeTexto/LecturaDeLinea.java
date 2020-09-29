package leeTexto;

import java.io.*;
class LecturaDeLinea {
	
	public void ejemploLeeLinea () throws IOException {
		int c;
		int contador = 0;
// se lee hasta encontrar el fin de línea
		while ((c = System.in.read()) != '\n') {
			contador++;
			System.out.print((char) c);
		}
		System.out.println(); // Se escribe el fin de línea
		System.err.println("Contados " + contador + " bytes en total.");
	}
}