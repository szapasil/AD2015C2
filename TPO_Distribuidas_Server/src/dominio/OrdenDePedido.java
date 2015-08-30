package dominio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordenesDePedido")
public class OrdenDePedido {
	
	private int numero;
	private String estado;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cliente")
	private Cliente cliente;
	private Date fecha;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="item")
	private List<ItemOP> items; 
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="cotizacion")
	private List<Cotizacion> cotizaciones; 
		
	public OrdenDePedido(int numero, String estado, Cliente cliente,
			Date fecha, List<ItemOP> items, List<Cotizacion> cotizaciones) {
		super();
		this.numero = numero;
		this.estado = estado;
		this.cliente = cliente;
		this.fecha = fecha;
		this.items = new ArrayList<ItemOP>();
		this.cotizaciones = new ArrayList<Cotizacion>();
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
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public List<ItemOP> getItems() {
		return items;
	}
	
	public void setItems(List<ItemOP> items) {
		this.items = items;
	}
	
	public List<Cotizacion> getCotizaciones() {
		return cotizaciones;
	}
	
	public void setCotizaciones(List<Cotizacion> cotizaciones) {
		this.cotizaciones = cotizaciones;
	}
	
}
