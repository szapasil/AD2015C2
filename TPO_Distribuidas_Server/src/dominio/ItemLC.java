package dominio;

import javax.persistence.*;

@Entity
@Table(name="itemsLC")
public class ItemLC {

	@Id
	private Rodamiento rodamiento;
	private float precio;
	private float descuento;
	private String condiciones;
	private int stock;
	private Proveedor proveedor;

	public ItemLC(Rodamiento rodamiento, float precio, float descuento,	String condiciones, int stock, Proveedor proveedor) {
		super();
		this.rodamiento = rodamiento;
		this.precio = precio;
		this.descuento = descuento;
		this.condiciones = condiciones;
		this.stock = stock;
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
	
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public void modificarItemLC(ListaPrecios lp,ItemLP ilp) {
		setPrecio(ilp.getPrecio());
		setDescuento(ilp.getDescuento());
		setCondiciones(ilp.getCondiciones());
		setStock(ilp.getStock());
		setProveedor(lp.getProveedor());
	}

}