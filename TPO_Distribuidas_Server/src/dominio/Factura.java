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
@Table(name="facturas")
public class Factura {
	
	private int numero;
	private String estado;
	private Date fecha;
	private String situacion;
	private float montoTotal;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="item")
	private List <ItemFactura> items;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cliente")
	private Cliente cliente;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="remito")
	private Remito remito;
	private OrdenDePedido ordenDePedido;
	
	public Factura(int numero, String estado, Date fecha, String situacion,
			float montoTotal, List<ItemFactura> items, Cliente cliente,
			Remito remito, OrdenDePedido ordenDePedido) {
		super();
		this.numero = numero;
		this.estado = estado;
		this.fecha = fecha;
		this.situacion = situacion;
		this.montoTotal = montoTotal;
		this.items =  new ArrayList<ItemFactura>();
		this.cliente = cliente;
		this.remito = remito;
		this.ordenDePedido = ordenDePedido;
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
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getSituacion() {
		return situacion;
	}
	
	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}
	
	public float getMontoTotal() {
		return montoTotal;
	}
	
	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}
	
	public List<ItemFactura> getItems() {
		return items;
	}
	
	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Remito getRemito() {
		return remito;
	}
	
	public void setRemito(Remito remito) {
		this.remito = remito;
	}
	
	public OrdenDePedido getOrdenDePedido() {
		return ordenDePedido;
	}
	
	public void setOrdenDePedido(OrdenDePedido ordenDePedido) {
		this.ordenDePedido = ordenDePedido;
	}
	
}
