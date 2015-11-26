package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dominio.Cliente;
import dominio.ItemSolicitud;
import dominio.SolicitudCotizacion;


@Entity
@Table(name="SolicitudesCotizacion")
public class SolicitudCotizacionENT {
	@Id
	@Column(name="numero_Solicitud")
	private int numeroSolicitud;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cuilCliente")
	private ClienteENT cliente;
	private Date fechaEnviada;	
	@OneToMany(cascade=CascadeType.ALL ,fetch=FetchType.LAZY ,mappedBy="id.solicitudCotizacion")
	private List<ItemSolENT> items;

	public SolicitudCotizacionENT(int numero, ClienteENT cliente,
			Date fechaEnviada) {
		super();
		this.numeroSolicitud = numero;
		this.cliente = cliente;
		this.fechaEnviada = fechaEnviada;
		this.items = new ArrayList<ItemSolENT> ();
	}
	public SolicitudCotizacionENT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNumeroSolicitud() {
		return numeroSolicitud;
	}
	public void setNumeroSolicitud(int numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}
	public ClienteENT getCliente() {
		return cliente;
	}
	public void setCliente(ClienteENT cliente) {
		this.cliente = cliente;
	}
	public Date getFechaEnviada() {
		return fechaEnviada;
	}
	public void setFechaEnviada(Date fechaEnviada) {
		this.fechaEnviada = fechaEnviada;
	}
	public List<ItemSolENT> getItems() {
		return items;
	}
	public void setItems(List<ItemSolENT> items) {
		this.items = items;
	}
}
