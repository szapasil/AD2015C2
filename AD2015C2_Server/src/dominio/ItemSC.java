package dominio;

import hbt.HibernateDAO;
import entities.ItemSCENT;

public class ItemSC {
	
	private Rodamiento rodamiento;
	private float cantidad;
	private float precio;
	
	public ItemSC(Rodamiento rodamiento, float cantidad, float precio) {
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

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void persistirse() {
		ItemSCENT iscENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(iscENT);
	}

	public ItemSCENT toENT() {
		return new ItemSCENT(rodamiento.toENT(), cantidad, precio);
	}
}
