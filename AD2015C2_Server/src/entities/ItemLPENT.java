package entities;

import hbt.PersistentObject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import dominio.Rodamiento;

@Entity
@Table(name="itemsLP")
public class ItemLPENT {
	
	@EmbeddedId
	private ItemLPENTpk id;
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="codRodamiento")
//	private RodamientoENT rodamiento;
	private float precio;
	private int stock;	
	private int condCompra;
	private int bonificacion;
	
//	@OneToMany(mappedBy="id",cascade=CascadeType.ALL)
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@JoinColumn(name="itemLP")
//	private List<CondCompraENT> condicionesCompra;

	public ItemLPENT() {
		
	}
	
	public ItemLPENT(ListaPreciosENT listaPrecios, RodamientoENT rodamiento, float precio, int stock, int condCompra, int bonificacion) {
		super();
		this.id = new ItemLPENTpk(listaPrecios, rodamiento);
//		this.rodamiento = rodamiento;
		this.precio = precio;
		this.stock = stock;
		this.condCompra = condCompra;
		this.bonificacion = bonificacion;
	}




//	public RodamientoENT getRodamiento() {
//		return rodamiento;
//	}

//	public void setRodamiento(RodamientoENT rodamiento) {
//		this.rodamiento = rodamiento;
//	}

	public ItemLPENTpk getId() {
		return id;
	}

	public void setId(ItemLPENTpk id) {
		this.id = id;
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

//	public List<CondCompraENT> getCondicionesCompra() {
//		return condicionesCompra;
//	}

//	public void setCondicionesCompra(List<CondCompraENT> condicionesCompra) {
//		this.condicionesCompra = condicionesCompra;
//	}

	public int getCondcompra() {
		return condCompra;
	}

	public void setCondcompra(int condCompra) {
		this.condCompra = condCompra;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

}
