package red;

public class Servidor {
	
	private HiloServidor hs;
	
	public Servidor() {
		hs = new HiloServidor();
		hs.start();
	}

	public HiloServidor getHs() {
		return hs;
	}
}
