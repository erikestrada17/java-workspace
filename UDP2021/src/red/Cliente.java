package red;

public class Cliente {
	
	private HiloCliente hc;
	boolean bandera = true;
	
	public Cliente() {
		hc = new HiloCliente();
		hc.start();
	}

	public HiloCliente getHc() {
		return hc;
	}
}
