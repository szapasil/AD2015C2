package dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javax.persistence.*;

import dominio.DAO.ListaPreciosDAO;

@Entity
@Table(name="listasPrecios")
public class ListaPrecios extends Observable {

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="proveedor")
	private Proveedor proveedor;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="nroLista")
	private List<ItemLP> items;

	public ListaPrecios(Proveedor proveedor,List<ItemLP> items) {
		super();
		this.proveedor = proveedor;
		this.items = new ArrayList<ItemLP>();
		setChanged();
		notifyObservers(this);
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

	public void insertDAO() {
		ListaPreciosDAO.getInstancia().cargarLista(this);
	}
	
}
