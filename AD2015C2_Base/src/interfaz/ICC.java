package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICC extends Remote{

	public void altaProveedor(String cuit, String razonSocial, String direccion) throws RemoteException;
	
}
