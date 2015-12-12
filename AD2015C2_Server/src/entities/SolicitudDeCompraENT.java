package entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="solicitudesCompra")
public class SolicitudDeCompraENT {
	
	@Id
	@Column(name="numero_solicitudCompra")
	private int numero;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="numero_sucursal", nullable = false)	
	private OVENT ov;
	private Date fechaEmision;
	private Date fechaEntregaEstimada;
	private float precioTotal;
//	@OneToMany(cascade=CascadeType.ALL, mappedBy="numero_pedido")
//	private List<OrdenDePedidoENT> ordenesDePedido;
	private String estado;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="id.solicitudCompra")
	private List<ItemSolCompraENT> items;

	public SolicitudDeCompraENT() {
		
	}

	public SolicitudDeCompraENT(int numero, OVENT ov, Date fechaEmision, Date fechaEntregaEstimada, 
			float precioTotal, String estado) {
		super();
		this.numero = numero;
		this.ov = ov;
		this.fechaEmision = fechaEmision;
		this.fechaEntregaEstimada = fechaEntregaEstimada;
		this.precioTotal = precioTotal;
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public OVENT getOv() {
		return ov;
	}

	public void setOv(OVENT ov) {
		this.ov = ov;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaEntregaEstimada() {
		return fechaEntregaEstimada;
	}

	public void setFechaEntregaEstimada(Date fechaEntregaEstimada) {
		this.fechaEntregaEstimada = fechaEntregaEstimada;
	}

	public float getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}

//	public List<OrdenDePedidoENT> getOrdenesDePedido() {
//		return ordenesDePedido;
//	}
//
//	public void setOrdenesDePedido(List<OrdenDePedidoENT> ordenesDePedido) {
//		this.ordenesDePedido = ordenesDePedido;
//	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ItemSolCompraENT> getItems() {
		return items;
	}

	public void setItems(List<ItemSolCompraENT> items) {
		this.items = items;
	}
	
}
