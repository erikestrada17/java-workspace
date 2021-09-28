package items;

import pokemons.Pokemon;

public class PocionVida extends Pocion {

	public PocionVida(int precio, int valor) {
		super(precio);
		this.valor=valor;
	}

	@Override
	public void consumir(Pokemon p) {
		p.setVida(p.getVida()+this.valor);
	}	
	
	
}
