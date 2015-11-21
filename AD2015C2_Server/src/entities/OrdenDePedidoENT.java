package entities;

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

import dominio.Cliente;
import dominio.Cotizacion;
import dominio.ItemOP;

@Entity
@Table(name="ordenesPedido")
public class OrdenDePedidoENT {
	
	@Id
	private int numero;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cuilCliente")
	private Cliente cliente;
	private Date fecha;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="nroOP")
	private List<Cotizacion> cotizaciones;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="nroOP")
	private List<ItemOP> items; 

	public OrdenDePedidoENT() {
		
	}
	
	public OrdenDePedidoENT(int numero, Cliente cliente, Date fecha, List<Cotizacion> cotizaciones) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.fecha = fecha;
		this.cotizaciones = cotizaciones; //ver si en realidad no es new ArrayList - Martin
		this.items = new ArrayList<ItemOP>();
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
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public List<Cotizacion> getCotizaciones() {
		return cotizaciones;
	}
	
	public void setCotizaciones(List<Cotizacion> cotizaciones) {
		this.cotizaciones = cotizaciones;
	}
	
	public List<ItemOP> getItems() {
		return items;
	}
	
	public void setItems(List<ItemOP> items) {
		this.items = items;
	}
	
}
