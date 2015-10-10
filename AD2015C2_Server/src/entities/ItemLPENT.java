package entities;

import hbt.PersistentObject;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="itemsLP")
public class ItemLPENT extends PersistentObject {
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codRodamiento")
	private RodamientoENT rodamiento;
	private float precio;
	private int stock;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="itemLP")
	private List<CondCompraENT> condicionesCompra;

	public RodamientoENT getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(RodamientoENT rodamiento) {
		this.rodamiento = rodamiento;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<CondCompraENT> getCondicionesCompra() {
		return condicionesCompra;
	}

	public void setCondicionesCompra(List<CondCompraENT> condicionesCompra) {
		this.condicionesCompra = condicionesCompra;
	}
	
}
