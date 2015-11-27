package test;

import delegado.BusinessDelegateCC;
import dto.ItemLCDTO;

public class TestCC {

	public static void main(String[] args){
		
		BusinessDelegateCC bdCC = new BusinessDelegateCC();
		bdCC.LookupServiceCC();

		//ALTA DE UN PROVEEDOR:
		bdCC.altaProveedor("30-00000001-9", "Rodamientos S.A.", "Rivadavia 4545");
		
		//ALTA LISTA DE PRECIOS
		bdCC.altaListaPrecios("ListaPrecios1001.xml");
		
		//PUBLICAR LISTA COMPARATIVA:
		System.out.println(bdCC.publicarLC("NJ209", "SFK0002"));
		ItemLCDTO ilpDTO = bdCC.publicarLC("NJ209", "SFK0002");
		System.out.println("Rodamiento NJ209 o similar");
		System.out.println("precio: " + ilpDTO.getPrecio());
		System.out.println("condicion de compra: " + ilpDTO.getCondcompra());
		System.out.println("bonificacion: " + ilpDTO.getBonificacion());
		
	}

}
