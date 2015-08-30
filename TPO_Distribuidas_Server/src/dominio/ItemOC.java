package dominio;

import hbt.PersistentObject;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ItemsOC")
public class ItemOC extends PersistentObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codRodamiento;
	private int cantidad;
	private String lista;
	private float precio;
	
	public ItemOC(String codRodamiento, int cantidad, String lista, float precio) {
		super();
		this.codRodamiento = codRodamiento;
		this.cantidad = cantidad;
		this.lista = lista;
		this.precio = precio;
	}
	
	public String getCodRodamiento() {
		return codRodamiento;
	}
	
	public void setCodRodamiento(String codRodamiento) {
		this.codRodamiento = codRodamiento;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getLista() {
		return lista;
	}
	
	public void setLista(String lista) {
		this.lista = lista;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
