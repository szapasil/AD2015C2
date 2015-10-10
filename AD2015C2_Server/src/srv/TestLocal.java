package srv;

import java.rmi.RemoteException;

import app.CC;

public class TestLocal {

	public static void main(String[] args) {

		try {
			//ALTA PROVEEDOR
			CC.getInstancia().altaProveedor("30-00000002-9", "Rodamientos Malos", " Av. San Juan 2331");
		
			//BAJA PROVEEDOR
			CC.getInstancia().bajaProveedor("30-00000002-9");
			
			//MODIFICAR PROVEEDOR
			CC.getInstancia().modificarProveedor("30-00000001-9", "", "Rivadavia 3054");
	  		
			//BUSCAR PROVEEDOR
			//ProveedorENT provEnt = ProveedorDAO.getInstancia().BuscarProveedor("30-00000001-9");
			//System.out.println(provEnt.getDireccion());
		
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	
	}

}