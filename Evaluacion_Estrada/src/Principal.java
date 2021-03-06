import entidades.Personaje;
import enumeradores.Mascotas;
import enumeradores.Tipo;
import utiles.Utiles;

public class Principal {
	
	static Personaje p;
	public static void main(String[] args) {
		System.out.println("Bienvenido al juego de mascotas virtuales");
		System.out.println("\nIngrese su nombre: ");
		String nombre = Utiles.s.nextLine();
		System.out.println("\nAdopte una mascota:");
		mostrarMascotas();
		int nroMasc = Utiles.ingresarEntero(1, 3);
		p = new Personaje(nombre, nroMasc);
		
		mostrarEstadisticas();
	}
	
	private static void mostrarEstadisticas() {
		// TODO Auto-generated method stub
		
	}

	private static void mostrarMascotas() {
		for (int i = 0; i < Mascotas.values().length; i++) {
			System.out.println((i+1)+") "+ Mascotas.values()[i].getNombre() + "  |  Tipo: " + Tipo.values()[i]);
		}
	}

}