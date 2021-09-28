package acciones;

import pokemons.Jugador;
import utilidades.Listable;

public enum Acciones implements Listable {

	COMPRAR("Comprar",new Comprar()),DORMIR("Dormir", new Dormir()),JUGAR("Jugar", new Jugar()),SALIR("Salir",null);
	
	private String nombre;
	private Ejecutable accion;
	
	private Acciones(String nombre, Ejecutable accion) {
		this.nombre = nombre;
		this.accion = accion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void ejecutar(Jugador j) {
		if(this.accion!=null) {
			this.accion.ejecutar(j);
		}
	}
	
}
