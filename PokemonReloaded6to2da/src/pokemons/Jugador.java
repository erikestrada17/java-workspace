package pokemons;

import java.util.ArrayList;

import items.Item;

public class Jugador {
	
	private Pokemon p;
	private String nombre;
	private int dinero=100;
	
	private ArrayList<Item> items = new ArrayList();
	
	public Jugador(String nombre, Pokemon p) {
		this.p = p;
		this.nombre = nombre;
	}
	
	public Pokemon getP() {
		return p;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getDinero() {
		return dinero;
	}
	
	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public void descontarDinero(int monto) {
		this.dinero -= monto;
	}
	
	public void agregarDinero(int monto) {
		this.dinero += monto;
	}
	
	public void mostrarEstadisticas() {
		System.out.println("Jugador: " + this.nombre);
		System.out.println("Dinero: $ " + this.dinero);
		this.p.mostrarEstadisticas();
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}

}
