package entities;

import hbt.PersistentObject;

import javax.persistence.*;

@Entity
@Table(name="itemsSC")
public class ItemSCENT extends PersistentObject {
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codRodamiento")
	private RodamientoENT rodamiento;
	private float cantidad;
	private float precio;
	
	public ItemSCENT() {
		
	}
	
	public ItemSCENT(RodamientoENT rodamiento, float cantidad, float precio) {
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

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
