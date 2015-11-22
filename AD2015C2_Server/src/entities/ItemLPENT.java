package entities;

import hbt.PersistentObject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="itemsLP")
public class ItemLPENT extends PersistentObject {
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codRodamiento")
	private RodamientoENT rodamiento;
	private float precio;
	private int stock;	
	
	@OneToMany(mappedBy="id",cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="itemLP")
	private List<CondCompraENT> condicionesCompra;

	public ItemLPENT() {
		
	}
	
	public ItemLPENT(RodamientoENT rodamiento, float precio, int stock) {
		super();
		this.rodamiento = rodamiento;
		this.precio = precio;
		this.stock = stock;
		this.condicionesCompra = new ArrayList<CondCompraENT>();
	}
	
	
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
