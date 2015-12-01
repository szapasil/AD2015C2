package entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="remitosProvCC")
public class RemitoProvCCENT {

	@Id
	private int numero;
	private Date fecha;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cuitProveedor")
	private ProveedorENT proveedor;
	
	@OneToMany(cascade=CascadeType.ALL ,fetch=FetchType.LAZY ,mappedBy="id.remito")
	private List<OrdenDeCompraENT> ordenesDeCompra;
	
	@OneToMany(cascade=CascadeType.ALL ,fetch=FetchType.LAZY ,mappedBy="id.remito")
	private List<ItemRPCCENT> items;

	public RemitoProvCCENT() {
		
	}
	
	public RemitoProvCCENT(int numero, Date fecha, ProveedorENT proveedor) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.proveedor = proveedor;
		this.ordenesDeCompra = new ArrayList<OrdenDeCompraENT>();
		this.items = new ArrayList<ItemRPCCENT>();
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

		public List<OrdenDeCompraENT> getOrdenesDeCompra() {
		return ordenesDeCompra;
	}

	public void setOrdenesDeCompra(List<OrdenDeCompraENT> ordenesDeCompra) {
		this.ordenesDeCompra = ordenesDeCompra;
	}

		public List<ItemRPCCENT> getItems() {
		return items;
	}

	public void setItems(List<ItemRPCCENT> items) {
		this.items = items;
	}

}
