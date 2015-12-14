package dominio;

import hbt.HibernateDAO;
import entities.ItemOPENT;

public class ItemOP {

	private Rodamiento rodamiento;
	private int cantidad;
	private float precio;
	private String estado;
	private Cotizacion cotizacion;
	
	public ItemOP(Rodamiento rodamiento, int cantidad, float precio, String estado, Cotizacion cotizacion) {
		super();
		this.rodamiento = rodamiento;
		this.cantidad = cantidad;
		this.precio = precio;
		this.estado = estado;
		this.cotizacion = cotizacion;
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

	public Cotizacion getCotizacion() {
		return cotizacion;
	}
	public void setCotizacion(Cotizacion cotizacion) {
		this.cotizacion = cotizacion;
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
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
/*	public void persistirse() {
		ItemOPENT iopENT = toENT();
		HibernateDAO.getInstancia().saveOrUpdate(iopENT);
	}
*/
/*	private ItemOPENT toENT() {
		return new ItemOPENT(rodamiento.toENT(), cantidad, precio);
	}
	*/
}
