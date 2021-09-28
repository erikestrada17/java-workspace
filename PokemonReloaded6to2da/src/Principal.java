import acciones.Acciones;
import acciones.Batalla;
import pokemons.Jugador;
import pokemons.Pokemon;
import pokemons.Pokemons;
import utilidades.Utiles;

public class Principal {
	
	private static Jugador jugador, enemigo;

	public static void main(String[] args) {
		
		iniciarJuego();

		int nroOpc = 0;
		Acciones opc;
		
		do {
			
			jugador.mostrarEstadisticas();

			nroOpc = Utiles.listarElegir(Acciones.values());		
			
			opc = Acciones.values()[nroOpc];
			
			opc.ejecutar(jugador);
		
			
		} while(opc!=Acciones.SALIR);
		

		
	}

	private static void iniciarJuego() {
		System.out.println("Bienvenidos a la batalla pokemon");
		System.out.println();
		System.out.println("Ingrese su nombre");
		String nombre = Utiles.s.nextLine();
		
		System.out.println("Elija su pokemon");
		
		int opc = Utiles.listarElegir(Pokemons.values());		
		
		Pokemon p = Pokemons.values()[opc].getPokemon();
		
		jugador = new Jugador(nombre,p);		
	}

}
