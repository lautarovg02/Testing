package EjemploEnClaseJunit;

import java.util.*;

public class Persona {

	public Persona(String nombre, String dni, String fechaNacimiento, int edad, boolean habilitadoParaVotar) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.habilitadoParaVotar = habilitadoParaVotar;
		this.dni=dni;
		
	}
	
	String nombre;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getEdad() {
				      return edad;
				      }


	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isHabilitadoParaVotar() {
		return habilitadoParaVotar;
	}
	public void setHabilitadoParaVotar(boolean habilitadoParaVotar) {
		this.habilitadoParaVotar = habilitadoParaVotar;
	}
	public String getDNI() {
		return dni;
	}
	
	
	String fechaNacimiento;
	String dni;
	int edad;
	boolean habilitadoParaVotar;

	@Override
	public String toString() {
		return "Persona{" +
				"nombre='" + nombre + '\'' +
				", fechaNacimiento='" + fechaNacimiento + '\'' +
				", dni='" + dni + '\'' +
				", edad=" + edad +
				", habilitadoParaVotar=" + habilitadoParaVotar +
				'}';
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Persona persona)) return false;
		return Objects.equals(getNombre(), persona.getNombre()) && Objects.equals(dni, persona.dni);
	}
}
