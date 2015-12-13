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
	
	public void altaCliente(String razonSocial, String direccion, String cuil,
			String condicionIVA, String condicionPago, float descuento, int nroSucursal){
    	try {
    		ov.altaCliente(razonSocial, direccion, cuil, condicionIVA, condicionPago, descuento, nroSucursal);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
     	
}
