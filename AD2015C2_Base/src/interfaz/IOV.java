package interfaz;

import java.rmi.Remote;

public interface IOV extends Remote{
	
	public void altaCliente(String razonSocial, String direccion, String cuil,
			String condicionIVA, String condicionPago, float descuento, int nroSucursal) throws Exception;
	
}
