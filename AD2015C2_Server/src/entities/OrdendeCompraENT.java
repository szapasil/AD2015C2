package entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class OrdendeCompraENT {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int numero;
	private float montoTotal;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cuitProveedor")
	private ProveedorENT proveedor;
	private Date fecha;  
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="nroSC")
	private SolicitudDeCompraENT solicitudDeCompra;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="nroOC")
	private List<ItemOCENT> items; 

	public OrdendeCompraENT(int numero, float montoTotal, ProveedorENT proveedor,
			Date fecha, SolicitudDeCompraENT solicitudDeCompra) {
		super();
		this.numero = numero;
		this.montoTotal = montoTotal;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.solicitudDeCompra = solicitudDeCompra;
		this.items = new ArrayList<ItemOCENT>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public ProveedorENT getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorENT proveedor) {
		this.proveedor = proveedor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public SolicitudDeCompraENT getSolicitudDeCompra() {
		return solicitudDeCompra;
	}

	public void setSolicitudDeCompra(SolicitudDeCompraENT solicitudDeCompra) {
		this.solicitudDeCompra = solicitudDeCompra;
	}

	public List<ItemOCENT> getItems() {
		return items;
	}

	public void setItems(List<ItemOCENT> items) {
		this.items = items;
	}
	
}
