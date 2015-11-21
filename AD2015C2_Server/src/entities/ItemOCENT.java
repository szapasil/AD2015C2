package entities;

import hbt.PersistentObject;

import javax.persistence.*;

@Entity
@Table(name="itemsLP")
public class ItemOCENT extends PersistentObject {
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codRodamiento")
	private RodamientoENT rodamiento;
	private int cantidad;
	private float precio;
	
	public ItemOCENT(RodamientoENT rodamiento, int cantidad, float precio) {
		super();
		this.rodamiento = rodamiento;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public RodamientoENT getRodamiento() {
		return rodamiento;
	}
	
	public void setRodamiento(RodamientoENT rodamiento) {
		this.rodamiento = rodamiento;
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
