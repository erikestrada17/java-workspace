package items;

public enum Tienda {
	
	POCIONVIDACHICA("PocionVidaChica","Pocion de vida chica",100),
	POCIONVIDAGRANDE("PocionVidaGrande","Pocion de vida grande",500),
	HAMBURGUESA("Hamburguesa",50);
	
	private String clase, nombre;
	private int precio;
	
	private Tienda(String clase, String nombre, int precio) {
		this.clase = clase;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	private Tienda(String nombre, int precio) {
		this.clase = nombre;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public Item getItem() {
		Item i = null;
		String nombreClase = "items."+this.clase;
		try {
			Class clase = Class.forName(nombreClase);
			i = (Item) clase.newInstance();
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return i;
	}
	

}
