package test;

import delegado.BusinessDelegateCC;

public class TestCC {

	public static void main(String[] args){
		
		BusinessDelegateCC bdCC = new BusinessDelegateCC();
		bdCC.LookupServiceCC();

		//ALTA DE UN PROVEEDOR:
		//bdCC.altaProveedor("30-00000001-9", "Rodamientos S.A.", "Rivadavia 4545");		
		
	}

}
