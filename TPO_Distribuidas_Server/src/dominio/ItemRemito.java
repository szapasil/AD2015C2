package dominio;

import hbt.PersistentObject;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ItemsRemito")
public class ItemRemito extends PersistentObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codRodamiento;
	private int cantidad;
	private float precio;
	private String lista;
	
	public ItemRemito(int cantidad, String codRodamiento, float precio,	String lista) {
		super();
		this.cantidad = cantidad;
		this.codRodamiento = codRodamiento;
		this.precio = precio;
		this.lista = lista;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getcodRodamiento() {
		return codRodamiento;
	}
	
	public void setcodRodamiento(String codRodamiento) {
		this.codRodamiento = codRodamiento;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String getLista() {
		return lista;
	}
	
	public void setLista(String lista) {
		this.lista = lista;
	}
	
}
