package entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="listasPrecios")
public class ListaPreciosENT {

	@Id
	private int numero;
	private Date fecha;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cuitProveedor")
	private ProveedorENT proveedor;
	
	@OneToMany(cascade=CascadeType.ALL ,fetch=FetchType.LAZY ,mappedBy="id.listaPrecios")
	private List<ItemLPENT> items;

	public ListaPreciosENT() {
		
	}
	
	public ListaPreciosENT(int numero, Date fecha, ProveedorENT proveedor) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.proveedor = proveedor;
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
