package acciones;

import items.Tienda;
import pokemons.Jugador;
import utilidades.Utiles;

public class Comprar implements Ejecutable {

	@Override
	public void ejecutar(Jugador j) {
		if(j.getDinero()<1) {
			System.out.println("Vuelva cuando tenga dinero");
		} else {
			for (int i = 0; i < Tienda.values().length; i++) {
				System.out.println((i+1)+") " + Tienda.values()[i].getNombre() + " precio: " + Tienda.values()[i].getPrecio());
			}
			int opc;
			boolean repite = false;
			
			do {
				repite = false; 
				
				opc = Utiles.ingresarEntero(1,Tienda.values().length)-1;
				if(j.getDinero()>=Tienda.values()[opc].getPrecio()) {
					j.getItems().add(Tienda.values()[opc].getItem());
					System.out.println("Se ha agregado " + Tienda.values()[opc].getNombre() + " a su lista de items");
					j.descontarDinero(Tienda.values()[opc].getPrecio());
				} else {
					System.out.println("1) Volver a elegir");
					System.out.println("2) Volver al menu");
					opc = Utiles.ingresarEntero(1,2);
					if(opc==1) {
						repite = true;
					}
				}
			
			}while(repite);
		}	
	}

}
