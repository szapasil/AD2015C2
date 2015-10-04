package entities;

import java.util.List;

import hbt.PersistentObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemsLP")
public class ItemLPENT extends PersistentObject {
	
	@Id
	private RodamientoENT rodamiento;
	private float precio;
	private int stock;
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
