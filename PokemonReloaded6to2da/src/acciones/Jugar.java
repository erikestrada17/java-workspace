package acciones;

import pokemons.Jugador;
import utilidades.Utiles;

public class Jugar implements Ejecutable {

	@Override
	public void ejecutar(Jugador j) {
		
		int opc = Utiles.listarElegir(Juegos.values());
		
		Juegos.values()[opc].getJuego().ejecutar(j);
	}

	
}
