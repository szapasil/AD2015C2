package delegado;

import interfaz.ICC;

import java.rmi.Naming;
import java.rmi.RemoteException;

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
	
}
