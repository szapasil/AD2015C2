package srv;

import java.rmi.RemoteException;

import app.CC;

public class TestLocal {

	public static void main(String[] args) {

		try {
			//ALTA PROVEEDOR
//			CC.getInstancia().altaProveedor("30-00000002-9", "Rodamientos Malos", " Av. San Juan 2331");
		
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
			CC.getInstancia().modificarRodamiento("RSA0002", "", "", "", "2x4", "");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	
	}

}