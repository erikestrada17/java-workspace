package items;

import pokemons.Pokemon;

public abstract class Comida extends Item {
	
	private int reduceHambre;
	
	public Comida(int precio, int reduce) {
		super(precio);
		this.reduceHambre=reduce;
	}
	
	@Override
	public void consumir(Pokemon p) {
		p.setHambre(p.getHambre() +  this.reduceHambre);
	}
}
