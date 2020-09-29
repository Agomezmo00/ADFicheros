package leeTexto;

import java.io.*;
public class LeeEntradaTeclado {
	
	public void ejemploLeeLinea () throws IOException {
		
		//Lee los caracteres introducidos por teclado hasta pulsar ENTER.
		
		System.out.println("\nIntroduce caracteres y finaliza la cadena pulsando ENTER: ");
		
		int c;
		int contador = 0;
		
		// se lee hasta encontrar el fin de línea
		while ((c = System.in.read()) != '\n') {
			contador++;
			System.out.print((char) c);
		}
		
		// Tras pulsar ENTER el fin de línea
		System.out.println(); 
		System.err.println("Contados " + contador + " bytes en total.");
	}
}