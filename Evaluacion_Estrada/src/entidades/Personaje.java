package entidades;

import enumeradores.Mascotas;
import utiles.Utiles;

public class Personaje {

	private String nombre;
	private float dinero = 1000;
	private Mascota mascota;
	
	public Personaje(String nombre, int nroMasc) {
		this.nombre = nombre;
		asignarMascota(nroMasc);
	}

	private void asignarMascota(int nroMasc) {
		this.mascota = Mascotas.values()[nroMasc-1].getMascota();
	}

	public String getNombre() {
		return nombre;
	}

	public float getDinero() {
		return dinero;
	}

	public Mascota getMascota() {
		return mascota;
	}
	
}
