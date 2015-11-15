package srv;

import java.rmi.RemoteException;

import app.CC;
import app.OV;

public class TestLocal {

	public static void main(String[] args) {

		try {
			//ALTA PROVEEDOR
			CC.getInstancia().altaProveedor("30-00000001-9", "Rodamientos S.A.", "Rivadavia 4545");
			CC.getInstancia().altaProveedor("30-00000002-9", "Rodamientos Malos", "Av. San Juan 2331");
		
			//BAJA PROVEEDOR
//			CC.getInstancia().bajaProveedor("30-00000002-9");
			
			//MODIFICAR PROVEEDOR
//			CC.getInstancia().modificarProveedor("30-00000002-9", "", "Av. San Juan 2333");
	  		
			//BUSCAR PROVEEDOR
//			ProveedorENT provEnt = ProveedorDAO.getInstancia().BuscarProveedor("30-00000001-9");
//			System.out.println(provEnt.getDireccion());
	
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
				
			
			//ALTA RODAMIENTO
			CC.getInstancia().altaRodamiento("RSA0001", "ZKL", "USA", "Bolilla", "1x3", "SFK2502");
			CC.getInstancia().altaRodamiento("RSA0002", "ZKL", "USA", "Rodillo", "1x3", "SFK2503");
					
		
			//BAJA RODAMIENTO
//			CC.getInstancia().bajaRodamiento("RSA0001");
			
			//MODIFICAR RODAMIENTO
//			CC.getInstancia().modificarRodamiento("RSA0002", "", "", "", "2x4", "");
			
			//ALTA LISTA COMPARATIVA
			CC.getInstancia().altaListaComp();
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	
	}

}