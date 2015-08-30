package dominio;

import hbt.PersistentObject;

import javax.persistence.*;

@Entity
@Table(name="itemsSolicitud")
public class ItemSolicitud extends PersistentObject {
	

	private static final long serialVersionUID = 1L;

	private String serie;
	private String sufijo;
	private String marca;
	private String origen;
	private int cantidad;
	private int nroSolicitud;
	

	public ItemSolicitud(String serie, String sufijo, String marca, String origen, int cantidad) 
	{
		super();

		this.serie = serie;
		this.sufijo = sufijo;
		this.marca = marca;
		this.origen = origen;
		this.cantidad = cantidad;
	}
	
	public ItemSolicitud() 
	{

		this.serie = "";
		this.sufijo = "";
		this.marca = "";
		this.origen = "";
		this.cantidad = 0;
	}
	
	public int getNroSolicitud() {
		return nroSolicitud;
	}
	
	public void setNroSolicitud(int nroSolicitud) {
		this.nroSolicitud = nroSolicitud;
	}
	
	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getSufijo() {
		return sufijo;
	}

	public void setSufijo(String sufijo) {
		this.sufijo = sufijo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setCantidad(String cantString) { 
		this.cantidad = Integer.parseInt(cantString);
	}
	
}
