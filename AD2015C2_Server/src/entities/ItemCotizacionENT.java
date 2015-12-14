package entities;

import javax.persistence.*;

@Entity
@Table(name="itemsCotizacion")
public class ItemCotizacionENT {
	
	@EmbeddedId
	private ItemCotizacionENTpk id;
	private int cantidad;
	private float precio;
	private int condicionCompra;
	private int bonificacion;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cuitProveedor")
	private ProveedorENT proveedor;
	
	public ItemCotizacionENT() {
		super();
	}
	
	public ItemCotizacionENT(ItemCotizacionENTpk id, int cantidad, float precio, int condicionCompra,
			int bonificacion, ProveedorENT proveedor) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.condicionCompra = condicionCompra;
		this.bonificacion = bonificacion;
		this.proveedor = proveedor;
	}
	
	public ItemCotizacionENT(CotizacionENT cot, RodamientoENT rodamiento, int cantidad, float precio, int condicionCompra,
			int bonificacion, ProveedorENT proveedor) {
		super();
		this.id = new ItemCotizacionENTpk(cot, rodamiento);
		this.cantidad = cantidad;
		this.precio = precio;
		this.condicionCompra = condicionCompra;
		this.bonificacion = bonificacion;
		this.proveedor = proveedor;
	}
	
	public ItemCotizacionENTpk getId() {
		return id;
	}
	
	public void setId(ItemCotizacionENTpk id) {
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

	public int getCondicionCompra() {
		return condicionCompra;
	}

	public void setCondicionCompra(int condicionCompra) {
		this.condicionCompra = condicionCompra;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

	public ProveedorENT getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorENT proveedor) {
		this.proveedor = proveedor;
	}
	
}
