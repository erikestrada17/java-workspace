package acciones;

import pokemons.Jugador;
import utilidades.Utiles;

public class CaraOCeca implements Jugable, Ejecutable {

	@Override
	public void ejecutar(Jugador j) {
		System.out.println("Bienvenido al cara o ceca " + PI);
		if(j.getDinero()>0) {
			System.out.println("Ingrese su apuesta $[1-"+j.getDinero()+"]");
			int apuesta = Utiles.ingresarEntero(1,j.getDinero());
			j.descontarDinero(apuesta);
			System.out.println("Elija una opcion");
			for (int i = 0; i < Moneda.values().length; i++) {
				System.out.println((i+1)+") " + Moneda.values()[i]);
			}
			int opc = Utiles.ingresarEntero(1,Moneda.values().length)-1;
			Moneda eleccion = Moneda.values()[opc];
			System.out.println("Se tira la moneda");
			int ran = Utiles.r.nextInt(Moneda.values().length);
			Moneda salio = Moneda.values()[ran];
			System.out.println("Salio " + salio);
			if(eleccion==salio) {
				System.out.println("Ganaste $" + (apuesta*2));
				j.agregarDinero(apuesta*2);
			} else {
				System.out.println("Perdiste $ " + apuesta);
			}
		} else {
			System.out.println("Vuelva cuando tenga dinero");
		}
	}

	@Override
	public void jugar() {
	}

}
