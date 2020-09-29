package leeTexto;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EjemploLeeFichero {

	public void operacionesFicherosTexto () {
		//System.out.println("Working Directory = " + System.getProperty("user.dir"));
		
		String path = new String(".//src//ficheros//texto.txt");
		File fichero = new File(path);
		
		try {
			FileReader lector = new FileReader(fichero);
			char[] buf = new char[200];
			System.out.println("Fichero :" + path);
			System.out.println("Ha leído: "+ lector.read(buf) +" caracteres.");
			System.out.println(buf);
			lector.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
