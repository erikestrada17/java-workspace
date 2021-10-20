package entidades;

import enumeradores.Tipo;
import otros.Estado;

public class Mascota {
	private String nombre;
	private Estado suciedad, hambre, sueño, felicidad;
	private Tipo tipo;
	
	public Mascota(String nombre, Tipo tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
		inicializarEstados();
		
	}

	private void inicializarEstados() {
		this.suciedad = new Estado(0);
		this.hambre = new Estado(0);
		this.sueño = new Estado(0);
		this.felicidad = new Estado(100);
	}

	public String getNombre() {
		return nombre;
	}

	public Estado getSuciedad() {
		return suciedad;
	}

	public Estado getHambre() {
		return hambre;
	}

	public Estado getSueño() {
		return sueño;
	}

	public Estado getFelicidad() {
		return felicidad;
	}
}
