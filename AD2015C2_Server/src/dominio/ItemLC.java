package dominio;

import java.util.ArrayList;
import java.util.List;

public class ItemLC {

	private Rodamiento rodamiento;
	private float precio;
	private int stock;
	private List<CondCompra> condicionesCompra;
	private Proveedor proveedor;
	
	public ItemLC() {
		
	}

	public ItemLC(Rodamiento rodamiento, float precio, int stock,
			List<CondCompra> condicionesCompra, Proveedor proveedor) {
		super();
		this.rodamiento = rodamiento;
		this.precio = precio;
		this.stock = stock;
		this.condicionesCompra = new ArrayList<CondCompra>();
		this.proveedor = proveedor;
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

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<CondCompra> getCondicionesCompra() {
		return condicionesCompra;
	}

	public void setCondicionesCompra(List<CondCompra> condicionesCompra) {
		this.condicionesCompra = condicionesCompra;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

}
