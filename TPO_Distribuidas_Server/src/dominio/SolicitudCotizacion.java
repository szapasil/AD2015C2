package dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="solicitudesCotizacion")
public class SolicitudCotizacion {

	private Date fechaEnviada;
	@Id
	private int numero;
	private String cuilCliente;
	private String estado;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="nroSolicitud")
	private List<ItemSolicitud> items;
	
		
	public String getCuilCliente() {
		return cuilCliente;
	}
	
	public void setCuilCliente(String cuil) {
		this.cuilCliente = cuil;
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

//	public String toString() {
//		return "\n[numero=" + this.numero + ", fecha=" + this.fechaEnviada + ", Cuil=" + this.cliente.setCuil(cuil) +
//				    ", RazonSocial=" this.cliente.setRazonSocial(razonSocial) + ", serie=" this.]";
//	}
	

}
