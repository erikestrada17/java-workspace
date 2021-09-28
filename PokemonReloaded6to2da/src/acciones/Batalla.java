package acciones;

import pokemons.Jugador;
import pokemons.Jugadores;
import pokemons.Pokemon;
import pokemons.Pokemons;
import utilidades.Utiles;

public class Batalla implements Ejecutable {

	@Override
	public void ejecutar(Jugador j) {
		
		int nroPok = Utiles.r.nextInt(Pokemons.values().length);
		Pokemon pE = Pokemons.values()[nroPok].getPokemon();		
		Jugador e = new Jugador("Gary Oak",pE);
		
		int nroTurno=0;
		boolean fin = false;

		nroTurno = Utiles.r.nextInt(2);
		
		Jugadores turno = Jugadores.values()[nroTurno];
		System.out.println();
		System.out.println("Empieza " + ((turno==Jugadores.JUGADOR)?j.getNombre():e.getNombre()));
		
		do {			
			if(turno==Jugadores.JUGADOR) {
				
				int opc = Utiles.listarElegir(j.getP().getAtaques());
				
				
				j.getP().atacar(opc,e.getP());
				turno=Jugadores.ENEMIGO;
			} else {
				
				turno = Jugadores.JUGADOR;
			}
			
		} while(!fin);
	}




}
