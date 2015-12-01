package entities;

import java.sql.Date;
import java.util.ArrayList;
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
import dominio.Cotizacion;
import dominio.ItemOP;

@Entity
@Table(name="ordenesDePedido")
public class OrdenDePedidoENT {
	@Id
	@Column (name="numero_pedido")
	private int numero;
	@Column
	private Date fechaEnviada;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="numero_sucursal", nullable = false)
	private OVENT ov; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cuilCliente")
	private ClienteENT cliente;
	
	@OneToMany(cascade=CascadeType.ALL ,fetch=FetchType.EAGER ,mappedBy="id.pedido")
	private List<ItemOPENT> items;

	public OrdenDePedidoENT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdenDePedidoENT(int numero, Date fechaEnviada, ClienteENT cliente,
			List<ItemOPENT> items) {
		super();
		this.numero = numero;
		this.fechaEnviada = fechaEnviada;
		this.cliente = cliente;
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

	public ClienteENT getCliente() {
		return cliente;
	}

	public void setCliente(ClienteENT cliente) {
		this.cliente = cliente;
	}

	public List<ItemOPENT> getItems() {
		return items;
	}

	public void setItems(List<ItemOPENT> items) {
		this.items = items;
	}

	
	
	
	/*	
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
*/	
}
