package transaccion;

import java.util.ArrayList;
import java.util.Random;

import mensajesSIP.RegisterMessage;

public class CrearSIP {
	
	public RegisterMessage crearRegister(String IPProxy,String direccionIP, String usuario, String dominio,int  puertoescuchaUA){
		
		RegisterMessage rm=new RegisterMessage();
		
		System.out.println("Generando mensaje REGISTER\n");
		System.out.println("");
		
		rm.setDestination(IPProxy);
		ArrayList <String> vias= new ArrayList<>();
		vias.add(direccionIP+":"+puertoescuchaUA);
		rm.setVias(vias);
		rm.setMaxForwards(70);
		rm.setToName(usuario);
		rm.setToUri("sip:"+usuario+"@"+dominio);
		rm.setFromName(usuario);
		rm.setFromUri("sip:"+usuario+"@"+dominio);
		Random rand = new Random();
		int min = 1;
		int max = 10000;
		int randomNum = rand.nextInt((max - min) + 1) + min;
		String callId = Integer.toString(randomNum);
		rm.setCallId(callId);
		int cont=1;
		rm.setcSeqNumber(Integer.toString(cont));
		cont++;
		rm.setcSeqStr("REGISTER");
		rm.setContact(direccionIP+":"+puertoescuchaUA);
		rm.setExpires("7200");
		rm.setContentLength(0);
		
		//System.out.println("Imprimiendo mensaje REGISTER generado por API");
		//System.out.println(rm.toStringMessage());
		
		return rm;
		
		
	}
}
