package remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface ICPR extends Remote{
	
	public void altaProveedor(String razonSocial,String direccion,String cuil,String condicionesPago,float descuento,
			  String condicionesCompra) throws RemoteException;
	
	public void bajaProveedor(String cuil) throws RemoteException;
	
	public void modificarProveedor(String razonSocial,String direccion,String cuil,String condicionesPago,float descuento,
			  String condicionesCompra,String estado) throws RemoteException;
	
	public void cargarProveedores(String archivo) throws RemoteException;
	
	public void cargarListaDePrecios(String archivo) throws RemoteException;
	
	public void crearListaComparativa() throws RemoteException;
	
	
}
