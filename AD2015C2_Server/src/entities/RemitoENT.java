package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import dominio.Cliente;
import dominio.Factura;
import dominio.ItemRemito;

@Entity
@Table (name="remitos")
public class RemitoENT {
	@Id
	@Column (name="numero_remito")
	private int numero;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="numero_sucursal", nullable = false)	
	private OVENT ov;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="numero_factura", nullable = false)
	private FacturaENT factura;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cuilCliente")
	private ClienteENT cliente;
	@Column
	private Date fechaEmision;

	@OneToMany(cascade=CascadeType.ALL ,fetch=FetchType.LAZY ,mappedBy="id.remito")
	private List<ItemRemitoENT> items;
}
