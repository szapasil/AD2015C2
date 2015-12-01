package entities;

import javax.persistence.*;

import dominio.Rodamiento;
@Entity
@Table(name="itemsCotizacion")
public class ItemCotizacionENT {
	
	@EmbeddedId
	private ItemCotizacionENTpk id;
	private int cantidad;
	private float precio;
	public ItemCotizacionENT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemCotizacionENT(ItemCotizacionENTpk id, int cantidad, float precio) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
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
	
}
