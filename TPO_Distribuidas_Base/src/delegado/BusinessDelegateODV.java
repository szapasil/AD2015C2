package delegado;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Date;

import remoto.IODV;

public class BusinessDelegateODV {

	IODV odv;
	
	public void LookupServiceODV(){
    	try{
    		odv = (IODV) (Naming.lookup("//localhost/ControladorODV"));
    	} catch (Exception e){
    		javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    }
    
    public void cargaDeClientesDesdeXML(String archivo) {
    	System.out.println("Cargando clientes en la BD...");
    	try {
			odv.cargarClientes(archivo);
			System.out.println("Clientes cargados.");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
    
    public void cargarUnCliente(String cuil, String razsoc, Date fecha, float monto, String direccion) {
    	try {
    		odv.altaCliente(cuil, razsoc, fecha, monto, direccion);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    }
    
    public void bajaDeUnCliente(String cuil) {
    	try {
    		odv.bajaCliente(cuil);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    }
    
    public void actualizarUnCliente(String cuil, String razsoc, float monto, String direccion) {
    	try {
			odv.modificarCliente(cuil, razsoc, monto, direccion);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
    
    public void cargarSolicitudDesdeXML(String archivo) {
    	try {
			odv.cargarSolicitudCotizacion(archivo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
       	
}
