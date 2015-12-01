package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dominio.Cotizacion;
import dominio.Rodamiento;
import hbt.PersistentObject;

@Entity
@Table(name="itemsOrdenDePedido")
public class ItemOPENT {
	
	@EmbeddedId
	private ItemOPENTpk id;
	@Column
	private int cantidad;
	@Column
	private float precio;
	public ItemOPENT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemOPENT(ItemOPENTpk id, int cantidad, float precio) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
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

	
	
/*
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
*/	
}
