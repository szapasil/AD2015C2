package dominio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordenesDeCompra")
public class OrdenDeCompra {
	
	private int numero;
	private float montoTotal;
	private Proveedor proveedor;
	private Date fecha;  
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="solicitudDeCompra")
	private SolicitudDeCompra solicitudDeCompra;
	private List<ItemOC> items; 

	public OrdenDeCompra(int numero, float montoTotal, Proveedor proveedor,
			Date fecha, SolicitudDeCompra solicitudDeCompra, List<ItemOC> items) {
		super();
		this.numero = numero;
		this.montoTotal = montoTotal;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.solicitudDeCompra = solicitudDeCompra;
		this.items = new ArrayList<ItemOC>();
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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public SolicitudDeCompra getSolicitudDeCompra() {
		return solicitudDeCompra;
	}

	public void setSolicitudDeCompra(SolicitudDeCompra solicitudDeCompra) {
		this.solicitudDeCompra = solicitudDeCompra;
	}

	public List<ItemOC> getItems() {
		return items;
	}

	public void setItems(List<ItemOC> items) {
		this.items = items;
	}
	
}
