package dominio;

import hbt.HibernateDAO;
import entities.ItemOCENT;

public class ItemOC {

	private Rodamiento rodamiento;
	private int cantidad;
	private float precio;
	
	public ItemOC(Rodamiento rodamiento, int cantidad, float precio) {
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
	
	private void persistirse() {
		ItemOCENT iocENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(iocENT);
	}

	private ItemOCENT toENT() {
		return new ItemOCENT(rodamiento.toENT(), cantidad, precio);
	}
	
}