package principal;

import java.io.IOException;

import leeBinarios.EjemploFicherosBinarios;
import leeTexto.*;

public class Inicial {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		binarios();
		

	}
	
	
	public static void binarios() throws ClassNotFoundException {
		
		EjemploFicherosBinarios efb = new EjemploFicherosBinarios();
		
		try {
			efb.operacionesFicherosBinarios();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
