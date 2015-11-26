package entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="listasPrecios")
public class ListaPreciosENT {

	@Id
	private int numero;
	private Date fecha;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cuitProveedor")
	private ProveedorENT proveedor;
	
	@OneToMany(mappedBy="id",cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="nroLP")
	private List<ItemLPENT> items;

	public ListaPreciosENT() {
		
	}
	
	public ListaPreciosENT(int numero, Date fecha, ProveedorENT proveedor) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.proveedor = proveedor;
		this.items = new ArrayList<ItemLPENT>();
	}

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
