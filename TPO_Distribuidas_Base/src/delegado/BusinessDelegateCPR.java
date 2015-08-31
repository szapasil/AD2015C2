package delegado;

import java.rmi.Naming;
import java.rmi.RemoteException;

import remoto.ICPR;

public class BusinessDelegateCPR {

	ICPR cpr;
	
	public void LookupServiceCPR(){
    	try	{
    		cpr = (ICPR) (Naming.lookup("//localhost/ControladorCPR"));
    	}catch (Exception e){
    		javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    }
	
	public void cargaDeProveedoresDesdeXML(String archivo){
    	System.out.println("Cargando proveedores en la BD...");
    	try {
			cpr.cargarProveedores(archivo);
			System.out.println("Proveedores cargados.");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
	
	
	public void altaProveedor(String razonSocial,String direccion,String cuil,String condicionesPago,
    		float descuento,String condicionesCompra){
    	try {
    		cpr.altaProveedor(razonSocial,direccion,cuil,condicionesPago,descuento,condicionesCompra);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    }
    
    public void bajaProveedor(String cuil){
    	try {
    		cpr.bajaProveedor(cuil);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    }
    
    public void modificarProveedor(String razonSocial,String direccion,String cuil,String condicionesPago,
    		float descuento,String condicionesCompra,String estado){
    	try {
    		cpr.modificarProveedor(razonSocial,direccion,cuil,condicionesPago,descuento,condicionesCompra,estado);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    }
    
    public void cargarListaDePreciosXML(String archivo){
    	try {
			cpr.cargarListaDePrecios(archivo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    }
	
    public void generarListaComparativa() {
    	try {
			cpr.crearListaComparativa();
		} catch (RemoteException e) {
	
			e.printStackTrace();
		}
    }
	
}
