package entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

public class ListaPreciosENT {

	@Id
	private int numero;
	private Date fecha;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="proveedor")
	private ProveedorENT proveedor;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="nroLista")
	private List<ItemLPENT> items;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ProveedorENT getProveedor() {
		return proveedor;
	}
	
	public void setProveedor(ProveedorENT proveedor) {
		this.proveedor = proveedor;
	}

		public List<ItemLPENT> getItems() {
		return items;
	}

	public void setItems(List<ItemLPENT> items) {
		this.items = items;
	}

}
