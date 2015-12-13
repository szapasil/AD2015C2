package test;

import delegado.BusinessDelegateOV;

public class TestOV {

	
	public static void main(String[] args) {
	
		BusinessDelegateOV bdOV = new BusinessDelegateOV();
		bdOV.LookupServiceOV();
		
		//ALTA DE UN CLIENTE:
		bdOV.altaCliente("Martin Reca","Nueva York 3054","20-3093165-6","Inscripto","Contado",20,1);
	}

}
