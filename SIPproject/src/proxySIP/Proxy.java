package proxySIP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import red.CapaRed;

public class Proxy {

		
	private static int puertoescuchaUA;
	private static int puertoescuchaProxy;
	private static boolean loose_routing;
	private static boolean debug;
	
	public static void main(String[] args) {
		if(args.length != 3) {
			System.out.println("Error en linea de comandos\nFormato correcto: java Proxy puertoescuchaProxy loose-routing(true/false) debug(true/false)");
		}

		puertoescuchaProxy = Integer.parseInt(args[0]);
		loose_routing = Boolean.parseBoolean(args[1]);
		debug = Boolean.parseBoolean(args[2]);
		byte[] bufer = new byte[1000];
		
		CapaRed capaRed=new CapaRed();
		capaRed.abrir(puertoescuchaProxy);
		
		while(true){
			
			System.out.println("Esperando mensaje");
			capaRed.recibirPaquete(bufer);
			
			String mensaje = new String(bufer); 
			
			System.out.println(mensaje);
		}
	    /*try {
			DatagramSocket socketUDP = new DatagramSocket(puertoescuchaProxy);
	        DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);
			
	        socketUDP.receive(peticion);
	        String mensaje= new String(peticion.getData());
	        
	        
	        
	        System.out.println(mensaje);
	        
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
