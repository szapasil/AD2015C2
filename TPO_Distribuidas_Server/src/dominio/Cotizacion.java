package dominio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cotizaciones")
public class Cotizacion {
	
	@Id
	private int numero;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="solicitudCotizacion")
	private SolicitudCotizacion solicitudCotizacion;
	private Date vigenteHasta;
	private float precioTotal;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="item")
	private List<ItemCotizacion> items;
	
	public Cotizacion(int numero, SolicitudCotizacion solicitudCotizacion,
			Date vigenteHasta, float precioTotal, List<ItemCotizacion> items) {
		super();
		this.numero = numero;
		this.solicitudCotizacion = solicitudCotizacion;
		this.vigenteHasta = vigenteHasta;
		this.precioTotal = precioTotal;
		this.items =  new ArrayList<ItemCotizacion>();;
	}
		
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public SolicitudCotizacion getSolicitudCotizacion() {
		return solicitudCotizacion;
	}
	
	public void setSolicitudCotizacion(SolicitudCotizacion solicitudCotizacion) {
		this.solicitudCotizacion = solicitudCotizacion;
	}
	
	public Date getVigenteHasta() {
		return vigenteHasta;
	}
	
	public void setVigenteHasta(Date vigenteHasta) {
		this.vigenteHasta = vigenteHasta;
	}
	
	public float getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public List<ItemCotizacion> getItems() {
		return items;
	}
	
	public void setItems(List<ItemCotizacion> items) {
		this.items = items;
	}
	
}
