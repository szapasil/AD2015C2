package delegado;

import interfaz.ICC;

import java.rmi.Naming;

public class BusinessDelegateCC {

	ICC cc;
	
	public void LookupServiceCC(){
    	try	{
    		cc = (ICC) (Naming.lookup("//localhost/ControladorCC"));
    	}catch (Exception e){
    		javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
    	}
    }
	
}
