package leeTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjemploLeeFichero {

	public void operacionesFicherosTexto () {	
		String path = new String(".//src//ficheros//texto.txt");
		File fichero = new File(path);
		
		this.leeFicheroCaracter(fichero);
		
		this.leeFicheroPorLineas(fichero);
	}
	
	
	
	public void leeFicheroCaracter (File fichero) {
		
		try {
			
			System.out.println();
			System.out.println("Lee mediante un char[200], es decir, lee 200 caracteres como mucho");
			FileReader lector = new FileReader(fichero);
			char[] buf = new char[200];
			System.out.println("Fichero :" + fichero.getCanonicalPath());
			System.out.println("Ha leído: "+ lector.read(buf) +" caracteres.");
			System.out.println(buf);
			lector.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void leeFicheroPorLineas (File fichero) {
		System.out.println();
		System.out.println("Lee mediante BufferedReader y el método readLine.");
		System.out.println();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fichero));
			String linea;
			
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	

}
