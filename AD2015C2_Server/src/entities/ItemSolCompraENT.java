package entities;

import javax.persistence.*;

@Entity
@Table(name="itemsSC")
public class ItemSolCompraENT  {
	
	@EmbeddedId
	private ItemSolCompraENTpk id; 
	private int cantidad;
	private float precio;
	
	@OneToOne
	@JoinColumn(name="cuitProveedor")
	private ProveedorENT proveedor;

	public ItemSolCompraENT() {
		super();
	}
	
	public ItemSolCompraENT(RodamientoENT rodamiento, SolicitudDeCompraENT solicitudCompra, int cantidad, 
			float precio, ProveedorENT proveedor) {
		ItemSolCompraENTpk id = new ItemSolCompraENTpk();
		id.setRodamiento(rodamiento);
		id.setSolicitudCompra(solicitudCompra);
		this.cantidad = cantidad;
		this.precio = precio;
		this.proveedor = proveedor;
	}
	
	public ItemSolCompraENTpk getId() {
		return id;
	}
	
	public void setId(ItemSolCompraENTpk id) {
		this.id = id;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	

	public ProveedorENT getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorENT proveedor) {
		this.proveedor = proveedor;
	}
}
