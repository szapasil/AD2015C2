package delegado;

import interfaz.IOV;

import java.rmi.Naming;

public class BusinessDelegateOV {

	IOV ov;
	
	public void LookupServiceOV(){
    	try{
    		ov = (IOV) (Naming.lookup("//localhost/ControladorOV"));
    	} catch (Exception e){
    		javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    }
     	
}
