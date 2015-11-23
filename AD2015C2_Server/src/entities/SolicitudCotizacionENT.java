package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="SolicitudesCotizacion")
public class SolicitudCotizacionENT {

		
	private Date fechaEnviada;	
	@Id
	private int numero;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cuilCliente")
	private ClienteENT cliente;
	private String estado;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="nroSC")
	private List<ItemSCENT> items;
	
	
	public SolicitudCotizacionENT() {
		
	}
	
	public SolicitudCotizacionENT(Date fechaEnviada, int numero,
			ClienteENT cliente, String estado) {
		super();
		this.fechaEnviada = fechaEnviada;
		this.numero = numero;
		this.cliente = cliente;
		this.estado = estado;
		this.items =  new ArrayList<ItemSCENT>();
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


	public ClienteENT getCliente() {
		return cliente;
	}


	public void setCliente(ClienteENT cliente) {
		this.cliente = cliente;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public List<ItemSCENT> getItems() {
		return items;
	}


	public void setItems(List<ItemSCENT> items) {
		this.items = items;
	}

	
	
}
