package principal;

import java.io.IOException;

import leeBinarios.EjemploFicherosBinarios;
import leeTexto.*;
import ficherosAleatorios.AccesoFicheroAleatorio;

public class Inicial {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		//binarios();
		//texto();
		//entradaTeclado();
		aleatorios();

	}
	
	
	public static void binarios() {
		
		EjemploFicherosBinarios efb = new EjemploFicherosBinarios();
		
		try {
			efb.operacionesFicherosBinarios();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
	
	public static void texto() {
		EjemploLeeFichero elf = new EjemploLeeFichero();
		
		try {
			elf.operacionesFicherosTexto();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void entradaTeclado() {
		LeeEntradaTeclado ldl = new LeeEntradaTeclado();
		
		try {
			ldl.ejemploLeeLinea();
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}
		
	}
	
	public static void aleatorios()  {
		AccesoFicheroAleatorio afa = new AccesoFicheroAleatorio();
		
		try {
			afa.operacionConFicheroAleatorio();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}

}
