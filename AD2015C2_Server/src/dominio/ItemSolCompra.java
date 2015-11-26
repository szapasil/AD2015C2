package dominio;

import hbt.HibernateDAO;
import entities.ItemSolCompraENT;

public class ItemSolCompra {
	
	private Rodamiento rodamiento;
	private int cantidad;
	private float precio;
	
	public ItemSolCompra(Rodamiento rodamiento, int cantidad, float precio) {
		super();
		this.rodamiento = rodamiento;
		this.cantidad = cantidad;
		this.precio = precio;
		persistirse();
	}

	public Rodamiento getRodamiento() {
		return rodamiento;
	}

	public void setRodamiento(Rodamiento rodamiento) {
		this.rodamiento = rodamiento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void persistirse() {
		ItemSolCompraENT iscENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(iscENT);
	}

	public ItemSolCompraENT toENT() {
		return new ItemSolCompraENT(rodamiento.toENT(), cantidad, precio);
	}
}
