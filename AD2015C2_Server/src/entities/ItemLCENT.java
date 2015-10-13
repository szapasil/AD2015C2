package entities;

import hbt.PersistentObject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="itemsLC")
public class ItemLCENT extends PersistentObject {
	
	@OneToOne
	@JoinColumn(name="codRodamiento")
	private RodamientoENT rodamiento;
	private float precio;
	private int stock;
	@OneToMany
	@JoinColumn(name="itemLC")
	private List<CondCompraENT> condicionesCompra;
	@OneToOne
	@JoinColumn(name="cuitProveedor")
	private ProveedorENT proveedor;
	
	public ItemLCENT() {
		
	}

	public ItemLCENT(RodamientoENT rodamiento, float precio, int stock,
			List<CondCompraENT> condicionesCompra, ProveedorENT proveedor) {
		super();
		this.rodamiento = rodamiento;
		this.precio = precio;
		this.stock = stock;
		this.condicionesCompra = new ArrayList<CondCompraENT>();
		this.proveedor = proveedor;
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

	public ProveedorENT getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorENT proveedor) {
		this.proveedor = proveedor;
	}

	
}
