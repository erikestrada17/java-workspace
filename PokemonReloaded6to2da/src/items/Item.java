package items;

import pokemons.Pokemon;

public abstract class Item {

	private int precio;
	
	public Item(int precio) {
		this.precio = precio;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public abstract void consumir(Pokemon p);  
	
}
