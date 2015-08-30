package dominio;

import hbt.PersistentObject;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ItemsSC")
public class ItemSC extends PersistentObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numero;
	private String codRodamiento;
	private int cantidad;
	private float precio;
		
	public ItemSC(int numero, String codRodamiento, int cantidad, float precio) {
		super();
		this.numero = numero;
		this.codRodamiento = codRodamiento;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
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
	
	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
