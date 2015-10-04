package dominio;

import java.util.ArrayList;
import java.util.List;

public class ListaPrecios {
	
	private Proveedor proveedor;
	private List<ItemLP> items;

	public ListaPrecios(Proveedor proveedor,List<ItemLP> items) {
		super();
		this.proveedor = proveedor;
		this.items = new ArrayList<ItemLP>();
	}

	
	public ListaPrecios(){
		
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

		public List<ItemLP> getItems() {
		return items;
	}

	public void setItems(List<ItemLP> items) {
		this.items = items;
	}
/*
	public dto.ListaPrecios toDTO() {
		return new dto.ListaPrecios(this.proveedor,this.items);
	}
*/
}
