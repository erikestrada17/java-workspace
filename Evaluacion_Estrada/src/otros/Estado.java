package otros;

public class Estado {
	
	private int cantidad;
	
	public Estado(int cantidad) {
		this.cantidad = cantidad;
	}
	
	private int comprobarValor(int valor) {
		return (valor>100)?100:(valor<0)?0:valor;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = comprobarValor(cantidad);
	}

}
