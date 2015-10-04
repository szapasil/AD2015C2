package dominio;

import java.util.Date;
import java.util.List;


public class SolicitudCotizacion {

	
	
	private Date fechaEnviada;	
	private int numero;
	private String cuilCliente;
	private String estado;
	private List<ItemSolicitud> items;
	
	
	
	
	public SolicitudCotizacion(Date fechaEnviada, int numero,
			String cuilCliente, String estado, List<ItemSolicitud> items) {
		super();
		this.fechaEnviada = fechaEnviada;
		this.numero = numero;
		this.cuilCliente = cuilCliente;
		this.estado = estado;
		this.items = items;
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


	public String getCuilCliente() {
		return cuilCliente;
	}


	public void setCuilCliente(String cuilCliente) {
		this.cuilCliente = cuilCliente;
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
