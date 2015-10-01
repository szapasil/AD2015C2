package srv;

import interfaz.ICC;
import interfaz.IOV;

import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import app.CC;
import app.OV;

public class BusinessService {
    
      
    public void publicarServicioOV() {
    	try {
    		IOV stubOV = new OV();
    		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
    		Naming.rebind("//localhost/ControladorOV", stubOV);
    		System.out.println("Servicio ControladorOV publicado");
    	}
    	catch (Exception e)	{
    		e.printStackTrace();
    	}
    	
    }
    
    public void publicarServicioCC() {
    	try {
			ICC stubCC = CC.getInstancia();
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
	    	Naming.rebind("//localhost/ControladorCC", stubCC);
	    	System.out.println("Servicio ControladorCC publicado");
		} 
    	catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    public void verVinculos() {
        try {
      	  String[] vinculos = Naming.list( "" );
      	  System.out.print(InetAddress.getLocalHost().getHostAddress());
      	  for ( int i = 0; i < vinculos.length; i++ ){
      		System.out.println( vinculos[i] );
      	  }
      	  System.out.print( ">>> Servicio publicado");
        }
        catch (Exception e) {
      	  e.printStackTrace();
        }
     }
    
    public void cerrar() {
		try {
			Naming.unbind("Controlador");
		} catch (Exception e) {
		} finally {
			System.exit(0);
		}
    }
    
}
