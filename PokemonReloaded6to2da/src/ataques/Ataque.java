package ataques;

import utilidades.Listable;

public abstract class Ataque implements Listable{
	
	private int da�o, precision, cantVeces;
	private String nombre;
	
	public Ataque(int da�o, int cantVeces, int precision) {
		this.da�o = da�o;
		this.cantVeces = cantVeces;
		this.precision = precision;
		this.nombre = this.getClass().getName();
		this.nombre = this.nombre.substring(this.nombre.lastIndexOf(".")+1,this.nombre.length());
	}

	public String getNombre() {
		return nombre;
	}
}
