package principal;
import red.Cliente;
import red.Servidor;
import utiles.Utiles;

public class ProgramaCliente {
	
	static Cliente cliente;

	public static void main(String[] args) {
	
		cliente = new Cliente();		
		boolean fin = false;

		
		do {
			System.out.println("1) Conectarse");
			System.out.println("2) Enviar mensaje");
			System.out.println("3) Salir");
			int opc = Utiles.ingresarEntero(1,3);
			
			if(opc==1) {
				cliente.getHc().enviarMensaje("Conexion");
			} else if(opc==2) {
				System.out.println("Ingrese un mensaje");
				String msg = Utiles.s.nextLine();
				cliente.getHc().enviarMensaje(msg);
			} else {
				cliente.getHc().enviarMensaje("Desconecto");
				fin = true;
			}
			
		}while(!fin);
		
		

		
	}

}
