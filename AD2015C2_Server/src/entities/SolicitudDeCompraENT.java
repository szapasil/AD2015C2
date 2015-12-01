package entities;

import java.sql.Date;
import java.util.ArrayList;
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
	/*@OneToMany(cascade=CascadeType.ALL, mappedBy="numero_pedido")
	private List<OrdenDePedidoENT> ordenesDePedido;*/
	private String estado;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="id.solicitudCompra")
	private List<ItemSolCompraENT> items;

	public SolicitudDeCompraENT() {
		
	}
	
	
	
}
