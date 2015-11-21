package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import hbt.PersistentObject;

@Entity
@Table(name="itemsOP")
public class ItemOPENT extends PersistentObject {

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codRodamiento")
	private RodamientoENT rodamiento;
	private int cantidad;
	private float precio;
	
	public ItemOPENT() {
		
	}
	public ItemOPENT(RodamientoENT rodamiento, int cantidad, float precio) {
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
