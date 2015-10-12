package srv;

import java.rmi.RemoteException;
import java.util.List;

import dao.ClienteDAO;
import dominio.Cliente;
import dominio.CondPago;
import dominio.Cotizacion;
import dominio.Factura;
import dominio.OrdenDeCompra;
import dominio.OrdenDePedido;
import dominio.Remito;
import dominio.SolicitudCotizacion;
import entities.ClienteENT;
import app.CC;
import app.OV;

public class TestLocal {

	public static void main(String[] args) {

		try {
			//ALTA PROVEEDOR
		//	CC.getInstancia().altaProveedor("30-00000002-1", "Rodamientos Malos", " Av. San Juan 2332");
		
			//BAJA PROVEEDOR
//			CC.getInstancia().bajaProveedor("30-00000002-9");
			
			//MODIFICAR PROVEEDOR
//			CC.getInstancia().modificarProveedor("30-00000001-9", "", "Rivadavia 3054");
	  		
			//BUSCAR PROVEEDOR
//			ProveedorENT provEnt = ProveedorDAO.getInstancia().BuscarProveedor("30-00000001-9");
//			System.out.println(provEnt.getDireccion());
		
			//ALTA RODAMIENTO
//			CC.getInstancia().altaRodamiento("RSA0001", "ZKL", "USA", "Bolilla", "1x3", "SFK2502");
//			CC.getInstancia().altaRodamiento("RSA0002", "ZKL", "USA", "Rodillo", "1x3", "SFK2503");
					
		
			//BAJA RODAMIENTO
//			CC.getInstancia().bajaRodamiento("RSA0001");
			
			//MODIFICAR RODAMIENTO
			//CC.getInstancia().modificarRodamiento("RSA0002", "", "", "", "2x4", "");
			
			
			OV ovtest = new OV("Suc1", null, null, null,
					null, null, null, null, null); 		
			
			//ALTA CLIENTE
		
	//	ovtest.altaCliente("20-30000002-6", "Gaston R", " Oro 1800");

			
			//BAJA CLIENTE
			//ovtest.bajaCliente("20-30000002-6");
			
			//MODIFICAR CLIENTE
	//	ovtest.modificarCliente("20-30000002-6", "pepe", "Rivadavia 3054");
	  		
			//BUSCAR CLIENTE
			// ClienteENT cliEnt = ClienteDAO.getInstancia().BuscarCliente("20-30000002-6");
			
			
			//System.out.println(cliEnt.getDireccion());
		
		
		

			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	
	}

}