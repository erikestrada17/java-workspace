package red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class HiloServidor extends Thread {
	
	private DatagramSocket socket;
	private boolean fin = false;
	
	private InetAddress ipCliente1, ipCliente2;
	private int puertoCliente1, puertoCliente2;
	private int nroClientes = 0;
	
	public HiloServidor() {
		try {
			socket = new DatagramSocket(9995);
			System.out.println("Servidor creado");
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		do {
			byte[] data = new byte[1024];
			DatagramPacket paquete = new DatagramPacket(data,data.length);
			try {
				System.out.println("Servidor a la espera de algun mensaje");
				socket.receive(paquete);
				procesarMensaje(paquete);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(!fin);
	}

	private void procesarMensaje(DatagramPacket paquete) {
		String msg = new String(paquete.getData()).trim();
			

		if(msg.equals("Conexion")) {
			if(nroClientes==0) {
				ipCliente1 = paquete.getAddress();
				puertoCliente1 = paquete.getPort();
				nroClientes++;
				this.enviarMensaje("Conexion exitosa",ipCliente1, puertoCliente1);
			} else if (nroClientes==1){
				ipCliente2 = paquete.getAddress();
				puertoCliente2 = paquete.getPort();
				nroClientes++;
				this.enviarMensaje("Conexion exitosa",ipCliente2, puertoCliente2);
			} else {
				this.enviarMensaje("Servidor lleno",paquete.getAddress(), paquete.getPort());
			}
		} else if (msg.equals("Desconecto")){
		
			
				if(esClienteRegistrado(paquete.getAddress(), paquete.getPort())) {
					if(devolverNroCliente(paquete.getAddress(),paquete.getPort())==1){
						this.enviarMensaje("Cliente 1 se ha desconectado", ipCliente2,puertoCliente2);
						this.enviarMensaje("Desconectado", ipCliente1,puertoCliente1);
						ipCliente1 = null; puertoCliente1=0;
						ipCliente1 = ipCliente2; puertoCliente1 = puertoCliente2;
						ipCliente2 = null; puertoCliente2=0;
					} else {
						this.enviarMensaje("Cliente 2 se ha desconectado", ipCliente1,puertoCliente1);
						this.enviarMensaje("Desconectado", ipCliente2,puertoCliente2);
						ipCliente2 = null; puertoCliente2=0;
					}
					nroClientes--;
				}
			
		
		} else {
		
			if(nroClientes==2) {
				if(esClienteRegistrado(paquete.getAddress(), paquete.getPort())) {
					if(devolverNroCliente(paquete.getAddress(),paquete.getPort())==1){
						this.enviarMensaje("Cliente 1 dice: " + msg,ipCliente2,puertoCliente2);
					} else {
						this.enviarMensaje("Cliente 2 dice: " + msg,ipCliente1,puertoCliente1);
					}
					
				
				} // else acceso denegado
			} else {
				if(esClienteRegistrado(paquete.getAddress(), paquete.getPort())) {
					System.out.println("Llego el mensaje");
					enviarMensaje("Esperando al otro cliente", paquete.getAddress(),paquete.getPort());
				} else {
					System.out.println("Direccion desconocida");
				}
			}
			
		}
		
		
	}
	
	private int devolverNroCliente(InetAddress address, int port) {
		if((address.equals(ipCliente1) && port==puertoCliente1)) {
			return 1;
		}
		return 2;
	}

	private boolean esClienteRegistrado(InetAddress address, int port) {
		if((address.equals(ipCliente1) && port==puertoCliente1)||(address.equals(ipCliente2) && port==puertoCliente2)) {
			return true;
		}
		return false;
	}

	public void enviarMensaje(String msg, InetAddress ip, int puerto) {
		byte[] data = msg.getBytes();
		DatagramPacket paquete = new DatagramPacket(data,data.length, ip, puerto);
		
		try {
			socket.send(paquete);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
