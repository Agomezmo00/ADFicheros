package ficherosAleatorios;

import java.util.Date;
import java.util.Random;


public class Contacto {
	
	String nombre;
	String direccion;
	String telefono;
	String email;
	int grupo;
	double deuda;
	Date nacimiento;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGrupo() {
		return grupo;
	}
	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}
	public double getDeuda() {
		return deuda;
	}
	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}
	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	public Contacto getContactoRandom() {
		double deudas[] = {123, 132.43, 42, 3, 17, 99};
		String nombres[] = {"Pepito ", "Juanito ", "Manolito ", "Miguelito ", "Blas ", "Luisito "};
		String telefonos[] = {"974123456","974321654","987654321","555123456","897654342","976543218"};
		String email[]= {"fulanito@aol.com","menganito@yahoo.es", "fdad@hotmail.com", "miha@yandex.ru", "shurs@hotmail.com", "snot@baltimore.com"};
		int grupos[] = {1,2,3,4,5,6};
		String direcciones[] = {"Los robles, 22", "La Justicia, 12", "La fuente, 33", "Independencia, 25", "Castilla, 53", "Corona, 1"};
		
		Random ran = new Random();
		
		this.nombre = nombres[ran.nextInt(5)];
		this.email = email[ran.nextInt(5)];
		this.telefono = telefonos[ran.nextInt(5)];
		this.grupo = grupos[ran.nextInt(5)];
		this.direccion = direcciones[ran.nextInt(5)];
		this.deuda = deudas[ran.nextInt(5)];
		this.nacimiento = new Date();
		
		return this;
		
		
	}

}
