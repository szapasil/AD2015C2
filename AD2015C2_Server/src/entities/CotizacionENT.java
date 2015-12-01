package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dominio.Cliente;
import dominio.ItemCotizacion;
import dominio.SolicitudCotizacion;

@Entity
@Table(name="cotizaciones")
public class CotizacionENT {
	@Id
	@Column (name="numero_cotizacion")
	private int numero;
	private Date fechaEnviada;
	private Date fechaExpiracion;

	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="numero_sucursal", nullable = false)
	private OVENT ov; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cuilCliente")
	private ClienteENT cliente;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="numero_solicitudCotizacion",insertable=true,updatable=true,nullable=false,unique=true)
	private SolicitudCotizacionENT solicitudCotizacion;

	@OneToMany(cascade=CascadeType.ALL ,fetch=FetchType.EAGER ,mappedBy="id.cotizacion")
	private List<ItemCotizacionENT> items;

	public CotizacionENT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CotizacionENT(int numero, Date fechaEnviada, Date fechaExpiracion,
			ClienteENT cliente, SolicitudCotizacionENT solicitudCotizacion,
			List<ItemCotizacionENT> items) {
		super();
		this.numero = numero;
		this.fechaEnviada = fechaEnviada;
		this.fechaExpiracion = fechaExpiracion;
		this.cliente = cliente;
		this.solicitudCotizacion = solicitudCotizacion;
		this.items = items;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFechaEnviada() {
		return fechaEnviada;
	}

	public void setFechaEnviada(Date fechaEnviada) {
		this.fechaEnviada = fechaEnviada;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public ClienteENT getCliente() {
		return cliente;
	}

	public void setCliente(ClienteENT cliente) {
		this.cliente = cliente;
	}

	public SolicitudCotizacionENT getSolicitudCotizacion() {
		return solicitudCotizacion;
	}

	public void setSolicitudCotizacion(SolicitudCotizacionENT solicitudCotizacion) {
		this.solicitudCotizacion = solicitudCotizacion;
	}

	public List<ItemCotizacionENT> getItems() {
		return items;
	}

	public void setItems(List<ItemCotizacionENT> items) {
		this.items = items;
	}
	
	

}
