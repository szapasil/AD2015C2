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
		ItemLCDTO ilpDTO = bdCC.publicarLC("NJ209");
		System.out.println("Rodamiento: " + ilpDTO.getRodamiento().getCodRodamiento());
		System.out.println("precio: " + ilpDTO.getPrecio());
		System.out.println("condicion de compra: " + ilpDTO.getCondcompra());
		System.out.println("bonificacion: " + ilpDTO.getBonificacion());
		System.out.println("Proveedor: " + ilpDTO.getCuitProveedor());
	}

}
