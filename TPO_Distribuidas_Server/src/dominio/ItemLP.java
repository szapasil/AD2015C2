package dominio;

import hbt.PersistentObject;

import javax.persistence.*;

@Entity
@Table(name="itemsLP")
public class ItemLP extends PersistentObject {  
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Rodamiento rodamiento;
	private float precio;
	private float descuento;
	private String condiciones;
	private int stock;

	public ItemLP(Rodamiento rodamiento, float precio, float descuento,	String condiciones, int stock) {
		super();
		this.rodamiento = rodamiento;
		this.precio = precio;
		this.descuento = descuento;
		this.condiciones = condiciones;
		this.stock = stock;
	}

	public Rodamiento getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public String getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(String condiciones) {
		this.condiciones = condiciones;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}