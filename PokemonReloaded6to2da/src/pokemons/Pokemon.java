package pokemons;

import ataques.Ataque;

public abstract class Pokemon {
	
	private String nombre;
	private int vida, suenio=80, hambre=50;
	protected Ataque[] ataques;
	
	public Pokemon(String nombre, int vida) {
		this.nombre = nombre;
		this.vida = vida;
	}
	
	public Ataque[] getAtaques() {
		return this.ataques;
	}
	
	public void atacar(int indAtaque, Pokemon oponente) {
		
	}
	
	public abstract void crearAtaques();
	
	public String getNombre() {
		return nombre;
	}

	public int getCantAtaques() {
		return this.ataques.length;
	}
	
	public int getSuenio() {
		return suenio;
	}
	
	public void setSuenio(int suenio) {
		this.suenio = suenio;
		if(this.suenio<0) this.suenio=0;
		if(this.suenio>100) this.suenio=100;
	}
	
	public int getHambre() {
		return hambre;
	}
	
	public void setHambre(int hambre) {
		this.hambre = hambre;
		if(this.hambre<0) this.hambre=0;
		if(this.hambre>100) this.hambre=100;
	}
	
	public int getVida() {
		return vida;
	}
	
	public void setVida(int vida) {
		this.vida = vida;
		if(this.vida<0) this.vida=0;
		if(this.vida>100) this.vida=100;
	}
	
	public void mostrarEstadisticas() {
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Vida: " + this.vida + " hp");
		System.out.println("Suenio: " + this.suenio);
	}
}
