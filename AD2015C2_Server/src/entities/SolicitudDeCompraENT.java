package entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="solicitudesCompra")
public class SolicitudDeCompraENT {
	
	@Id
	private int numero;
	private Date fecha;
	private float precioTotal;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="nroSC")
	private List<OrdenDePedidoENT> ordenesDePedido;
	private String estado;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="nroSC")
	private List<ItemSCENT> items;

	public SolicitudDeCompraENT() {
		
	}
	
	public SolicitudDeCompraENT(int numero, Date fecha, float precioTotal, List<OrdenDePedidoENT> ordenesDePedido, String estado) {
		super();
		this.numero = numero;
		this.fecha = fecha;
		this.precioTotal = precioTotal;
		this.ordenesDePedido = ordenesDePedido;
		this.estado = estado;
		this.items = new ArrayList<ItemSCENT>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public List<OrdenDePedidoENT> getOrdenesDePedido() {
		return ordenesDePedido;
	}

	public void setOrdenesDePedido(List<OrdenDePedidoENT> ordenesDePedido) {
		this.ordenesDePedido = ordenesDePedido;
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
