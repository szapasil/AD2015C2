package dominio;

import hbt.HibernateDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.ProveedorENT;
import entities.SolicitudCotizacionENT;


public class SolicitudCotizacion {

	
	
	private Date fechaEnviada;	
	private int numero;
	private Cliente cliente;
	private String estado;
	private List<ItemSolicitud> items;
	
	
	
	
	public SolicitudCotizacion(Date fechaEnviada, int numero,
			Cliente cliente, String estado) {
		super();
		this.fechaEnviada = fechaEnviada;
		this.numero = numero;
		this.cliente = cliente;
		this.estado = estado;
		this.items =  new ArrayList<ItemSolicitud>();

	}
	
		
	public SolicitudCotizacion(){
		
		
	}


	public Date getFechaEnviada() {
		return fechaEnviada;
	}


	public void setFechaEnviada(Date fechaEnviada) {
		this.fechaEnviada = fechaEnviada;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}




	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public List<ItemSolicitud> getItems() {
		return items;
	}


	public void setItems(List<ItemSolicitud> items) {
		this.items = items;
	}
	
	
	
	
}
