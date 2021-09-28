package acciones;

import pokemons.Jugador;

public class Dormir implements Ejecutable{

	@Override
	public void ejecutar(Jugador j) {	
		System.out.println(j.getP().getNombre() + " Durmio y recupero la energia");
		j.getP().setSuenio(0);
	}

}
