package dominio;

import hbt.HibernateDAO;
import entities.ItemOPENT;

public class ItemOP {

	private Rodamiento rodamiento;
	private int cantidad;
	private float precio;
	
	public ItemOP(Rodamiento rodamiento, int cantidad, float precio) {
		super();
		this.rodamiento = rodamiento;
		this.cantidad = cantidad;
		this.precio = precio;
		persistirse();
	}
	public ItemOP() {
		super();
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
		ItemOPENT iopENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(iopENT);
	}

	private ItemOPENT toENT() {
		return new ItemOPENT(rodamiento.toENT(), cantidad, precio);
	}
	
}
