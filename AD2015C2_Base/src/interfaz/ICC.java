package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;

import dto.ItemLCDTO;

public interface ICC extends Remote{

	public void altaProveedor(String cuit, String razonSocial, String direccion) throws RemoteException;

	public void altaListaPrecios(String archivo) throws RemoteException, ParseException; 
	
	public ItemLCDTO publicarLC(String codRodamiento, String codSFK) throws RemoteException;
	
}
