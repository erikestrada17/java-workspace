package acciones;

import utilidades.Listable;

public enum Juegos implements Listable {

	BATALLA("Batalla","Batalla"), CARAOCECA("Cara o Ceca","CaraOCeca");
	
	private String nombre;
	private String clase;
	
	private Juegos(String nombre, String clase) {
		this.nombre = nombre;
		this.clase = clase;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Ejecutable getJuego() {
		Ejecutable a = null;
		String nombreClase = this.clase;
		try {
			Class clase = Class.forName("acciones."+nombreClase);
			a = (Ejecutable) clase.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return a;
		
	}
	
}
