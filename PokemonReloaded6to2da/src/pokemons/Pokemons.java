package pokemons;

import utilidades.Listable;

public enum Pokemons implements Listable {
	
	PIKACHU("Pikachu"), CHARMANDER("Charmander"), SQUIRTLE("Squirtle");
	
	private String nombre;
	
	private Pokemons(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Pokemon getPokemon() {
		Pokemon p = null;
		String nombreClase = "pokemons."+this.nombre;
		try {
			Class clase = Class.forName(nombreClase);
			p = (Pokemon) clase.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return p;
	}


}
