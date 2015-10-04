package dominio;

import java.util.List;

public class ItemLP {

	private Rodamiento rodamiento;
	private float precio;
	private int stock;
	private List<CondCompra> condicionesCompra;

	public ItemLP(Rodamiento rodamiento, float precio, int stock, List<CondCompra> condicionesCompra) {
		super();
		this.rodamiento = rodamiento;
		this.precio = precio;
		this.stock = stock;
		this.condicionesCompra = condicionesCompra;
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
/*
	public dto.ItemLP toDTO() {
		return new dto.ItemLP(this.condicionesCompra,this.precio,this.rodamiento,this.stock);
	}
*/
}