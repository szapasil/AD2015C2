package srv;

import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import app.CPR;
import app.ODV;

import remoto.ICPR;
import remoto.IODV;

public class BusinessService {
    
      
    public void publicarServicioODV()
    {
    	try {
    		IODV stubODV = ODV.getInstancia();
    		//IODV stubODV = new ODV();
    		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
    		Naming.rebind("//localhost/ControladorODV", stubODV);
    		System.out.println("Servicio ControladorODV publicado");
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }
    
    public void publicarServicioCPR()
    {
    	try {
			ICPR stubCPR = CPR.getInstancia();
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
	    	Naming.rebind("//localhost/ControladorCPR", stubCPR);
	    	System.out.println("Servicio ControladorCPR publicado");

		} catch (Exception e) {
		
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
