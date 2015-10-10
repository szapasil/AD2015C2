package srv;

import java.rmi.RemoteException;

import app.CC;
import dao.ProveedorDAO;
import entities.ProveedorENT;

public class TestLocal {

	public static void main(String[] args) {
	/*
	  	//BUSCAR PROVEEDOR
		ProveedorENT provEnt = ProveedorDAO.getInstancia().BuscarProveedor("30-00000001-9");
		System.out.println(provEnt.getDireccion());	
		
		//ALTA PROVEEDOR
		try {
			CC.getInstancia().altaProveedor("30-00000001-9", "Rodamientos S.A.", "Rivadavia 4545");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	
		//BAJA PROVEEDOR
		try {
			CC.getInstancia().bajaProveedor("30-00000001-9");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	*/	
		//MODIFICAR PROVEEDOR
		try {
			CC.getInstancia().modificarProveedor("30-00000001-9", "", "Rivadavia 4573");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

}
