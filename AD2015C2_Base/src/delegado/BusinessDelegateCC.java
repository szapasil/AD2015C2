package delegado;

import interfaz.ICC;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.text.ParseException;

import dto.ItemLCDTO;

public class BusinessDelegateCC {

	ICC cc;
	
	public void LookupServiceCC(){
    	try	{
    		cc = (ICC) (Naming.lookup("//localhost/ControladorCC"));
    	}catch (Exception e){
    		javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    }
	
	public void altaProveedor(String cuit,String razonSocial, String direccion){
    	try {
    		cc.altaProveedor(cuit,razonSocial,direccion);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	}
    }

	public void altaListaPrecios(String archivo) {
		try {
    		cc.altaListaPrecios(archivo);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ItemLCDTO publicarLC(String codRodamiento) {
		try {
    		return cc.publicarLC(codRodamiento);
    	} catch (RemoteException e) {
    		e.printStackTrace();
    		return null;
    	}
	}	
	
}
