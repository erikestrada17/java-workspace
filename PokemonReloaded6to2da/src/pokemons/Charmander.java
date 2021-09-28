package pokemons;

import ataques.Arañazo;
import ataques.Ascuas;
import ataques.Ataque;
import ataques.Gruñido;
import ataques.PantallaDeHumo;

public class Charmander extends Pokemon {
	
	public Charmander() {
		super("Charmander",750);
		this.crearAtaques();
	}

	@Override
	public void crearAtaques() {
		super.ataques = new Ataque[4];
		super.ataques[0] = new Arañazo();
		super.ataques[1] = new Gruñido();
		super.ataques[2] = new Ascuas();
		super.ataques[3] = new PantallaDeHumo();		
	}

}
