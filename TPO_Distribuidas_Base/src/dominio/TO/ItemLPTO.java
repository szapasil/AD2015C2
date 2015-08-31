package dominio.TO;

import java.io.Serializable;

public class ItemLPTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private RodamientoTO rodamiento;
	private float descuento;
	private String condicion;
	private float recargo;
	private int stock;
	private float precio;
	
	public ItemLPTO(RodamientoTO rodamiento, float descuento, String condicion,
			float recargo, int stock, float precio) {
		super();
		this.rodamiento = rodamiento;
		this.descuento = descuento;
		this.condicion = condicion;
		this.recargo = recargo;
		this.stock = stock;
		this.precio = precio;
	}

	public RodamientoTO getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(RodamientoTO rodamiento) {
		this.rodamiento = rodamiento;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public float getRecargo() {
		return recargo;
	}

	public void setRecargo(float recargo) {
		this.recargo = recargo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "ItemLPTO [rodamiento=" + rodamiento + ", descuento="
				+ descuento + ", condicion=" + condicion + ", recargo="
				+ recargo + ", stock=" + stock + ", precio=" + precio + "]";
	}  

}
