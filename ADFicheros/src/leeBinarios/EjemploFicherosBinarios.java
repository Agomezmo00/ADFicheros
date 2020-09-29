package leeBinarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import utiles.PalabrasAleatorias;

public class EjemploFicherosBinarios {

	public void operacionesFicherosBinarios() throws ClassNotFoundException, IOException {

		File fichero_bytes = new File(".//src//ficheros//fichero_bytes.dat");
		File fichero_primitivos = new File(".//src//ficheros//fichero_primitivos.dat");
		File ficheroObjetos = new File(".//src//ficheros//fichero_objetos.dat");

		this.escribeBytesEnFichero(fichero_bytes);
		this.leeBytesDesdeFichero(fichero_bytes);

		this.escribeIntEnFichero(fichero_primitivos);
		this.leeIntDesdeFichero(fichero_primitivos);

		this.escribeObjetoEnFichero(ficheroObjetos);
		this.leeObjetoDesdeFichero(ficheroObjetos);

	}

	public void leeIntDesdeFichero(File fichero) {
		try {
			FileInputStream lecturaIS = new FileInputStream(fichero);
			DataInputStream dataIS = new DataInputStream(lecturaIS);

			int i = dataIS.readInt();
			System.out.println("2. Leyendo tipos primitivos desde un fichero binario: "+i);

			dataIS.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	public void escribeIntEnFichero(File fichero) {
		try {
			FileOutputStream escrituraOS = new FileOutputStream(fichero);
			DataOutputStream dataOS = new DataOutputStream(escrituraOS);

			System.out.println("");
			System.out.println("1. Almacenando tipos primitivos en un fichero binario.");
			Random rand = new Random();
			dataOS.writeInt(rand.nextInt(1000));

			dataOS.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	public void leeBytesDesdeFichero(File fichero) {

		System.out.println("2. Leyendo bytes de un fichero: ");
		try {
			// Flujo de entrada para leer:
			FileInputStream lectura = new FileInputStream(fichero);
			int i = lectura.read();
			// Mientras que no devuelva -1 que siga leyendo:
			while (i != -1) {
				System.out.print((char) i);
				i = lectura.read();
			}
			// Cierro el flujo de lectura
			lectura.close();
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		System.out.println("");
	}

	public void escribeBytesEnFichero(File fichero) {

		try {
			// Flujo de salida para escribir:
			// true para que no sobrescriba
			FileOutputStream escritura = new FileOutputStream(fichero, true);

		
			PalabrasAleatorias pa = new PalabrasAleatorias();
			Random numPalabrasAleatorio = new Random();
			String texto = pa.generateRandomWords(numPalabrasAleatorio.nextInt(5));

			System.out.println("");
			System.out.println("1. Escribiendo bytes en un fichero.");
			
			// Copiamos el texto en un array de bytes
			byte codigos[] = texto.getBytes();
			escritura.write(codigos);
			
			// cierro el flujo de escritura
			escritura.close();
			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public void escribeObjetoEnFichero(File fichero) {
		System.out.println("");
		try {

			Random edadRandom = new Random();
			Animal perro = new Animal(edadRandom.nextInt(15), "Toby", "Podenco");

			FileOutputStream escrituraOS = new FileOutputStream(fichero);
			ObjectOutputStream objectOS = new ObjectOutputStream(escrituraOS);
			objectOS.writeObject(perro);

			System.out.println("1. Almacenando un objeto de tipo "+ perro.getClass() +" en el fichero: " + fichero.getName());

			objectOS.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public void leeObjetoDesdeFichero(File fichero) throws IOException, ClassNotFoundException {
		System.out.println("2. Leyendo objetos desde un fichero");
		
		try {

			FileInputStream lecturaIS = new FileInputStream(fichero);
			ObjectInputStream objectIS = new ObjectInputStream(lecturaIS);

			Animal animal;
			while (true) {
				animal = (Animal) objectIS.readObject();
				System.out.println("");
				System.out.println(animal.getNombre());
				System.out.println(animal.getEdad());
				System.out.println(animal.getRaza());
			}

		} catch (EOFException ex) {
			System.out.println("Fin del fichero");
		}

	}

}