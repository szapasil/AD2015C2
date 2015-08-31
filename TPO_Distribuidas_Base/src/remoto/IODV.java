package remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;


public interface IODV extends Remote{

	public void cargarClientes(String archivo) throws RemoteException; //carga la lista de clientes del archivo xml
	
	// MR0306 - Cambio "cargarCliente" por "altaCliente" para no confundirlo con "cargarClientes" y que coincida con ABM
	public void altaCliente(String cuil, String razonSocial, Date fechaRegistro, float monto, String direccion) throws RemoteException; //carga un solo cliente
	public void bajaCliente(String cuil) throws RemoteException;
	public void modificarCliente(String cuil, String razsoc, float monto, String direccion) throws RemoteException;
	
	// Este metodo luego debe eliminarce de la interfas porque el cliente solo puede cargar una Solicitud de Cotizacion luego de que el sistema lo haya identificado como tal - Martin
	public void cargarSolicitudCotizacion(String archivo) throws RemoteException; //Cargo en la BD la solicitud de cotizacion xml de un cliente
	
	public void recibirSolicitudCotizacion(String cuil, String archivo) throws RemoteException;
	
	
}
