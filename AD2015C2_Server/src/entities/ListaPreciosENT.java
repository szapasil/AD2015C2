package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import dominio.ItemLP;
import dominio.Proveedor;

public class ListaPreciosENT {

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="proveedor")
	private Proveedor proveedor;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="nroLista")
	private List<ItemLP> items;

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

}
