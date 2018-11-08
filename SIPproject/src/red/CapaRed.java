package red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class CapaRed {
	
	private static DatagramSocket SocketUDP;
	
	public void abrir(int puertoUDP) {
		try {
			SocketUDP = new DatagramSocket(puertoUDP);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void enviarPaquete(String paquete,String direccionIP, int puerto){
	    try {
	    	
			DatagramPacket peticion =
			          new DatagramPacket(paquete.getBytes(), paquete.getBytes().length,
			        		  InetAddress.getByName(direccionIP), puerto);
			SocketUDP.send(peticion);
		}catch (SocketException e){
			System.err.println("Socket: "+e.getMessage());
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("IO: "+e.getMessage());
		} 
	}
	public byte[] recibirPaquete(byte[] bufer){
		
		
		DatagramPacket peticion =
		          new DatagramPacket(bufer, bufer.length);
		        
		        // Leemos una petición del DatagramSocket
		        try {
					SocketUDP.receive(peticion);
			        System.out.print("Datagrama recibido del host: " +
			                           peticion.getAddress());
			        System.out.println(" desde el puerto remoto: " +
			                           peticion.getPort());

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		return peticion.getData();
	}
	
	public void cerrar() {
		SocketUDP.close();
	}
}
