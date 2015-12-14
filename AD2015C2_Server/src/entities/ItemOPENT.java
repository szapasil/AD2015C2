package entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="itemsOrdenDePedido")
public class ItemOPENT {
	
	@EmbeddedId
	private ItemOPENTpk id;
	@Column
	private int cantidad;
	@Column
	private float precio;
	private String estado;
	
	public ItemOPENT() {
		super();
	}
	
	public ItemOPENT(OrdenDePedidoENT op, RodamientoENT rodamiento, CotizacionENT cot, int cantidad,
			float precio, String estado) {
		super();
		this.id = new ItemOPENTpk(op, rodamiento, cot);
		this.cantidad = cantidad;
		this.precio = precio;
		this.estado = estado;
	}
	
	public ItemOPENT(ItemOPENTpk id, int cantidad, float precio, String estado) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.estado = estado;
	}
	
	public ItemOPENTpk getId() {
		return id;
	}
	
	public void setId(ItemOPENTpk id) {
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
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
