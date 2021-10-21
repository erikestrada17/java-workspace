package red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class HiloCliente extends Thread {
	
	private DatagramSocket socket;
	private boolean fin = false;

	
	public HiloCliente() {
		try {
			socket = new DatagramSocket();
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
				socket.receive(paquete);
				procesarMensaje(paquete);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(!fin);
	}

	private void procesarMensaje(DatagramPacket paquete) {
		String msg = new String(paquete.getData()).trim();
		if(msg.equals("Desconectado")) {
			this.fin = true;
		} 
		
		System.out.println(msg);
		
		
	
	}
	
	public void enviarMensaje(String msg) {
		byte[] data = msg.getBytes();
		InetAddress ipServer = null;
		try {
			ipServer = InetAddress.getByName("192.168.1.91");//-> en constructor
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		DatagramPacket paquete = new DatagramPacket(data,data.length,ipServer,9995);
		
		try {
			socket.send(paquete);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
