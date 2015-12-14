package entities;

import javax.persistence.*;

@Entity
@Table(name="itemsCotizacion")
public class ItemCotizacionENT {
	
	@EmbeddedId
	private ItemCotizacionENTpk id;
	private int cantidad;
	private float precio;
	
	public ItemCotizacionENT() {
		super();
	}
	
	public ItemCotizacionENT(ItemCotizacionENTpk id, int cantidad, float precio) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public ItemCotizacionENT(CotizacionENT cot, RodamientoENT rodamiento, int cantidad) {
		super();
		this.id = new ItemCotizacionENTpk(cot, rodamiento);
		this.cantidad = cantidad;
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
